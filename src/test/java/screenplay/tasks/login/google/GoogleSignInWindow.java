package screenplay.tasks.login.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import screenplay.actions.BrowserTab;
import screenplay.commons.Constants;

/**
 * The Class NavigateToNewWindow.
 */
public class GoogleSignInWindow implements Task {
	
	/** The obj chrome browser utils. */
	int timeout = 100;
	
	@Override
	public <T extends Actor> void performAs(T theActor) {
		// Get the Driver for the Actor
		WebDriver driver = BrowseTheWeb.as(theActor).getDriver();
		// Wait until there are 2 Window handles
		new WebDriverWait(driver, timeout).until(ExpectedConditions.numberOfWindowsToBe(Constants.TWO));
		theActor.wasAbleTo(BrowserTab.switchToFirstTab());
	}

	/**
	 * The google login session.
	 *
	 * @return the navigate to new window
	 */
	public static GoogleSignInWindow theGoogleLoginSession() {
		return new GoogleSignInWindow();
	}
}
