// PACKAGE
package screenplay.questions;
// IMPORT SECTION
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.annotations.Subject;

// CLASS
@Subject("About current browser instance")
public class Browser implements Question<Integer> {

	//---------------------------------------------------------
	// GLOBALS
	//---------------------------------------------------------
	private Integer result = 0;

	//---------------------------------------------------------
	// CONSTRUCTORS
	//---------------------------------------------------------
	public Browser() {
		this.result = 0;
	}

	//---------------------------------------------------------
	// Questen's answer : as String
	//---------------------------------------------------------
	@Override
	public Integer answeredBy(Actor actor) {
		// Get the length of window handles
		this.result = BrowseTheWeb.as(actor).getDriver().getWindowHandles().size();
		// Return the result
		return this.result;
	}
	
	//---------------------------------------------------------
	// BUIDLERs
	//---------------------------------------------------------
	public static Browser getTotalNumberOfTabs() {
		return (new Browser());
	}
}
