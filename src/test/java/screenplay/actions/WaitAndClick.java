package screenplay.actions;

import org.openqa.selenium.support.ui.ExpectedConditions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Step;
import static net.serenitybdd.screenplay.Tasks.instrumented;


/**
 * WaitUntilClickable implements Interaction for wait until element is clickable
 * @author pradeep
 *
 */
public class WaitAndClick implements Interaction{
	
	private Target target;
	
	
	public WaitAndClick(Target target) {
		this.target= target;
	}

	public WaitAndClick() {
    // TODO Auto-generated constructor stub
  }

  @Override
    @Step("{0} Waits for clickable and click on  #target")
	@Screenshots(disabled=true)
	public <T extends Actor> void performAs(T actor) {
		WebElementFacade targetElement = target.resolveFor(actor);
		
			BrowseTheWeb.as(actor).waitFor(ExpectedConditions.elementToBeClickable(targetElement)).clickOn(targetElement);;
			
		
			}
	
	/**
	 * 
	 * @param target Target locator
	 * @return  instance of class WaitUntilClickable
	 */
	public  WaitAndClick theElementLocated(Target target) {
		return instrumented(WaitAndClick.class, target);
    }
}
