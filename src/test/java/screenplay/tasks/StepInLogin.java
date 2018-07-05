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

import static net.serenitybdd.screenplay.Tasks.instrumented;

import library.utils.Manupulate;

// Class
public class StepInLogin implements Task {

	//======================
    // Globals
	//======================
		public String userName,password;
		
	//======================
	// Constructor Methods
	//======================
		public StepInLogin(String userCredentials) {
			String[] credentials = Manupulate.extractUserCredentials(userCredentials);
			if (credentials.length == Constants.TWO) {
				this.userName = credentials[Constants.ZERO].toString(); // User name
				this.password = credentials[Constants.ONE].toString(); // User password
			}
			
		}
		
    
	//==================
	// Overridden Task
	//==================
		@Override
	    @Step("{0} Login to application with #userName")
	    public <T extends Actor> void performAs(T actor) {  
	     actor.attemptsTo(
	    		 WaitUntil.elementIsClickable(StepInLoginPageUi.EMAIL_ADDRESS),
			      Enter.theValue(userName).into(StepInLoginPageUi.EMAIL_ADDRESS),
			      Enter.theValue(password).into(StepInLoginPageUi.PASSWORD),Click.on(StepInLoginPageUi.SIGN_IN),
			      WaitUntil.elementIsClickable(StepInStoryPageUi.NEW_STORY_BUTTON));
	    }
	
	//=================
	// Builders
	//=================
		public static StepInLogin withCredentials(String userCredentials) {
	        return instrumented(StepInLogin.class,userCredentials);
	    }
		
		
		
		
		
}

