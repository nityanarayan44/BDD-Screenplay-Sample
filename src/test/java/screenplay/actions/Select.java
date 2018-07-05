package screenplay.actions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

public class Select implements Interaction{

	
	 private Target target;
	  private final String value;

	  public Select(Target target, String value) {
	    this.target = target;
	    this.value = value;
	  }


	  /*
	   * (non-Javadoc)
	   * 
	   * @see net.serenitybdd.screenplay.Performable#performAs(net.serenitybdd.screenplay.Actor)
	   */
	  @Step("{0} selects #value in #target")
	  public <T extends Actor> void performAs(T actor) {
	    // Find matching text
	    for (WebElementFacade element : target.resolveAllFor(actor)) {
	      if (element.getText().equalsIgnoreCase(value)) {

	        // Click on matching text
	        element.click();
	        break;
	      }

	    }


	  }
	  
	  public static Select byVisibleText(Target target, String value) {
		return Instrumented.instanceOf(Select.class).withProperties( target,  value);
		  
	  }

}
