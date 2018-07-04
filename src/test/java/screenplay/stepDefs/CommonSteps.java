//-----------------------------------------
// Package
//-----------------------------------------
package screenplay.stepDefs;

//-----------------------------------------
// Import Section
//-----------------------------------------
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Step;
import screenplay.config.Configuration;

// CLASS
public class CommonSteps {

		//---------------------------------
		// Before Methods 
		//---------------------------------
	    	@Before
	    	public void set_the_stage() {
			OnStage.setTheStage(new OnlineCast());
	    	}
	    
	    	//---------------------------------
	    	// Step Functions
	    	//---------------------------------
	    	@Step
	    	public static void initiateActor(String actor) throws Throwable {
	    		// Set the actor called with the provide actor name
	    		theActorCalled(actor);
	    	}
	    	
	    	@Given("^User is on \"([^\"]*)\" as a \"([^\"]*)\"$")
	    	public void initUserAndNavigateToPage(String page, String actorName) throws Throwable {
		    		// Set the actor
	    			CommonSteps.initiateActor(actorName);
	    			// Opens a specific URL [Defined in your CONFIG.properties]
		    		theActorInTheSpotlight().wasAbleTo(Open.url( Configuration.getValueFromConfigurations(page) ));
	    	}
	    	
	    	@Given("^User has access of \"([^\"]*)\" as a \"([^\"]*)\"$")
	    	public void userHasAccessOfPageAndNavigateToPage(String page, String actorName) throws Throwable {
		    		// Set the actor
	    			CommonSteps.initiateActor(actorName);
	    			// Opens a specific URL [Defined in your CONFIG.properties]
		    		theActorInTheSpotlight().wasAbleTo(Open.url( Configuration.getValueFromConfigurations(page) ));
	    	}
	    	
	    	
}
