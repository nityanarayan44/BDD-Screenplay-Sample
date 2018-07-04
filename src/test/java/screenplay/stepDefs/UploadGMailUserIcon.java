//---------------------------------
// Package
//---------------------------------
package screenplay.stepDefs;

//---------------------------------
// Import Section
//---------------------------------
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import screenplay.config.Configuration;
import screenplay.tasks.login.google.GMailLogin;
import screenplay.tasks.mail.gmail.OpenMail;
import screenplay.tasks.setting.google.UpdateGoogleUserPhoto;

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
