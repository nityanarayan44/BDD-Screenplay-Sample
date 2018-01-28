package org.nng.BDDScreenplay.example1.actions;

import java.util.ArrayList;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class SwitchTabs implements Interaction {
	
	static String winHandleBefore;

	@Override
    public <T extends Actor> void performAs(T actor) {
		/*
		// Store the current window handle
		String winHandleBefore = BrowseTheWeb.as(actor).getDriver().getWindowHandle();

		// Switch to new window opened
		for (String winHandle : BrowseTheWeb.as(actor).getDriver().getWindowHandles()) {
			BrowseTheWeb.as(actor).getDriver().switchTo().window(winHandle);
		}
		*/
		
	    String oldTab = BrowseTheWeb.as(actor).getDriver().getWindowHandle();
	    ArrayList<String> newTab = new ArrayList<String>(BrowseTheWeb.as(actor).getDriver().getWindowHandles());
	    newTab.remove(oldTab);
	    // change focus to new tab
	    BrowseTheWeb.as(actor).getDriver().switchTo().window(newTab.get(0));
    }

    public static SwitchTabs switchTabs() {
        return new SwitchTabs();
    }

}
