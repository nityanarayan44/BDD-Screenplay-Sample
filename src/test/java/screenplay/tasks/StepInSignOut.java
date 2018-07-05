//------------------------------------------------
// Package
//------------------------------------------------
package screenplay.tasks;

//------------------------------------------------
// Imports
//------------------------------------------------
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import screenplay.actions.WaitUntil;
import net.thucydides.core.annotations.Step;
import screenplay.commons.Constants;
import screenplay.ui.StepInLoginPageUi;
import screenplay.ui.StepInStoryPageUi;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import library.utils.Manupulate;

// Class
public class StepInSignOut implements Task {

	// ======================
	// Globals
	// ======================

	// ======================
	// Constructor Methods
	// ======================
	public StepInSignOut() {

	}

	// ==================
	// Overridden Task
	// ==================
	@Override
	@Step("{0} create and post a story")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(StepInStoryPageUi.USER_BLOG), WaitUntil.elementIsClickable(StepInStoryPageUi.LOGOUT),
				Click.on(StepInStoryPageUi.LOGOUT), WaitUntil.elementIsClickable(StepInLoginPageUi.EMAIL_ADDRESS));
	}

	// =================
	// Builders
	// =================
	public static StepInSignOut publishStory() {
		return instrumented(StepInSignOut.class);
	}

}
