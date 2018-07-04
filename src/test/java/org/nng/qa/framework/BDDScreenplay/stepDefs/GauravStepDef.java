package org.nng.qa.framework.BDDScreenplay.stepDefs;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import org.nng.qa.framework.BDDScreenplay.commons.Constants;
import org.nng.qa.framework.BDDScreenplay.config.Configuration;
import org.nng.qa.framework.BDDScreenplay.questions.Browser;
import org.nng.qa.framework.BDDScreenplay.tasks.gauravTask.EmailWriteAndSend;
import org.nng.qa.framework.BDDScreenplay.tasks.gauravTask.GmailLogin;

import cucumber.api.java.en.*;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.OpenUrl;

public class GauravStepDef {

	@Given("^User open gmail url$")
	public void user_open_gmail_url() throws Throwable {
		CommonSteps.initiateActor("Gaurav");
		theActorInTheSpotlight().wasAbleTo(Open.url(Constants.GMAIL_URL));
	}

	@When("^User should able to see compose button to send an email from gmail with user \"([^\"]*)\"$")
	public void user_should_able_to_see_compose_button_to_send_an_email_from_gmail_with_user(String user)
			throws Exception {
		theActorInTheSpotlight().attemptsTo(GmailLogin.withCredentials(Configuration.getValueFromConfigurations(user)));
	}

	@When("^User should able to write mail and send from gmail to \"([^\"]*)\" with message \"([^\"]*)\" and with subject \"([^\"]*)\"$")
	public void user_should_able_to_write_mail_and_send_from_gmail_to_with_message_and_with_subject(String arg1,
			String arg2, String arg3) throws Exception {
		theActorInTheSpotlight().attemptsTo(EmailWriteAndSend.withSendeEmailMessageAndSubjectLine(arg1, arg2, arg3));
	}


}
