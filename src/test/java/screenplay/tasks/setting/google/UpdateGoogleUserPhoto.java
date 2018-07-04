// PACKAGE
package screenplay.tasks.setting.google;

// IMPORT SECTION
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URL;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import library.utils.Manupulate;
import library.utils.oauth.google.Compute;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import screenplay.commons.Constants;
import screenplay.ui.google.GMailPage;
import screenplay.ui.google.GoogleLoginPage;
import screenplay.ui.google.GoogleSettings;

// CLASS
public class UpdateGoogleUserPhoto implements Task {

	// ---------------------------------
	// GLOBALS
	// ---------------------------------
	private static final Logger logger = LoggerFactory.getLogger(UpdateGoogleUserPhoto.class);
	
	// ---------------------------------
	// CONSTRUCTOR
	// ---------------------------------
	public UpdateGoogleUserPhoto() {
		
	}
	
	// ---------------------------------
	// TASKS
	// ---------------------------------
	@Override
	@Step("{0}Set the image to gmail user")
	public <T extends Actor> void performAs(T theActor) {

			// Open Image uploader model
			theActor.attemptsTo(		
					WaitUntil.the(GoogleSettings.GOOGLE_USER_ICON, isVisible()),
					Click.on(GoogleSettings.GOOGLE_USER_ICON),
					WaitUntil.the(GoogleSettings.GOOGLE_USER_ICON_CHANGE_BUTTON, isVisible()),
					Click.on(GoogleSettings.GOOGLE_USER_ICON_CHANGE_BUTTON)
			);
			
//			theActor.attemptsTo(	
//					WaitUntil.the(GoogleSettings.GOOGLE_USER_ICON_UPLOAD_BUTTON, isPresent()),
//					Click.on(GoogleSettings.GOOGLE_USER_ICON_UPLOAD_BUTTON)
//			);
				
			// Robot class
			Robot robot = null;
			try {
				Thread.sleep(3000);
				robot = new Robot();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_U);
			robot.keyRelease(KeyEvent.VK_N);
			robot.keyRelease(KeyEvent.VK_I);
			robot.keyPress(KeyEvent.VK_ENTER);
			
//			theActor.attemptsTo(	
//				WaitUntil.the(GoogleSettings.SET_IMAGE_BUTTON, isPresent()),
//				Click.on(GoogleSettings.SET_IMAGE_BUTTON)
//			);

			
// 			Set the Image now
//			WebElementFacade file = GoogleSettings.INPUT_FILE.resolveFor(theActor);;
//			JavascriptExecutor js = (JavascriptExecutor)BrowseTheWeb.as(theActor).getDriver();
//			js.executeScript("arguments[0].style.visibility = 'visible'", file);
//			file.sendKeys("/Users/ashutosh/NNG_WORKSPACE/PERSONAL/CODE_WORKSPACE/eclipse-workspace/BDD-Screenplay-Sample/images/1.png");
		// TODO:
	}
	
	// ---------------------------------
	// BUIDERS
	// ---------------------------------
	/**
	 * Provide the credentials
	 * @param googleUsername
	 * @param googlePassword
	 * @param secretkey
	 * @return
	 */
	public static UpdateGoogleUserPhoto setDefaultPhoto() {	
		return instrumented(UpdateGoogleUserPhoto.class);
	}
	
}
