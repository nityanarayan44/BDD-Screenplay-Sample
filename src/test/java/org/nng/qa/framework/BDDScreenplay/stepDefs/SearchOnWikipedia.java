//---------------------------------
// Package
//---------------------------------
package org.nng.qa.framework.BDDScreenplay.stepDefs;

//---------------------------------
// Import Section
//---------------------------------
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import org.nng.qa.framework.BDDScreenplay.actions.WaitUntil;
import org.nng.qa.framework.BDDScreenplay.ui.WikipediaMain;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

//---------------------------------
// Class
//---------------------------------
public class SearchOnWikipedia {

	//---------------------------------
	// STEP Functions
	//---------------------------------
	@When("^User enters a \"([^\"]*)\" on wikipedia search page$")
	public void entersAKeywordToSearch(String keyword){
	    // Entering a keyword to search
		theActorInTheSpotlight().attemptsTo(
				WaitUntil.elementIsClickable(WikipediaMain.searchBox),
			    Enter.theValue(keyword).into(WikipediaMain.searchBox),
			    WaitUntil.elementIsClickable(WikipediaMain.searchButton),
			    Click.on(WikipediaMain.searchButton));
	}
	
	@Then("^User should see results for the entered keyworked$")
	public void shouldSeeLandingPage(){
		//
	}
} 
