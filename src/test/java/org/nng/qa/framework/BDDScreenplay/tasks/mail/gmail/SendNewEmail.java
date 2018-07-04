// PACKAGE
package org.nng.qa.framework.BDDScreenplay.tasks.mail.gmail;

// IMPORT SECTION
import static net.serenitybdd.screenplay.Tasks.instrumented;

import org.nng.qa.framework.BDDScreenplay.actions.WaitUntil;
import org.nng.qa.framework.BDDScreenplay.ui.GmailHomePage;
import org.nng.qa.framework.BDDScreenplay.ui.GmailLoginPage;
import org.nng.qa.framework.BDDScreenplay.ui.NewEmailUi;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Wait;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

// CLASS
public class SendNewEmail implements Task {

	// ---------------------------------
	// GLOBALS
	// --------------------------------

	String senderEmail, messageBody, subject;

	// ---------------------------------
	// CONSTRUCTOR
	// ---------------------------------
	public SendNewEmail(String senderEmail, String messageBody, String subject) {
		// DO SOMETHING
		this.senderEmail = senderEmail;
		this.messageBody = messageBody;
		this.subject = subject;
	}

	// ---------------------------------
	// TASKS
	// ---------------------------------
	@Override
	@Step("{0} Write an email and send to #senderEmail")
	public <T extends Actor> void performAs(T theActor) {
		theActor.attemptsTo(Click.on(GmailHomePage.composeButton),
				WaitUntil.elementIsClickable(NewEmailUi.NewMessagePrompt),
				Enter.theValue(messageBody).into(NewEmailUi.MessageBody),
				WaitUntil.elementIsClickable(NewEmailUi.subjectField), Click.on(NewEmailUi.subjectField),
				Enter.theValue(subject).into(NewEmailUi.subjectField),
				WaitUntil.elementIsClickable(NewEmailUi.senderEmailFieldRecipient),
				Click.on(NewEmailUi.senderEmailFieldRecipient),
				net.serenitybdd.screenplay.waits.WaitUntil.the(NewEmailUi.senderEmailFieldTo, isCurrentlyVisible()),
				Enter.theValue(senderEmail).into(NewEmailUi.senderEmailFieldTo), Click.on(NewEmailUi.sendButton),
				WaitUntil.elementIsClickable(NewEmailUi.sendMessageMassage));
	}

	// ---------------------------------
	// BUIDERS
	// ---------------------------------
	public static SendNewEmail withSendeEmailMessageAndSubjectLine(String senderEmail, String messageBody,
			String subject) {
		return instrumented(SendNewEmail.class, senderEmail, messageBody, subject);
	}

}
