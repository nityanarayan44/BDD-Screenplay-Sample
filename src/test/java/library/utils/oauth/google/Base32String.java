// Package
package library.utils.oauth.google;

// Import
import java.util.HashMap;

// Class
public class Base32String {

	// The Constants INSTANCE [Character Set FOR Base32 String].
	// RFC
	// 4668/3548
	private static final Base32String INSTANCE = new Base32String("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567"); 

	/**
	 * @return single instance of Base32String
	 */
	static Base32String getInstance() {
		return INSTANCE;
	}

	/** The alphabet. */
	// 32 alpha-numeric characters. Excluding 0, 1, O, and I
	private String ALPHABET;
	/** The digits. */
	private char[] DIGITS;
	/** The mask. */
	private int MASK;
	/** The shift. */
	private int SHIFT;
	/** The char map. */
	private HashMap<Character, Integer> CHAR_MAP;
	/** The Constant SEPARATOR. */
	static final String SEPARATOR = "-";

	/**
	 * Instantiates a new base 32 string.
	 *
	 * @param alphabet the alphabet
	 */
	protected Base32String(String alphabet) {
		this.ALPHABET = alphabet;
		DIGITS = ALPHABET.toCharArray();
		MASK = DIGITS.length - 1;
		SHIFT = Integer.numberOfTrailingZeros(DIGITS.length);
		CHAR_MAP = new HashMap<Character, Integer>();
		for (int i = 0; i < DIGITS.length; i++) {
			CHAR_MAP.put(DIGITS[i], i);
		}
	}

	/**
	 * Decode.
	 *
	 * @param encoded
	 *            the encoded
	 * @return the byte[]
	 * @throws DecodingException
	 *             the decoding exception
	 */
	public static byte[] decode(String encoded) throws DecodingException {
		return getInstance().decodeInternal(encoded);
	}

	/**
	 * Decode internal.
	 *
	 * @param encoded
	 *            the encoded
	 * @return the byte[]
	 * @throws DecodingException
	 *             the decoding exception
	 */
	protected byte[] decodeInternal(String encoded) throws DecodingException {
		// Remove whitespace and separators
		encoded = encoded.trim().replaceAll(SEPARATOR, "").replaceAll(" ", "");
		// Canonicalize to all upper case
		encoded = encoded.toUpperCase();
		if (encoded.length() == 0) {
			return new byte[0];
		}
		int encodedLength = encoded.length();
		int outLength = encodedLength * SHIFT / 8;
		byte[] result = new byte[outLength];
		int buffer = 0;
		int next = 0;
		int bitsLeft = 0;
		for (char c : encoded.toCharArray()) {
			if (!CHAR_MAP.containsKey(c)) {
				throw new DecodingException("Illegal character: " + c);
			}
			buffer <<= SHIFT;
			buffer |= CHAR_MAP.get(c) & MASK;
			bitsLeft += SHIFT;
			if (bitsLeft >= 8) {
				result[next++] = (byte) (buffer >> (bitsLeft - 8));
				bitsLeft -= 8;
			}
		}
		// We'll ignore leftover bits for now.
		//
		// if (next != outLength || bitsLeft >= SHIFT) {
		// throw new DecodingException("Bits left: " + bitsLeft);
		// }
		return result;
	}

	/**
	 * Encode.
	 *
	 * @param data
	 *            the data
	 * @return the string
	 */
	public static String encode(byte[] data) {
		return getInstance().encodeInternal(data);
	}

	/**
	 * Encode internal.
	 *
	 * @param data
	 *            the data
	 * @return the string
	 */
	protected String encodeInternal(byte[] data) {
		if (data.length == 0) {
			return "";
		}
		// SHIFT is the number of bits per output character, so the length of the
		// output is the length of the input multiplied by 8/SHIFT, rounded up.
		if (data.length >= (1 << 28)) {
			// The computation below will fail, so don't do it.
			throw new IllegalArgumentException();
		}
		int outputLength = (data.length * 8 + SHIFT - 1) / SHIFT;
		StringBuilder result = new StringBuilder(outputLength);
		int buffer = data[0];
		int next = 1;
		int bitsLeft = 8;
		while (bitsLeft > 0 || next < data.length) {
			if (bitsLeft < SHIFT) {
				if (next < data.length) {
					buffer <<= 8;
					buffer |= (data[next++] & 0xff);
					bitsLeft += 8;
				} else {
					int pad = SHIFT - bitsLeft;
					buffer <<= pad;
					bitsLeft += pad;
				}
			}
			int index = MASK & (buffer >> (bitsLeft - SHIFT));
			bitsLeft -= SHIFT;
			result.append(DIGITS[index]);
		}
		return result.toString();
	}

	@Override
	// enforce that this class is a singleton
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	/**
	 * The Class DecodingException.
	 */
	@SuppressWarnings("serial")
	public static class DecodingException extends Exception {
		/**
		 * Instantiates a new decoding exception.
		 *
		 * @param message
		 *            the message
		 */
		public DecodingException(String message) {
			super(message);
		}
	}
}
