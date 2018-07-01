package org.nng.qa.framework.BDDScreenplay.actions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;
import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * WaitUntilInvisibilityOf implements Interaction for wait until element is not visible in DOM
 * 
 * @author pradeep
 *
 */
public class WaitUntilInvisibilityOf implements Interaction {

  private Target target;
  private int timeout;


  public WaitUntilInvisibilityOf(Target target, int timeout) {
    this.target = target;
    this.timeout = timeout;
  }


  public WaitUntilInvisibilityOf(Target target) {
    this.target = target;
  }

  @Override
  @Step("{0} Waits for #target")
  public <T extends Actor> void performAs(T actor) {
    // TODO Auto-generated method stub

    WebElementFacade targetElement = target.resolveFor(actor);

    if (timeout != 0) {
      BrowseTheWeb.as(actor).withTimeoutOf(timeout, TimeUnit.SECONDS)
          .waitFor(ExpectedConditions.invisibilityOf(targetElement));
    } else {
      BrowseTheWeb.as(actor).waitFor(ExpectedConditions.invisibilityOf(targetElement));
    }
  }

  /**
   * 
   * @param target Target locator
   * @param timeout Timeout in seconds
   * @return instance of class WaitUntilInvisibilityOf
   */
  public static WaitUntilInvisibilityOf element(Target target, int timeout) {
    return instrumented(WaitUntilInvisibilityOf.class, target, timeout);
  }


  /**
   * 
   * @param target Target locator
   * @return instance of class WaitUntilInvisibilityOf
   */
  public static WaitUntilInvisibilityOf element(Target target) {
    return instrumented(WaitUntilInvisibilityOf.class, target);
  }


}
