// PACKAGE
package screenplay.tasks.mail.gmail;

// IMPORT SECTION
import static net.serenitybdd.screenplay.Tasks.instrumented;

import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.openqa.selenium.Keys;

import library.utils.Manupulate;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import screenplay.actions.WaitUntil;
import screenplay.commons.Constants;
import screenplay.ui.GmailHomePage;
import screenplay.ui.GmailLoginPage;

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
