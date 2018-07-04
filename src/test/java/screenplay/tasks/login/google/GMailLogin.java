// PACKAGE
package screenplay.tasks.login.google;

// IMPORT SECTION
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import org.openqa.selenium.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import library.utils.Manupulate;
import library.utils.oauth.google.Compute;
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

// CLASS
public class GMailLogin implements Task {

	// ---------------------------------
	// GLOBALS
	// ---------------------------------
	private static final Logger logger = LoggerFactory.getLogger(GMailLogin.class);
	private String CONDITION = (String) Constants.NULL; // PLAIN_LOGIN | OAUTH_LOGIN
	private String googleUsername, googlePassword, secretKey;
	
	// ---------------------------------
	// CONSTRUCTOR
	// ---------------------------------
	public GMailLogin(String userCredentials, String condition) {
		// Extract the User credentials
		String[] credentials = Manupulate.extractUserCredentials(userCredentials);
		if(credentials.length == Constants.TWO) {
			this.googleUsername 	= credentials[Constants.ZERO].toString(); // User name
			this.googlePassword 	= credentials[Constants.ONE].toString(); // User password
			this.secretKey 		= ""; // Secret key if applicable
		}
		else if(credentials.length == Constants.THREE) { 
			this.googleUsername 	= credentials[Constants.ZERO].toString(); // User name
			this.googlePassword 	= credentials[Constants.ONE].toString(); // User password
			this.secretKey		= credentials[Constants.TWO].toString(); // Secret key if applicable
		} else {
			logger.error("[ Login ]>>>> Got the Blank Values for User Credentials.");
			this.googleUsername 	= "".toString(); // User name
			this.googlePassword	= "".toString(); // User password
			this.secretKey		= "".toString(); // Secret key if applicable
		}		
		this.CONDITION = condition;
	}
	public GMailLogin(String user, String password, String secretKey, String condition) {
		this.googleUsername = user;
		this.googlePassword = password;
		this.secretKey = secretKey;
		this.CONDITION = condition;
	}
	public GMailLogin(String user, String password, String condition) {
		this.googleUsername = user;
		this.googlePassword = password;
		this.CONDITION = condition;
	}
	
	// ---------------------------------
	// TASKS
	// ---------------------------------
	@Override
	@Step("{0} login to GMail")
	public <T extends Actor> void performAs(T theActor) {

		// Navigate the GMail Link URL
		//theActor.wasAbleTo(Open.url(Constants.GMAIL_URL));
		
		
		// Login Mode
		switch(this.CONDITION) {
			// OAUTH LOGIN
			case Constants.LOGIN_PLAIN: 
				// If directly redirection for the google login
				if( !(BrowseTheWeb.as(theActor).getDriver().getCurrentUrl().contains(Constants.GOOGLE_LOGIN)) ) {
					theActor.attemptsTo(
							WaitUntil.the(GMailPage.SIGNIN_BUTTON, isVisible()),
							Click.on(GMailPage.SIGNIN_BUTTON)
					);
				}
				// Fill the Google credentials with secret key for Users
				theActor.attemptsTo(		
						// PLAIN GOOGLE LOGIN :: Enter the User's Credentials
						WaitUntil.the(GoogleLoginPage.GOOGLE_LOGIN_FIELD_EMAIL, isVisible()),
						Enter.theValue(this.googleUsername).into(GoogleLoginPage.GOOGLE_LOGIN_FIELD_EMAIL).thenHit(Keys.ENTER),
				        WaitUntil.the(GoogleLoginPage.GOOGLE_LOGIN_FILED_PASSWORD, isVisible()),
				        Enter.theValue(this.googlePassword).into(GoogleLoginPage.GOOGLE_LOGIN_FILED_PASSWORD).thenHit(Keys.ENTER)
				);
				break;
				
			// PLAIN LOGIN	
			case Constants.LOGIN_OAUTH:
				// If directly redirection for the google login
				if( !(BrowseTheWeb.as(theActor).getDriver().getCurrentUrl().contains(Constants.GOOGLE_LOGIN)) ) {
					theActor.attemptsTo(
							WaitUntil.the(GMailPage.SIGNIN_BUTTON, isVisible()),
							Click.on(GMailPage.SIGNIN_BUTTON)
					);
				}
				// Fill the Google credentials with secret key for Users
				theActor.attemptsTo(		
						// OAUTH GOOGLE LOGIN :: Enter the User's Credentials
						WaitUntil.the(GoogleLoginPage.GOOGLE_LOGIN_FIELD_EMAIL, isVisible()),
						Enter.theValue(this.googleUsername).into(GoogleLoginPage.GOOGLE_LOGIN_FIELD_EMAIL).thenHit(Keys.ENTER),
				        WaitUntil.the(GoogleLoginPage.GOOGLE_LOGIN_FILED_PASSWORD, isVisible()),
				        Enter.theValue(this.googlePassword).into(GoogleLoginPage.GOOGLE_LOGIN_FILED_PASSWORD).thenHit(Keys.ENTER),
				        WaitUntil.the(GoogleLoginPage.GOOGLE_LOGIN_FILED_SECRET, isVisible()),
				        Enter.theValue(Compute.computePinFromSecret(this.secretKey)).into(GoogleLoginPage.GOOGLE_LOGIN_FILED_SECRET).thenHit(Keys.ENTER)
				);
				break;
				default: break;
		}
		
		// Verify, if this page still exist
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
	public static GMailLogin withOAuth(String googleUsername, String googlePassword, String secretkey) {	
		return instrumented(GMailLogin.class, googleUsername, googlePassword, secretkey, Constants.LOGIN_OAUTH);
	}
	public static GMailLogin withOAuth(String combineCredentials) {	
		return instrumented(GMailLogin.class, combineCredentials, Constants.LOGIN_OAUTH);
	}
	public static GMailLogin with(String googleUsername, String googlePassword) {	
		return instrumented(GMailLogin.class, googleUsername, googlePassword, Constants.LOGIN_PLAIN);
	}
	public static GMailLogin with(String combineCredentials) {	
		return instrumented(GMailLogin.class, combineCredentials, Constants.LOGIN_PLAIN);
	}

}
