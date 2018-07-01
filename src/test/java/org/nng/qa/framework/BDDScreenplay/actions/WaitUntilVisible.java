package org.nng.qa.framework.BDDScreenplay.actions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.JavaScript;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

/**
 * WaitUntilVisible implements Interaction for wait until element is visible
 * @author pradeep
 *
 */
public class WaitUntilVisible  implements Interaction {

	private Target target;
	private int timeout;
	
	
	public WaitUntilVisible(Target target, int timeout) {
		this.target= target;
		this.timeout = timeout;
	}

	@Override
    @Step("{0} Waits for #target")
	public <T extends Actor> void performAs(T actor) {
		// TODO Auto-generated method stub
		WebElementFacade targetElement = target.resolveFor(actor);

	 //waitFor(targetElement).withTimeoutOf(timeout, TimeUnit.SECONDS).waitUntilClickable();
			BrowseTheWeb.as(actor)
	        .withTimeoutOf(timeout, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOf(targetElement));
	
		
		
		
	}
	
	/**
	 * 
	 * @param target Target locator
	 * @param timeout Timeout in seconds
	 * @return  instance of class WaitUntilVisible
	 */
	public static WaitUntilVisible waitUntilVisible(Target target, int timeout) {
		return instrumented(WaitUntilVisible.class, target, timeout);
    }


}
