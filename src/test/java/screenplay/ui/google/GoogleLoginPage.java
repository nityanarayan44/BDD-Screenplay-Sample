package screenplay.ui.google;

import net.serenitybdd.screenplay.targets.Target;

/**
 * The Class LoginPage.
 */
public class GoogleLoginPage {
	
	/** The welcome message. */
	public static Target welcomeMessage = Target.the("'Welcome message").locatedBy("//header/h1");

	// ---------------------------------
	// -[SOCIALCODE LOGIN PAGE TARGETS]-
	// ---------------------------------
	public static Target SIGNIN_WITH_GOOGLE_BUTTON = Target.the("Sign in with Google").locatedBy("//BUTTON[text()='Sign in with Google']");
	public static Target LOGIN_FIELD_EMAIL = Target.the("'Email field").locatedBy("//input[@type='email']");
	public static Target LOGIN_FIELD_PASSWORD = Target.the("'Password field").locatedBy("//input[@type='password']");
	public static Target LOGIN_BTN_SIGNIN = Target.the("'Sign in with username and password").locatedBy("//button[@type='submit']");
	
	// ---------------------------------
	// -- [GOOGLE LOGIN POPUP TARGETS] -
	// ---------------------------------
	public static Target GOOGLE_LOGIN_FIELD_EMAIL = Target.the("Google email field").locatedBy("//INPUT[@id='identifierId']");
	public static Target GOOGLE_LOGIN_FILED_PASSWORD = Target.the("Google password field").locatedBy("//INPUT[@type='password']");
	public static Target GOOGLE_LOGIN_FILED_SECRET = Target.the("Google auth field").locatedBy("//input[@type='tel']");
}
