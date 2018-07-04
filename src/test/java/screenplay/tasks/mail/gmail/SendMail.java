// PACKAGE
package screenplay.tasks.mail.gmail;

// IMPORT
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import screenplay.ui.google.GMailPage;

// CLASS
public class SendMail implements Task {

	// ---------------------------------
	// Globals
	// ---------------------------------
	private String reciever, mailSubject, mailBody;
	public SendMail(String to, String subject, String body) {
		this.reciever = to;
		this.mailSubject = subject;
		this.mailBody = body;
	}
	
	// ---------------------------------
	// TASKS
	// ---------------------------------
	@Override
	@Step("{0} Opens mail regarding password reset")
	public <T extends Actor> void performAs(T theActor) {

		// COMPOSE
		theActor.attemptsTo(
				// CLICK ON COMPOSE BUTTON
				WaitUntil.the(GMailPage.COMPOSE_BUTTON, isVisible()),
				Click.on(GMailPage.COMPOSE_BUTTON),
				// SET RECIPIENT
				WaitUntil.the(GMailPage.COMPOSE_MAIL_TO, isVisible()),
				Enter.theValue(this.reciever).into(GMailPage.COMPOSE_MAIL_TO),
				// SET SUBJECT
				WaitUntil.the(GMailPage.COMPOSE_MAIL_SUBJECT, isVisible()),
				Enter.theValue(this.mailSubject).into(GMailPage.COMPOSE_MAIL_SUBJECT),
				// SET THE BODY
				WaitUntil.the(GMailPage.COMPOSE_MAIL_BODY, isVisible()),
				Enter.theValue(this.mailBody).into(GMailPage.COMPOSE_MAIL_BODY),
				// SEND MAIL
				WaitUntil.the(GMailPage.SEND_MAIL, isVisible()),
				Click.on(GMailPage.SEND_MAIL)
		);
		
	}
	
	// ---------------------------------
	// ---------- [BUILDERS] -----------
	// ---------------------------------	
	public static SendMail with(String sender, String subject, String body) {
		return instrumented(SendMail.class, sender, subject, body);
	}
}
