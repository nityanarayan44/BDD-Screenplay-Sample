//---------------------------------
// Package
//---------------------------------
package org.nng.qa.framework.BDDScreenplay.stepDefs;

//---------------------------------
// Import Section
//---------------------------------
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import org.nng.qa.framework.BDDScreenplay.config.Configuration;
import org.nng.qa.framework.BDDScreenplay.tasks.login.google.GMailLogin;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

//---------------------------------
// Class
//---------------------------------
public class GoogleMail {

	//---------------------------------
	// Step Functions
	//---------------------------------
	
	@When("^User logIn to gmail as \"([^\"]*)\"$")
	public void googleLoginAccessAsUser(String user){
	    // LogIn to the Google Mail 
		theActorInTheSpotlight().attemptsTo( GMailLogin.with( Configuration.getValueFromConfigurations(user) ) );
	}
	
	@Then("^User should see list of mails$")
	public void shouldSeeLandingPage(){
		//
	}
} 
