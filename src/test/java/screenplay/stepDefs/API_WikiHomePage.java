//======================================
// PACKAGE
//======================================
package screenplay.stepDefs;

//======================================
// IMPORT SECTION
//======================================
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import screenplay.questions.ActorMemory;
import screenplay.tasks.api.wikipedia.API_WikipediaHomePage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//======================================
// CLASS
//======================================
public class API_WikiHomePage {

		//----------------------------------
		// GLOBALS
		//----------------------------------
		private static Logger logger = LoggerFactory.getLogger(API_WikiHomePage.class);
		
		//----------------------------------
		// STEP FUNCTIONS
		//----------------------------------
		@Given("^User has access of wikipedia page as a \"([^\"]*)\"$")
	    	public void userHasAccessOfPageAndNavigateToPage(String actorName) throws Throwable {
		    		// Set the actor
	    			CommonSteps.initiateActor(actorName);
	    	}
		
		@When("^User request for the landing page content$")
		public void initRequestForTheLandingPage() throws Throwable {
				logger.info(">>>> Made a GET Reuest...");
		    		theActorInTheSpotlight().attemptsTo( API_WikipediaHomePage.makeGetRequest() );
		}
		
		//Then User should get "200" status code for the made request
		@When("^User should get \"([^\"]*)\" status code for the made request$")
		public void validateResponseCode(String responseCode) throws Throwable {
		    		theActorInTheSpotlight().should( seeThat("Response code", ActorMemory.recall("wikihome-response-code") , equalTo(responseCode) ));		
		}
		
		@And("^User should also see the content of the page$")
		public void userSeeThePageContent() throws Throwable {
				logger.info(">>>> Page Content:");
				logger.info(">>>> " + theActorInTheSpotlight().asksFor(ActorMemory.recall("wikihome-response-body")) );
		    		
		}
		
}