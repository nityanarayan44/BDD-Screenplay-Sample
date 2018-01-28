package org.nng.BDDScreenplay.example1.actions;

import java.util.concurrent.TimeUnit;
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
 * 
 * @author pradeep
 *
 */
public class WaitUntilClickable implements Interaction {

  private Target target;
  private int timeout = 0;


  public WaitUntilClickable(Target target, int timeout) {
    this.target = target;
    this.timeout = timeout;
  }
  
  public WaitUntilClickable(Target target) {
    this.target = target;
  }

  @Override
  @Step("{0} Waits for #target")
  @Screenshots(disabled = true)
  public <T extends Actor> void performAs(T actor) {
    // TODO Auto-generated method stub
    WebElementFacade targetElement = target.resolveFor(actor);

    if (timeout != 0) {
      BrowseTheWeb.as(actor).withTimeoutOf(timeout, TimeUnit.SECONDS)
          .waitFor(ExpectedConditions.elementToBeClickable(targetElement));
    } else {
      BrowseTheWeb.as(actor).waitFor(ExpectedConditions.elementToBeClickable(targetElement));
    }


  }

  /**
   * 
   * @param target Target locator
   * @param timeout Timeout in seconds
   * @return instance of class WaitUntilClickable
   */
  public static WaitUntilClickable theElementLocated(Target target, int timeout) {
    return instrumented(WaitUntilClickable.class, target, timeout);
  }

  /**
   * 
   * @param target
   * @return
   */
  public static WaitUntilClickable theElementLocated(Target target) {
    return instrumented(WaitUntilClickable.class, target);
  }
}
