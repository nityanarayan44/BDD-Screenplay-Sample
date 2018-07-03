/**
 * @author Ashutosh Mishra
 * @desc Extract and build the date and time accordingly.
 */
package org.nng.qa.framework.library.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateAndTime {

	/*
	 * --------------------------------
	 *  Get the date and time
	 * --------------------------------
	 */
		//Date pattern
		public String defaultPattern = "dd_MM_yyyy";
	
		//Get Current data
		public String getCurrentDateAsD_M_Y() {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern(this.defaultPattern);
			LocalDate localDate = LocalDate.now();
			String current_Date = dtf.format(localDate);
			return current_Date;
		}
		/**
		 * @desc User defined pattern Like: [dd-MM-yyyy, dd/MM/yyyy, dd MM yyyy]
		 * @param pattern
		 * @return current date with the specified date pattern
		 */
		public String getCurrentDateAsD_M_Y(String pattern) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
			LocalDate localDate = LocalDate.now();
			String current_Date = dtf.format(localDate);
			return current_Date;
		}
		
		// Get Past date.
		public String getPreviousDateByDays(long forDays) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern(this.defaultPattern);
			LocalDate localDate = LocalDate.now();
			String previous_Date = dtf.format(localDate.minusDays(forDays));
			return previous_Date;
		}
		
		public String getPreviousDateByMonths(long forMonths) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern(this.defaultPattern);
			LocalDate localDate = LocalDate.now();
			String previous_Date = dtf.format(localDate.minusMonths(forMonths));
			return previous_Date;
		}
		
		public String getPreviousDateByWeeks(long forWeeks) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern(this.defaultPattern);
			LocalDate localDate = LocalDate.now();
			String previous_Date = dtf.format(localDate.minusWeeks(forWeeks));
			return previous_Date;
		}
		
		public String getPreviousDateByYears(long forYears) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern(this.defaultPattern);
			LocalDate localDate = LocalDate.now();
			String previous_Date = dtf.format(localDate.minusYears(forYears));
			return previous_Date;
		}
		
		// Get future date.
		public String getFutureDateByDays(long forDays) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern(this.defaultPattern);
			LocalDate localDate = LocalDate.now();
			String future_Date = dtf.format(localDate.plusDays(forDays));
			return future_Date;
		}
		
		public String getFutureDateByMonths(long forMonths) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern(this.defaultPattern);
			LocalDate localDate = LocalDate.now();
			String future_Date = dtf.format(localDate.plusMonths(forMonths));
			return future_Date;
		}
		
		public String getFutureDateByWeeks(long forWeeks) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern(this.defaultPattern);
			LocalDate localDate = LocalDate.now();
			String future_Date = dtf.format(localDate.plusWeeks(forWeeks));
			return future_Date;
		}
		
		public String getFutureDateByYears(long forYears) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern(this.defaultPattern);
			LocalDate localDate = LocalDate.now();
			String future_Date = dtf.format(localDate.plusYears(forYears));
			return future_Date;
		}
		
}
