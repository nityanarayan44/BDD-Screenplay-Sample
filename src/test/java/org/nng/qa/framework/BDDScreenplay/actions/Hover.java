package org.nng.qa.framework.BDDScreenplay.actions;

import org.openqa.selenium.interactions.Actions;

import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;

public class Hover implements Interaction {

	
	private Target target = null;
  private WebElementFacade element;
	
	
	 public Hover() {
		
	}
	 public Hover(Target target) {         

		 this.target = target;
}
	
	 public Hover(WebElementFacade element) {         

       this.element = element;
}
	 
	@Override
	public <T extends Actor> void performAs(T actor) {
	
	  if(target!=null) {
	     element = target.resolveFor(actor);

	  }

    Actions action = new Actions(BrowseTheWeb.as(actor).getDriver());
         
    action.moveToElement(element).perform();
    
	}
	  
	  public Hover on(Target target) {
		  
		  return instrumented(Hover.class, target);
		  
	  }
	  
	  public Hover on(WebElementFacade element) {
        
        return instrumented(Hover.class, element);
        
    }
}
