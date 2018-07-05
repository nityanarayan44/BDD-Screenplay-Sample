//======================================
// PACKAGE
//======================================
package screenplay.stepDefs;

//======================================
// IMPORT SECTION
//======================================
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import screenplay.questions.Fibonacci;
import screenplay.questions.Rest;
import screenplay.tasks.MultiStepIn;

//======================================
// CLASS
//======================================
public class DemoStepDef {

		//----------------------------------
		// GLOBALS
		//----------------------------------
		private static Logger logger = LoggerFactory.getLogger(DemoStepDef.class);
		
		//----------------------------------
		// STEP FUNCTIONS
		//----------------------------------


@Given("^User as \"([^\"]*)\" has access of \"([^\"]*)\" with the \"([^\"]*)\"$")
public void user_as_has_access_of_with_the(String actor, String application, String arg3) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	CommonSteps.initiateActor(actor);
	theActorInTheSpotlight().remember("rest-resp", Rest.getData());
}

@Given("^User get the series of febbonacies$")
public void user_get_the_series_of_febbonacies() throws Exception {
    // Write code here that turns the phrase above into concrete actions
	theActorInTheSpotlight().remember("fibbonacci", Fibonacci.getList(1, 100));
	
}

@When("^User Creates a story intitle with \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" and with body \"([^\"]*)\"$")
public void user_Creates_a_story_intitle_with_and_with_body(String arg1, String arg2, String arg3, String arg4, String arg5) throws Exception {
	ArrayList<Integer> fibo = theActorInTheSpotlight().recall("fibbonacci");
	String rest[] = theActorInTheSpotlight().recall("rest-resp");
	int counter = 0;
	for (int item : fibo)
	{
		if(counter < 10) {
			theActorInTheSpotlight().attemptsTo( MultiStepIn.to(counter, counter+1) );
			counter = counter +2;
		}
	}
}

@Then("^User Publish the story$")
public void user_Publish_the_story() throws Exception {
    // Write code here that turns the phrase above into concrete actions
}
		
}