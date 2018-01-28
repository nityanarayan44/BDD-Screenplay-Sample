// Package
package org.nng.utils;

// Imports

// Class
public class Random {

	/**
	 * @param String
	 * @throws Exception
	 * @return String
	 * @desc returns the random generated string prefixed with the provided string
	 */
	public static String getNameWithPrefix(String prefix) throws Exception {
		return (prefix+"-"+System.currentTimeMillis()).toString();
	}
}
