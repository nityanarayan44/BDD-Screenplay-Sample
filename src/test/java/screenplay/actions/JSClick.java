// Package
package screenplay.actions;

// Import Section
import static net.serenitybdd.screenplay.Tasks.instrumented;
import org.openqa.selenium.JavascriptExecutor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

// Class
public class JSClick implements Interaction {

	//---------------------------------------------------------
	// GLOBALs
	//---------------------------------------------------------
		private Target target = null;
		private WebElementFacade webElement;

	//---------------------------------------------------------
	// COSTRUCTORs
	//---------------------------------------------------------
	public JSClick(Target target) {         
		this.target = target;
	}
	public JSClick(WebElementFacade target) {
		this.webElement = target;
	}

	//---------------------------------------------------------
	// Action Task to perform
	//---------------------------------------------------------
	@Override
	public <T extends Actor> void performAs(T actor) {
		if(target != null) {
			webElement = target.resolveFor(actor);
		}
		// Initiate JSExecutor
		JavascriptExecutor js = (JavascriptExecutor) BrowseTheWeb.as(actor).getDriver();
		// Inject the script to execute on browser
		js.executeScript("arguments[0].click();", webElement);
	}

	//---------------------------------------------------------
	// Action Builders
	//---------------------------------------------------------
	public static JSClick on(WebElementFacade target) {
		return instrumented(JSClick.class, target);
	}
	public static JSClick on(Target target) {
		return instrumented(JSClick.class, target);
	}
}
