// PACKAGE
package org.nng.qa.framework.BDDScreenplay.tasks.mail.gmail;

// IMPORT SECTION
import static net.serenitybdd.screenplay.Tasks.instrumented;

import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.nng.qa.framework.BDDScreenplay.actions.WaitUntil;
import org.nng.qa.framework.BDDScreenplay.commons.Constants;
import org.nng.qa.framework.BDDScreenplay.ui.GmailHomePage;
import org.nng.qa.framework.BDDScreenplay.ui.GmailLoginPage;
import org.nng.qa.framework.library.utils.Manupulate;
import org.openqa.selenium.Keys;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

// CLASS
public class GmailLogin implements Task {

	// --------------------------------
	// GLOBALS
	// --------------------------------

	String userName, password;

	// ---------------------------------
	// CONSTRUCTOR
	// ---------------------------------
	public GmailLogin(String userCredentials) {
		// DO SOMETHING

		String[] credentials = Manupulate.extractUserCredentials(userCredentials);
		if (credentials.length == Constants.TWO) {
			this.userName = credentials[Constants.ZERO].toString(); // User name
			this.password = credentials[Constants.ONE].toString(); // User password
		}

	}

	// ---------------------------------
	// TASKS
	// ---------------------------------
	@Override
	@Step("{0} Login to gmail")
	public <T extends Actor> void performAs(T theActor) {
		theActor.attemptsTo(WaitUntil.elementIsClickable(GmailLoginPage.UserNameField),
				Click.on(GmailLoginPage.UserNameField),
				Enter.theValue(this.userName).into(GmailLoginPage.UserNameField).thenHit(Keys.ENTER),
				WaitUntil.elementIsClickable(GmailLoginPage.PasswordField), Click.on(GmailLoginPage.PasswordField),
				Enter.theValue(password).into(GmailLoginPage.PasswordField).thenHit(Keys.ENTER),
				WaitUntil.elementIsClickable(GmailHomePage.composeButton));
	}

	// ---------------------------------
	// BUIDERS
	// ---------------------------------
	public static GmailLogin withCredentials(String userCredentials) {
		return instrumented(GmailLogin.class, userCredentials);
	}

}
