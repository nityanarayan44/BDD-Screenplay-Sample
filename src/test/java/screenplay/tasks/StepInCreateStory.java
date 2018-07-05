//------------------------------------------------
// Package
//------------------------------------------------
package screenplay.tasks;

//------------------------------------------------
// Imports
//------------------------------------------------
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import screenplay.actions.WaitUntil;
import net.thucydides.core.annotations.Step;
import screenplay.commons.Constants;
import screenplay.ui.StepInLoginPageUi;
import screenplay.ui.StepInStoryPageUi;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

import org.openqa.selenium.interactions.Actions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import library.utils.Manupulate;

// Class
public class StepInCreateStory implements Task {

	//======================
    // Globals
	//======================
		public String userId,threadNumber,recordFibonacciNumber,title,bodyAttribute;
		
	//======================
	// Constructor Methods
	//======================
		public StepInCreateStory(String userId,String threadNumber,String recordFibonacciNumber,String title,String bodyAttribute) {
			this.userId=userId;
			this.threadNumber=threadNumber;
			this.recordFibonacciNumber=recordFibonacciNumber;
			this.title=title;
			this.bodyAttribute=bodyAttribute;
		}
		
    
	//==================
	// Overridden Task
	//==================
		@Override
	    @Step("{0} create and post a story")
	    public <T extends Actor> void performAs(T actor) {  
	     actor.attemptsTo(  
	    		 Click.on(StepInStoryPageUi.NEW_STORY_BUTTON),
	    	     WaitUntil.elementIsClickable(StepInStoryPageUi.POST_TITLE),
	    	     Enter.theValue(userId+" "+threadNumber+" "+recordFibonacciNumber+" "+title).into(StepInStoryPageUi.POST_TITLE),
	    	     WaitUntil.elementIsClickable(StepInStoryPageUi.POST_BODY),
	    	     Enter.theValue(bodyAttribute).into(StepInStoryPageUi.POST_BODY),
	    	     Click.on(StepInStoryPageUi.PUBLISH_DROPDOWN),net.serenitybdd.screenplay.waits.WaitUntil.the(StepInStoryPageUi.SET_IT_LIVE_NOW, isCurrentlyVisible())
	    	     ,Click.on(StepInStoryPageUi.PUBLISH_BUTTON),net.serenitybdd.screenplay.waits.WaitUntil.the(StepInStoryPageUi.PUBLISHED, isCurrentlyVisible())
	    	     
	    	     );
	     /*
	     Actions action = new Actions(BrowseTheWeb.as(actor).getDriver());
	     action.moveToElement(StepInStoryPageUi.POST_BODY.resolveFor(actor)).click().perform();
	     
	     action.sendKeys(bodyAttribute).build().perform();	     
	     StepInStoryPageUi.POST_BODY.resolveFor(actor).click();
	     */
	     
	    }
	
	//=================
	// Builders
	//=================
		public static StepInCreateStory publishStory(String userId,String threadNumber,String recordFibonacciNumber,String title,String bodyAttribute) {
	        return instrumented(StepInCreateStory.class,userId,threadNumber,recordFibonacciNumber,title,bodyAttribute);
	    }
		
		
		
		
		
}

