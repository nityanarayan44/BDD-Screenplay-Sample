// Package
package library.utils.oauth.google;

// Import
import java.security.GeneralSecurityException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import library.utils.oauth.google.Base32String;
import library.utils.oauth.google.PasscodeGenerator;

// Class
public class Compute {

	// Computing PIN for Google A/c
	public static String computePinFromSecret(String secret) {
		// Check the secret
		if (secret == null || secret.length() == 0) {
			return "Null or empty secret";
		}
		// Compute the PIN
		try {
			final byte[] keyBytes = Base32String.decode(secret);
			Mac mac = Mac.getInstance("HMACSHA1");
			mac.init(new SecretKeySpec(keyBytes, ""));
			PasscodeGenerator pcg = new PasscodeGenerator(mac);
			return pcg.generateTimeoutCode();
		} catch (GeneralSecurityException e) {
			return "General security exception";
		} catch (Base32String.DecodingException e) {
			return "Decoding exception";
		}
	}
	
} // EOClass
