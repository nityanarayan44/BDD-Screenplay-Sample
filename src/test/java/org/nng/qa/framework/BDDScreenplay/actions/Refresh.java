// Package
package org.nng.qa.framework.BDDScreenplay.actions;

// Import Section
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Step;

// Class
public class Refresh implements Interaction {


	//---------------------------------------------------------
	// Action Task to perform
	//---------------------------------------------------------	
	@Override
	@Step("{0} refreshes the browser's current tab")
	public <T extends Actor> void performAs(T actor) {
		BrowseTheWeb.as(actor).getDriver().navigate().refresh();
	}

	//---------------------------------------------------------
	// Action Builders
	//---------------------------------------------------------
	public static Refresh theBrowserSession() {
		return new Refresh();
	}
}
