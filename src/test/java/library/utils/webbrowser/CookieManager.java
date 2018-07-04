// PACKAGE
package library.utils.webbrowser;

// IMPORT SECTION
import java.util.HashMap;
import java.util.Set;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import screenplay.commons.Constants;

// CLASS
public class CookieManager {
	//---------------------------------------------------------
	// Global
	//---------------------------------------------------------	
	public static HashMap<String, Set<Cookie>> browserCookies = new HashMap<String, Set<Cookie>>();
	public static boolean IS_COOKIE_AVAILABLE = false;
	private static String LOGGER_TEMPLATE = ">>>>> [CookieManager] " ;
	
	//---------------------------------------------------------
	// Logger
	//---------------------------------------------------------
	private static Logger logger = LoggerFactory.getLogger(CookieManager.class);

	//---------------------------------------------------------
	// Constructor
	//---------------------------------------------------------
	public CookieManager() {
		CookieManager.browserCookies = new HashMap<String, Set<Cookie>>();
	}
	
	//---------------------------------------------------------
	// Get the Cookies
	//---------------------------------------------------------
	public static void extractCookiesFor(WebDriver driver, String userId) {
		logger.info(CookieManager.LOGGER_TEMPLATE + " [" + CookieManager.class.getName() +"] Getting Browser Cookies .....");
		CookieManager.browserCookies.put(userId, driver.manage().getCookies() );
		if(CookieManager.browserCookies.get(userId) == Constants.NULL) { 
			logger.info(CookieManager.LOGGER_TEMPLATE + " :: Empty Cookies, Session not started yet.");
			// Mark, Cookie is not available for use
			CookieManager.IS_COOKIE_AVAILABLE = false;
		} else {
			// Log out all the Cookies: [Lambda approach]
			CookieManager.browserCookies.get(userId).stream().forEach((cookie) -> System.out.println(CookieManager.LOGGER_TEMPLATE + " [Found Cookie] Name:: " + cookie.getName() + ", Value:: " + cookie.getValue()));
			// Mark, Cookie is available for use
			CookieManager.IS_COOKIE_AVAILABLE = true;
		}
		
	}
	
	//---------------------------------------------------------
	// Set the Cookies now
	//---------------------------------------------------------
	public static WebDriver setCookies(WebDriver driver, String userId) {
		logger.info(CookieManager.LOGGER_TEMPLATE + " [" + CookieManager.class.getName() +"] Setting Browser Cookies for " + userId + " .....");
		if(CookieManager.IS_COOKIE_AVAILABLE && CookieManager.browserCookies.get(userId) != Constants.NULL) {
			// Add all cookies to the provided browser
			CookieManager.browserCookies.get(userId).stream().forEach((cookie) -> {
				// If Cookies are not empty, then add them
				if(!cookie.equals(Constants.NULL)) { driver.manage().addCookie(cookie); }
				// Else, just log a message about it
				else { logger.info(CookieManager.LOGGER_TEMPLATE + " Oopse, Empty Cookie found. Don't woory, It won't be inserted."); }
			});
		} else { 
			logger.info(CookieManager.LOGGER_TEMPLATE + "No Cookie found Or Cookies are just vanished/Null for this user."); 
		}
		
		// Return the driver, loaded with cookies
		return driver;
	}
	
}
