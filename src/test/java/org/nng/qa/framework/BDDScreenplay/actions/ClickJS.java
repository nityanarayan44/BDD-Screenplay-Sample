package org.nng.qa.framework.BDDScreenplay.actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;

public class ClickJS implements Interaction {

	
	private WebElementFacade target;
	
	
	 public ClickJS() {
		
	}
	 public ClickJS(WebElementFacade target) {         

		 this.target = target;
}
	
	@Override
	public <T extends Actor> void performAs(T actor) {
		
   // WebElementFacade element = target.resolveFor(actor);
		WebElement tar= target;
   JavascriptExecutor js = (JavascriptExecutor)BrowseTheWeb.as(actor).getDriver();
		   js.executeScript("arguments[0].click();", tar);
           
	}

	  private JavascriptExecutor as(Actor actor) {
	        return  (JavascriptExecutor)BrowseTheWeb.as(actor).getDriver();
	    }
	  
	  public ClickJS on(WebElementFacade target) {
		  
		  return instrumented(ClickJS.class, target);
		  
	  }
}
