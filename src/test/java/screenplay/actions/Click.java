// Package
package screenplay.actions;

// Import Section
import org.openqa.selenium.support.ui.ExpectedConditions;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Step;
import screenplay.commons.Constants;

// Class
public class Click implements Interaction {
	//---------------------------------------------------------
	// GLOBALs
	//---------------------------------------------------------	
	private Target target;
	private String condition = "";
	private int timeout = Constants.ZERO;

	//---------------------------------------------------------
	// Constructors
	//---------------------------------------------------------		
	public Click(Target target, String givenCondition) {
		this.condition = givenCondition;
		this.target = target;
	}
	public Click(Target target) {
		this.target = target;
	}
	public Click(Target target, int timeout) {
		this.target = target;
		this.timeout = timeout;
	}
	
	//---------------------------------------------------------
	// GLOBALs
	//---------------------------------------------------------	
	@Override
	@Step("{0} Waits and clicks on clickable #target")
	@Screenshots(disabled = true)
	public <T extends Actor> void performAs(T actor) {
		
		//Get the ElementFacade
		WebElementFacade targetElement = target.resolveFor(actor);
		switch(this.condition) {
		
			case Constants.CLICK_WITH_CMD_CTRL:
				// Get the action for the current driver
				Actions actions = new Actions(BrowseTheWeb.as(actor).getDriver());
				// Go according to the OS
				if ((System.getProperty("os.name").toLowerCase()).contains("mac"))
					actions.keyDown(Keys.COMMAND).click(targetElement).keyUp(Keys.LEFT_CONTROL).build().perform();
				else
					actions.keyDown(Keys.LEFT_CONTROL).click(targetElement).keyUp(Keys.LEFT_CONTROL).build().perform();
				
				break;
			default:
				// Wait for the Element, Based on Timeout
				if(this.timeout != Constants.ZERO && this.timeout > Constants.ZERO) {
					// Click on target with timeout
					BrowseTheWeb.as(actor).withTimeoutOf(this.timeout, TimeUnit.SECONDS).waitFor(ExpectedConditions.elementToBeClickable(targetElement));
					// Finally Click on Identified Element Facade
					targetElement.click();
				} else {
					// Click on target without timeout
					BrowseTheWeb.as(actor).waitFor(ExpectedConditions.elementToBeClickable(targetElement)).clickOn(targetElement);
				}
		}
	}

	//---------------------------------------------------------
	// Action Builders
	//---------------------------------------------------------		
	public static Click withCmdCtrl(Target target) {
		return instrumented(Click.class, target, Constants.CLICK_WITH_CMD_CTRL);
	}
	public static Click onClickableTarget(Target target) {
		return instrumented(Click.class, target);
	}
	public static Click onClickableTargetWithTimeout(Target target, int timeout) {
		return instrumented(Click.class, target, timeout);
	}
}
