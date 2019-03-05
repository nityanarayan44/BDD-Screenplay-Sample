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
	    	
	    	// User is on some page
	    	@Given("^User is on \"([^\"]*)\" as a \"([^\"]*)\"$")
	    	public void user_is_on_as_a(String page, String actorName) throws Exception {
	    		// Set the actor
	    		theActorCalled(actorName);
    			// Opens a specific URL [Defined in your CONFIG.properties]
	    		theActorInTheSpotlight().wasAbleTo(Open.url( Configuration.getValueFromConfigurations(page) ));
	    	}
	    	
	    	@Given("^User has access of \"([^\"]*)\" as a \"([^\"]*)\"$")
	    	public void userHasAccessOfPageAndNavigateToPage(String page, String actorName) throws Throwable {
		    		// Set the actor
	    			theActorCalled(actorName);
	    			// Opens a specific URL [Defined in your CONFIG.properties]
		    		theActorInTheSpotlight().wasAbleTo(Open.url( Configuration.getValueFromConfigurations(page) ));
	    	}
	    	
	    	
}
