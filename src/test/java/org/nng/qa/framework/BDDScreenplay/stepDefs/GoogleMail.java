//---------------------------------
// Package
//---------------------------------
package org.nng.qa.framework.BDDScreenplay.stepDefs;

//---------------------------------
// Import Section
//---------------------------------
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import org.nng.qa.framework.BDDScreenplay.actions.Navigate;
import org.nng.qa.framework.BDDScreenplay.commons.Constants;
import org.nng.qa.framework.BDDScreenplay.config.Configuration;
import org.nng.qa.framework.BDDScreenplay.tasks.login.google.GMailLogin;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

//---------------------------------
// Class
//---------------------------------
public class GoogleMail {

	// Global
	//---------------------------------
	
	// Before Methods 
	//---------------------------------
    	@Before
    	public void set_the_stage() {
		OnStage.setTheStage(new OnlineCast());
    	}
    
	@Given("^User is on Gmail home page as a \"([^\"]*)\"$")
	public void NavigateToTheApplication(String actorName) throws Throwable {
        // Opens a specific URL
		//theActorCalled(actorName);
		theActorCalled(actorName).wasAbleTo(Navigate.to(Constants.GMAIL_URL));
	}
	
	@When("^User has access of gmail as \"([^\"]*)\"$")
	public void googleLoginAccessAsUser(String user){
	    // LogIn to the Google Mail 
		theActorInTheSpotlight().attemptsTo( GMailLogin.with( Configuration.getValueFromConfigurations(user) ) );
	}
	
	@Then("^User should see list of mails$")
	public void shouldSeeLandingPage(){
		//
	}
} 
