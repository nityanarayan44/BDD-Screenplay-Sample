//---------------------------------------------------------
// Package
//---------------------------------------------------------
package org.nng.qa.framework.library.utils;

//---------------------------------------------------------
// Imports
//---------------------------------------------------------
import org.apache.commons.lang3.RandomStringUtils;
import org.nng.qa.framework.BDDScreenplay.commons.Constants;

// Class
@SuppressWarnings("deprecation")
public class Manupulate {

	/** 
	 * ==============================================
	 * Function to Generate random alpha numeric string.
	 * ==============================================
	 */
	public static String generateRandomAlphaNumericString(int length) {
		return RandomStringUtils.randomAlphanumeric(length).toUpperCase();
	}
	
	/** 
	 * ==============================================
	 * Function to Generate random 3D Password
	 * ==============================================
	 */
	public static String generate3DPassword(int length) {
		String symbols = "&!@#$%^", numbers = "0123456789";
		String output = "Hi@01"; // By Default [HARD CODED]
		if(length > Constants.FIVE) {
			output = RandomStringUtils.randomAlphanumeric(length - Constants.TWO) 
					+ symbols.charAt( (int)(Math.ceil(Math.random()) % symbols.length()) )
					+ numbers.charAt( (int)(Math.ceil(Math.random()) % numbers.length()) );
		}
		// Return the 3D Password
		return output;
	}

	/** 
	 * ==============================================
	 * Function to remove the new line from a string
	 * ==============================================
	 */
	public static String removeReturns(String text) {
		return text.replaceAll(System.lineSeparator(), "").replaceAll(Constants.NEWLINE, "");
	}
	
	/** 
	 * ==============================================
	 * Function to Extract user/pass/secret from a string
	 * ==============================================
	 */
	public static String[] extractUserCredentials(String text) {
		return text.split(Constants.SEPERATOR);
	}

}
