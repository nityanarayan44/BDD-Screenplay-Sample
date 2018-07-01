//---------------------------------
// Package
//---------------------------------
package org.nng.qa.framework.BDDScreenplay.stepDefs;

//---------------------------------
// Import Section
//---------------------------------
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import org.nng.qa.framework.BDDScreenplay.actions.WaitUntilClickable;
import org.nng.qa.framework.BDDScreenplay.commons.Constants;
import org.nng.qa.framework.BDDScreenplay.ui.WikipediaMain;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

//---------------------------------
// Class
//---------------------------------
public class SearchOnWikipedia {

	// Global
	//---------------------------------
	private final int waitTime = 100;
	
	// Before Methods 
	//---------------------------------
    	@Before
    	public void set_the_stage() {
		OnStage.setTheStage(new OnlineCast());
    	}
    
	@Given("^user is on wikipedia home page as a \"([^\"]*)\"$")
	public void NavigateToTheApplication(String actorName) throws Throwable {
        // Opens a specific URL
		theActorCalled(actorName).wasAbleTo(Open.url(Constants.URL));       
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
