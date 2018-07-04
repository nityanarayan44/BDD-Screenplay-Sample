package org.nng.qa.framework.BDDScreenplay.stepDefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import cucumber.api.java.en.Then;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

import org.nng.qa.framework.BDDScreenplay.config.Configuration;
import org.nng.qa.framework.BDDScreenplay.questions.TextOf;
import org.nng.qa.framework.BDDScreenplay.tasks.yahoo.Login;
import org.nng.qa.framework.BDDScreenplay.ui.yahoo.Yahoo;

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

	@Then("^he should see inbox with \"([^\"]*)\" mail button$")
	public void i_should_see_inbox(String button) throws Exception {
		theActorInTheSpotlight().should(seeThat(new TextOf(Yahoo.COMPOSE_BTN), equalTo(button)));
	}

}
