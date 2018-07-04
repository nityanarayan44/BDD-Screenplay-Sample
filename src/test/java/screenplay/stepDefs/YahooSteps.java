package screenplay.stepDefs;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import screenplay.commons.Constants;
import screenplay.config.Configuration;
import screenplay.questions.TextOf;
import screenplay.questions.yahoo.ReadYahoo;
import screenplay.tasks.yahoo.ComposeEmail;
import screenplay.tasks.yahoo.Login;
import screenplay.ui.yahoo.Yahoo;

public class YahooSteps {

	
	@Given("^\"([^\"]*)\" is on \"([^\"]*)\" page$")
	public void i_am_on_yahoo_page(String actorName, String page) throws Throwable {
		CommonSteps.initiateActor(actorName);
		theActorInTheSpotlight().has(Open.url(Configuration.getValueFromConfigurations(page)));
	}

	@When("^he signs in as \"([^\"]*)\"$")
	public void i_sign_in(String user) throws Exception {
		theActorInTheSpotlight().attemptsTo(Login.as(Configuration.getValueFromConfigurations(user)));

	}
	
	@When("^he sends email$")
	public void he_sends_email(List<List<String>> emailData) throws Exception {
		
		theActorInTheSpotlight().attemptsTo(ComposeEmail.sendEmail(emailData.get(Constants.ONE).get(Constants.ZERO), emailData.get(Constants.ONE).get(Constants.ONE), emailData.get(Constants.ONE).get(Constants.TWO)));
	}

	@Then("^he should see inbox with \"([^\"]*)\" mail button$")
	public void i_should_see_inbox(String button) throws Exception {
		theActorInTheSpotlight().should(seeThat(new TextOf(Yahoo.COMPOSE_BTN), equalTo(button)));
	}
	
	@Then("^read yahoo email with subject \"([^\"]*)\"$")
	public void read_yahoo_email_with_subject(String subject) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		theActorInTheSpotlight().should(seeThat(ReadYahoo.mail(subject), containsString("Hello")));

	}

}
