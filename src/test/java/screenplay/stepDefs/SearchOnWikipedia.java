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
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import screenplay.actions.WaitUntil;
import screenplay.ui.WikipediaMain;

//---------------------------------
// Class
//---------------------------------
public class SearchOnWikipedia {

	//---------------------------------
	// STEP Functions
	//---------------------------------
	
	// User search for a keyword on wikipedia
	@When("^User enters a \"([^\"]*)\" on wikipedia search page$")
	public void user_enters_a_on_wikipedia_search_page(String keyword) throws Exception {
		// Entering a keyword to search
		theActorInTheSpotlight().attemptsTo(
				WaitUntil.elementIsClickable(WikipediaMain.searchBox),
			    Enter.theValue(keyword).into(WikipediaMain.searchBox),
			    WaitUntil.elementIsClickable(WikipediaMain.searchButton),
			    Click.on(WikipediaMain.searchButton));
	}

	@Then("^User should see results for the entered keyworked$")
	public void user_should_see_results_for_the_entered_keyworked() throws Exception {
	    System.out.println("I am doing nothing aftersearching...");
	}
} 
