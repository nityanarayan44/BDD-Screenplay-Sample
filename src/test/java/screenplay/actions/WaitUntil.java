// Package
package screenplay.actions;

// Import
import java.util.concurrent.TimeUnit;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;
import screenplay.commons.Constants;
import screenplay.config.Configuration;

// Class
public class WaitUntil implements Interaction {

	//---------------------------------------------------------
	// GLOBALs
	//---------------------------------------------------------	
	private Target target;
	private WebElementFacade targetElement;
	private int timeout;
	private String condition = Constants.DEFAULT; // DEFAULT | VISIBILITY | INVISIBILITY
	private String urlToBe;
	private Integer noOfExpectedWindow; 
	
	//---------------------------------------------------------
	// CONTRUCTORs
	//---------------------------------------------------------	
	
	public WaitUntil(Target target, int timeout, String condition) {
		this.target = target;
		this.timeout = timeout;
		this.condition = condition;
	}
	public WaitUntil(Target target, String condition) {
		this.target = target;
		this.condition = condition;
	}
	public WaitUntil(String urltobe, String condition) {
		this.urlToBe = urltobe;
		this.condition = condition;
	}
	// For the Browser window count
	public WaitUntil(Integer numberOfTabsToBe, String condition) {
		this.noOfExpectedWindow = numberOfTabsToBe;
		this.condition = condition;
	}
	
	//---------------------------------------------------------
	// Action to be perform
	//---------------------------------------------------------	
	@Override
	@Step("{0} Waits until #condition")
	public <T extends Actor> void performAs(T actor) {

		// Get the Element resolved for the actor
		if( this.target != Constants.NULL )
			targetElement = target.resolveFor(actor);

		// Switch between conditions
		switch(condition) {
			// For Visibility
			case Constants.VISIBILITY: 	
				if (!(targetElement.isCurrentlyVisible() || targetElement.isDisplayed())) {
					if (this.timeout != Constants.ZERO && this.timeout > Constants.ZERO) {
						BrowseTheWeb.as(actor).withTimeoutOf(this.timeout, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOf(targetElement));
					} else {
						BrowseTheWeb.as(actor).waitFor(ExpectedConditions.visibilityOf(targetElement));
					}
				}
				break;
				
			// For Url To be loaded
			case Constants.URL_TO_BE:
				new WebDriverWait(BrowseTheWeb.as(actor).getDriver(), Configuration.getDefaultWait()).until(ExpectedConditions.urlToBe(this.urlToBe));
				break;
			
			// For, URL Contains the Partial Url
			case Constants.URL_CONTAINS:
				new WebDriverWait(BrowseTheWeb.as(actor).getDriver(), Configuration.getDefaultWait()).until(ExpectedConditions.urlContains(this.urlToBe));
				break;
				
			// For Browser window to be expected no of windows
			case Constants.BROWSER_NO_OF_WINDOW:
				new WebDriverWait(BrowseTheWeb.as(actor).getDriver(), Configuration.getDefaultWait()).until(ExpectedConditions.numberOfWindowsToBe(this.noOfExpectedWindow));
				break;
				
			// Code For InVisibility
			case Constants.INVISIBILITY:
				if (this.timeout != Constants.ZERO && this.timeout > Constants.ZERO) {
					BrowseTheWeb.as(actor).withTimeoutOf(this.timeout, TimeUnit.SECONDS).waitFor(ExpectedConditions.invisibilityOf(targetElement));
				} else {
					BrowseTheWeb.as(actor).waitFor(ExpectedConditions.invisibilityOf(targetElement));
				}
				break;
			
			// Code for Click Ability
			case Constants.CLICKABLE:
			case Constants.DEFAULT:
				// Wait for the Element, Based on Timeout
				if(this.timeout != Constants.ZERO && this.timeout > Constants.ZERO) {
					// Click on target with timeout
					BrowseTheWeb.as(actor).withTimeoutOf(this.timeout, TimeUnit.SECONDS).waitFor(ExpectedConditions.elementToBeClickable(targetElement));
				} else {
					// Click on target without timeout
					BrowseTheWeb.as(actor).waitFor(ExpectedConditions.elementToBeClickable(targetElement));
				}
				break;
		}
	}

	//---------------------------------------------------------
	// BUILDERs
	//---------------------------------------------------------	
	
	// For Element InVisibility
	public static WaitUntil elementIsInvisibleWithTimeout(Target target, int timeout) {
		return instrumented(WaitUntil.class, target, timeout, Constants.INVISIBILITY);
		
	}
	public static WaitUntil elementIsInvisible(Target target) {
		return instrumented(WaitUntil.class, target, Constants.INVISIBILITY);
	}
	
	// For Element Visibility
	public static WaitUntil elementIsVisibleWithTimeout(Target target, int timeout) {
		return instrumented(WaitUntil.class, target, timeout, Constants.VISIBILITY);
	}
	public static WaitUntil elementIsVisible(Target target) {
		return instrumented(WaitUntil.class, target, Constants.VISIBILITY);
	}
	
	//
	// For Element Click-able
	public static WaitUntil elementIsClickableWithTimeout(Target target, int timeout) {
		return instrumented(WaitUntil.class, target, timeout, Constants.CLICKABLE);
	}
	public static WaitUntil elementIsClickable(Target target) {
		return instrumented(WaitUntil.class, target, Constants.CLICKABLE);
	}

	// For the Browser URL
	public static WaitUntil urlToBe(String urlToBe) {
		return instrumented(WaitUntil.class, urlToBe, Constants.URL_TO_BE);
	}
	public static WaitUntil urlContains(String partialUrl) {
		return instrumented(WaitUntil.class, partialUrl, Constants.URL_CONTAINS);
	}
	
	// For Browser Tabs
	public static WaitUntil numberOfWindowToBe(Integer numberOfExpectedWindows) {
		return instrumented(WaitUntil.class, numberOfExpectedWindows, Constants.BROWSER_NO_OF_WINDOW);
	}
}
