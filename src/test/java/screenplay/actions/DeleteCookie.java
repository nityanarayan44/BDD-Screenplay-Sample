// Package
package screenplay.actions;

// Import Section
import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Step;
import screenplay.commons.Constants;

// Class
public class DeleteCookie implements Interaction {
	//---------------------------------------------------------
	// GLOBALs
	//---------------------------------------------------------	
	private String cookieNameToBeDeleted;
	//---------------------------------------------------------
	// Constructors
	//---------------------------------------------------------		
	public DeleteCookie() {}
	public DeleteCookie(String cookieName) { this.cookieNameToBeDeleted = cookieName; }
	
	//---------------------------------------------------------
	// GLOBALs
	//---------------------------------------------------------	
	@Override
	@Step("{0} deletes the cookie")
	@Screenshots(disabled = true)
	public <T extends Actor> void performAs(T actor) {
		// Wait for the Element, Based on Timeout
		if(this.cookieNameToBeDeleted != Constants.NULL) {
			// Delete specific cookie
			BrowseTheWeb.as(actor).getDriver().manage().deleteCookieNamed(cookieNameToBeDeleted);
		} else {
			// Delete all cookies
			BrowseTheWeb.as(actor).getDriver().manage().deleteAllCookies();
		}
	}

	//---------------------------------------------------------
	// Action Builders
	//---------------------------------------------------------		
	public static DeleteCookie all() {
		return instrumented(DeleteCookie.class);
	}
	public static DeleteCookie byName(String cookieName) {
		return instrumented(DeleteCookie.class, cookieName);
	}
}
