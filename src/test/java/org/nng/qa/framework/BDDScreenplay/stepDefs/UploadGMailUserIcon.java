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
import org.nng.qa.framework.BDDScreenplay.tasks.mail.gmail.OpenMail;
import org.nng.qa.framework.BDDScreenplay.tasks.setting.google.UpdateGoogleUserPhoto;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

//---------------------------------
// Class
//---------------------------------
public class UploadGMailUserIcon {

	//---------------------------------
	// Step Functions
	//---------------------------------
	
	@Then("^User change the user icon$")
	public void shouldSeeLandingPage(){
		// Change Image
		theActorInTheSpotlight().attemptsTo( UpdateGoogleUserPhoto.setDefaultPhoto() );
	}
	
	
} 
