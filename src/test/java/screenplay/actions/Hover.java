// Package
package screenplay.actions;

// Import Section
import org.openqa.selenium.interactions.Actions;

import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

// Class
public class Hover implements Interaction {

	//---------------------------------------------------------
	// Action Task to perform
	//---------------------------------------------------------
		private Target target = null;
		private WebElementFacade element;
	
	//---------------------------------------------------------
	// Constructors
	//---------------------------------------------------------
		public Hover() {}
		public Hover(Target target) {         
			this.target = target;
		}
	 	public Hover(WebElementFacade element) {         
			this.element = element;
		}
	 	
	//---------------------------------------------------------
	// Action Task to perform
	//---------------------------------------------------------
	 @Override
	 @Step("{0} hovers over #target")
	 public <T extends Actor> void performAs(T actor) {
	
		 // If target is not provided somehow
		 if(target!=null) {
			 element = target.resolveFor(actor);
		 }

		 // Create an Action instance
			 Actions action = new Actions(BrowseTheWeb.as(actor).getDriver());
	         //action.moveToElement(target, xOffset, yOffset)
			 action.moveToElement(element).perform();
			 //Release the element after 500 Millis
			 //try { Thread.sleep(500); action.release(element).perform(); } catch(Exception e) {}
	}
	  
	// Action Builders
	public Hover on(Target target) {	  
		  return instrumented(Hover.class, target);
	}
	  
	public Hover on(WebElementFacade element) {
        return instrumented(Hover.class, element);
	}
}
