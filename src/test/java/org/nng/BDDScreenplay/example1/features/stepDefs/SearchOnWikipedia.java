// Package
package org.nng.BDDScreenplay.example1.features.stepDefs;

// Import Section
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import org.nng.BDDScreenplay.example1.tasks.Navigate;
import org.nng.BDDScreenplay.example1.ui.WikipediaMain;
import org.nng.BDDScreenplay.example1.actions.WaitUntilClickable;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

// Class
public class SearchOnWikipedia {

	// Global
	private final int waitTime = 100;
	
	// Methods 
    	@Before
    	public void set_the_stage() {
		OnStage.setTheStage(new OnlineCast());
    	}
    
	@Given("^user is on wikipedia home page as a \"([^\"]*)\"$")
	public void NavigateToTheApplication(String actorName) throws Throwable {
        theActorCalled(actorName).wasAbleTo((new Navigate()).to());       
	}
	
	@When("^User enters a \"([^\"]*)\" on wikipedia search page$")
	public void entersAKeywordToSearch(String keyword){
	    // Entering a keyword to search
		theActorInTheSpotlight().attemptsTo(
				WaitUntilClickable.theElementLocated(WikipediaMain.searchBox, this.waitTime),
			    Enter.theValue(keyword).into(WikipediaMain.searchBox),
			    WaitUntilClickable.theElementLocated(WikipediaMain.searchButton, this.waitTime),
			    Click.on(WikipediaMain.searchButton)
		);
	}
	
	@Then("^User should see results for the entered keyworked$")
	public void shouldSeeLandingPage(){
		//
	}
} 
