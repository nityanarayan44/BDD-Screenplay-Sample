/**
 * @author Ashutosh Mishra
 * @package com.socialcode.utils
 * @desc Contains the Utils for the conversion problems
 */

// Package
	package org.nng.utils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
// Import
	import java.util.regex.Matcher;
	import java.util.regex.Pattern;

// Class
public class Conversions {

	/**
	 * @author Ashutosh Mishra
	 * @param str
	 * @return
	 * @throws Exception
	 * @desc Process a passed string and return a number if that string contains any number from starting point
	 * like: 
	 * String = 2.39K will be processed and returned as 2.39
	 * String = K2.39 will be processed and returned as 0.0
	 */
	public static double stringWithAlphabetsToNumber(String str) throws Exception {
		// Local Variables
			double result = 0;
		
		// Processing [Setting pattern for any alphabets]
			Pattern pattern = Pattern.compile("[a-zA-Z]+");
			Matcher matcher = pattern.matcher(str);
			if (matcher.find()) {
				// If index is not from starting then typecast to double else set 0.0
				if(matcher.start() > 0) { result = Double.parseDouble(str.substring(0, matcher.start() )); } else { result = 0.0; }
			} else {
				// No words has been found
				result = Double.parseDouble(str);
			}
	
		// Return
			return result;
	}
	
	
	public static List<String>  descendingStringListContainingNumbers(List<String> list) {
	  
	  Collections.sort(list, new Comparator<String>() {
	      public int compare(String o1, String o2) {
	          return extractInt(o1) - extractInt(o2);
	      }
	      int extractInt(String s) {
	        //Remove all non digit
	          String num = s.replaceAll("\\D", "");
	          // return 0 if no digits found
	          return num.isEmpty() ? 0 : Integer.parseInt(num);
	      }
	  });
	    Collections.reverse(list);
      return list;
	    
	}
	
public static List<String>  ascendingStringListContainingNumbers(List<String> list) {
      
      Collections.sort(list, new Comparator<String>() {
          public int compare(String o1, String o2) {
              return extractInt(o1) - extractInt(o2);
          }
          int extractInt(String s) {
            //Remove all non digit
              String num = s.replaceAll("\\D", "");
              // return 0 if no digits found
              return num.isEmpty() ? 0 : Integer.parseInt(num);
          }
      });
      return list;
        
    }

	
}/* EOC*/
