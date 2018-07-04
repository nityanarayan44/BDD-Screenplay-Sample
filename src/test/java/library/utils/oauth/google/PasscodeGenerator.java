package library.utils.oauth.google;

import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.crypto.Mac;

/**
 * The Class PasscodeGenerator.
 */
public class PasscodeGenerator {
  /** The Constant PASS_CODE_LENGTH. */
  private static final int PASS_CODE_LENGTH = 6;
  /** The Constant INTERVAL. */
  private static final int INTERVAL = 30;
  /** The Constant ADJACENT_INTERVALS. */
  private static final int ADJACENT_INTERVALS = 1;
  /** The Constant PIN_MODULO. */
  private static final int PIN_MODULO = (int) Math.pow(10, PASS_CODE_LENGTH);
  /** The signer. */
  private final Signer signer;
  /** The code length. */
  private final int codeLength;
  /** The interval period. */
  private final int intervalPeriod;

  /**
   * The Interface Signer.
   */
  /*
   * Using an interface to allow us to inject different signature implementations.
   */
  interface Signer {
    /**
     * Sign.
     *
     * @param data the data
     * @return the byte[]
     * @throws GeneralSecurityException the general security exception
     */
    byte[] sign(byte[] data) throws GeneralSecurityException;
  }

  /**
   * Instantiates a new passcode generator.
   *
   * @param mac the mac
   */
  public PasscodeGenerator(Mac mac) {
    this(mac, PASS_CODE_LENGTH, INTERVAL);
  }

  /**
   * Instantiates a new passcode generator.
   *
   * @param mac the mac
   * @param passCodeLength the pass code length
   * @param interval the interval
   */
  public PasscodeGenerator(final Mac mac, int passCodeLength, int interval) {
    this(new Signer() {
      public byte[] sign(byte[] data) {
        return mac.doFinal(data);
      }
    }, passCodeLength, interval);
  }

  /**
   * Instantiates a new passcode generator.
   *
   * @param signer the signer
   * @param passCodeLength the pass code length
   * @param interval the interval
   */
  public PasscodeGenerator(Signer signer, int passCodeLength, int interval) {
    this.signer = signer;
    this.codeLength = passCodeLength;
    this.intervalPeriod = interval;
  }

  /**
   * Pad output.
   *
   * @param value the value
   * @return the string
   */
  private String padOutput(int value) {
    String result = Integer.toString(value);
    for (int i = result.length(); i < codeLength; i++) {
      result = "0" + result;
    }
    return result;
  }

  /**
   * Generate timeout code.
   *
   * @return the string
   * @throws GeneralSecurityException the general security exception
   */
  public String generateTimeoutCode() throws GeneralSecurityException {
    return generateResponseCode(clock.getCurrentInterval());
  }

  /**
   * Generate response code.
   *
   * @param challenge the challenge
   * @return the string
   * @throws GeneralSecurityException the general security exception
   */
  public String generateResponseCode(long challenge) throws GeneralSecurityException {
    byte[] value = ByteBuffer.allocate(8).putLong(challenge).array();
    return generateResponseCode(value);
  }

  /**
   * Generate response code.
   *
   * @param challenge the challenge
   * @return the string
   * @throws GeneralSecurityException the general security exception
   */
  public String generateResponseCode(byte[] challenge) throws GeneralSecurityException {
    byte[] hash = signer.sign(challenge);
    // Dynamically truncate the hash
    // OffsetBits are the low order bits of the last byte of the hash
    int offset = hash[hash.length - 1] & 0xF;
    // Grab a positive integer value starting at the given offset.
    int truncatedHash = hashToInt(hash, offset) & 0x7FFFFFFF;
    int pinValue = truncatedHash % PIN_MODULO;
    return padOutput(pinValue);
  }

  /**
   * Hash to int.
   *
   * @param bytes the bytes
   * @param start the start
   * @return the int
   */
  private int hashToInt(byte[] bytes, int start) {
    DataInput input =
        new DataInputStream(new ByteArrayInputStream(bytes, start, bytes.length - start));
    int val;
    try {
      val = input.readInt();
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
    return val;
  }

  /**
   * Verify response code.
   *
   * @param challenge the challenge
   * @param response the response
   * @return true, if successful
   * @throws GeneralSecurityException the general security exception
   */
  public boolean verifyResponseCode(long challenge, String response)
      throws GeneralSecurityException {
    String expectedResponse = generateResponseCode(challenge);
    return expectedResponse.equals(response);
  }

  /**
   * Verify timeout code.
   *
   * @param timeoutCode the timeout code
   * @return true, if successful
   * @throws GeneralSecurityException the general security exception
   */
  public boolean verifyTimeoutCode(String timeoutCode) throws GeneralSecurityException {
    return verifyTimeoutCode(timeoutCode, ADJACENT_INTERVALS, ADJACENT_INTERVALS);
  }

  /**
   * Verify timeout code.
   *
   * @param timeoutCode the timeout code
   * @param pastIntervals the past intervals
   * @param futureIntervals the future intervals
   * @return true, if successful
   * @throws GeneralSecurityException the general security exception
   */
  public boolean verifyTimeoutCode(String timeoutCode, int pastIntervals, int futureIntervals)
      throws GeneralSecurityException {
    long currentInterval = clock.getCurrentInterval();
    String expectedResponse = generateResponseCode(currentInterval);
    if (expectedResponse.equals(timeoutCode)) {
      return true;
    }
    for (int i = 1; i <= pastIntervals; i++) {
      String pastResponse = generateResponseCode(currentInterval - i);
      if (pastResponse.equals(timeoutCode)) {
        return true;
      }
    }
    for (int i = 1; i <= futureIntervals; i++) {
      String futureResponse = generateResponseCode(currentInterval + i);
      if (futureResponse.equals(timeoutCode)) {
        return true;
      }
    }
    return false;
  }

  /** The clock. */
  private IntervalClock clock = new IntervalClock() {
    /*
     * @return The current interval
     */
    public long getCurrentInterval() {
      long currentTimeSeconds = System.currentTimeMillis() / 1000;
      return currentTimeSeconds / getIntervalPeriod();
    }

    public int getIntervalPeriod() {
      return intervalPeriod;
    }
  };

  /**
   * The Interface IntervalClock.
   */
  // To facilitate injecting a mock clock
  interface IntervalClock {
    /**
     * Gets the interval period.
     *
     * @return the interval period
     */
    int getIntervalPeriod();

    /**
     * Gets the current interval.
     *
     * @return the current interval
     */
    long getCurrentInterval();
  }
}
