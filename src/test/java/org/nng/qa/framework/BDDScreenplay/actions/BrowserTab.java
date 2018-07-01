// Package
package org.nng.qa.framework.BDDScreenplay.actions;

// Import Section
import java.util.ArrayList;
import org.nng.qa.framework.BDDScreenplay.commons.Constants;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Step;

// Class
public class BrowserTab implements Interaction {

	//---------------------------------------------------------
	// GLOBALs
	//---------------------------------------------------------	
	public static String winHandleBefore;
	private String condition;

	//---------------------------------------------------------
	// GLOBALs
	//---------------------------------------------------------	
	public BrowserTab(String givenCondition) { this.condition = givenCondition; }
	
	//---------------------------------------------------------
	// Action to perform
	//---------------------------------------------------------	
	@Override
	@Step("{0} switches to next browser window")
	public <T extends Actor> void performAs(T actor) {
		
		// Now get the list of all the tabs of browser
		ArrayList<String> browserTabsList = new ArrayList<String>(BrowseTheWeb.as(actor).getDriver().getWindowHandles());
		// Get the Currently active Browser Tab
		String activeTab = BrowseTheWeb.as(actor).getDriver().getWindowHandle();
		// Get the current tab's Index position
		int currentTabIndex = Constants.ZERO;
		for(String tab : browserTabsList) {
			if(tab.equals(activeTab)) {
				break;
			}
			currentTabIndex++;
		}
		
		// Switch Tabs according to Condition
		switch(this.condition) {
			case Constants.BROWSER_FORWARD_TAB:
				// if Current tab is not last tab then
				if(currentTabIndex < browserTabsList.size() - Constants.ONE)
					BrowseTheWeb.as(actor).getDriver().switchTo().window(browserTabsList.get(currentTabIndex + Constants.ONE));
				else
					// Its the last tab already
				break;
			case Constants.BROWSER_BACKWARD_TAB:
				// if Current tab is not first tab then
				if(currentTabIndex > Constants.ZERO)
					BrowseTheWeb.as(actor).getDriver().switchTo().window(browserTabsList.get(currentTabIndex - Constants.ONE));
				else
					// Its the last tab already
				break;
			case Constants.BROWSER_FIRST_TAB:
			default:
				// remove the current tab
				browserTabsList.remove(activeTab);
				// change focus to First tab from the Browsers tab list
				BrowseTheWeb.as(actor).getDriver().switchTo().window(browserTabsList.get(Constants.ZERO));
		}
		
		
	}

	//---------------------------------------------------------
	// Action Builder Pattern
	//---------------------------------------------------------
	public static BrowserTab switchToFirstTab() {
		return new BrowserTab(Constants.BROWSER_FIRST_TAB);
	}
	public static BrowserTab switchToForwardTab() {
		return new BrowserTab(Constants.BROWSER_FORWARD_TAB);
	}
	public static BrowserTab switchToBackwardTab() {
		return new BrowserTab(Constants.BROWSER_BACKWARD_TAB);
	}

}
