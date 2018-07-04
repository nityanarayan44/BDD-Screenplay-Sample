// PACKAGE
package screenplay.tasks.mail.gmail;

// IMPORT
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import screenplay.ui.google.GMailPage;

// CLASS
public class OpenMail implements Task {

	// ---------------------------------
	// Globals
	// ---------------------------------
	private String senderMail;
	public OpenMail(String sender) {
		this.senderMail = sender;
	}
	
	// ---------------------------------
	// TASKS
	// ---------------------------------
	@Override
	@Step("{0} Opens mail regarding password reset")
	public <T extends Actor> void performAs(T theActor) {

		// Fill the Google credentials of Users
		theActor.attemptsTo(
				// Select the reset password Mails
				WaitUntil.the(GMailPage.MAIL_RECOVERY.of(this.senderMail), isVisible()),
				Click.on(GMailPage.MAIL_RECOVERY.of(this.senderMail))
		);
		
	}
	
	// ---------------------------------
	// ---------- [BUILDERS] -----------
	// ---------------------------------	
	public static OpenMail from(String sender) {
		return instrumented(OpenMail.class, sender);
	}
}
