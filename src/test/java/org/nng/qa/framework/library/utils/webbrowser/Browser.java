// Package
package org.nng.qa.framework.library.utils.webbrowser;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Import Section

//Class
public class Browser {

	// LOGGER
	private static final Logger logger = LoggerFactory.getLogger(Browser.class);

	// FUNCTIONS
	public void verifyNumberOfWindowsOpen(WebDriver driver, int numberOfWindows, long timeout) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.numberOfWindowsToBe(numberOfWindows));
	}
	public void verifyUrl(WebDriver driver, String url, long timeout) {
		// wait till url matches with expected url
		new WebDriverWait(driver, timeout).until(ExpectedConditions.urlToBe(url));
	}
	public void verifyUrlContains(WebDriver driver, String url, long timeout) {
		// wait till url matches with expected url
		new WebDriverWait(driver, timeout).until(ExpectedConditions.urlContains(url));
	}

	public void deleteCookie(WebDriver driver, String loginCookieName) {
		// delete the login cookie
		driver.manage().deleteCookieNamed(loginCookieName);
	}
	
	public void deleteLocalStorage(WebDriver driver) {
		// initialize js executor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// clear local session storage
		js.executeScript(String.format("window.localStorage.clear();"));
	}
	public void refresh(WebDriver driver) {
		// refresh the current page
		driver.navigate().refresh();
	}
	public void switchTabs(WebDriver driver) {
		// Switch to new window opened
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	}
	
	public void checkAlert(WebDriver driver, long timeout) {
		try {
			// wait until timeout defined in config
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.alertIsPresent());
			// if alert is found switch to it
			Alert alert = driver.switchTo().alert();
			// accept alert
			alert.accept();
		} catch (Exception e) {
			logger.info(e.getMessage());
			logger.info("Error while closing alert windows/window not found.");
		}
	}

	public void navigateToPage(WebDriver driver, String pageUrl) {
		// Navigate to webpage after loading value from config
		driver.navigate().to(pageUrl);
	}
	
}

