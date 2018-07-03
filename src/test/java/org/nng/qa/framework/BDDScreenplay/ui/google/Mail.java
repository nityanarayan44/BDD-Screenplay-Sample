// PACKAGE
package org.nng.qa.framework.BDDScreenplay.ui.google;

// IMPORT SECTION
import net.serenitybdd.screenplay.targets.Target;

// CLASS
public class Mail {
	
	// Before SignIn
	// 
	public static Target SIGNIN_BUTTON 	= Target.the("Gmail Sign in button").locatedBy("//*[@data-g-label='Sign in']");
	
	// ---------------------------------
	// Generals
	// ---------------------------------
	public static Target MAIL_HEADER 	= Target.the("Mail header").locatedBy("//*[@role='main']//h2");
	public static Target MAIL_CONTENT	= Target.the("Mail Contents").locatedBy("//*[@role='listitem']");
	
	// ---------------------------------
	// SPECIFIC
	// Recovery Mail from socialCode
	// ---------------------------------
	public static Target SOCIALCODE_MAIL_CONTENT	= Target.the("Socialcode mail content").locatedBy("(//*[@role='listitem']//p)[1]");
	public static Target RESET_PASSWORD_LINK = Target.the("Link to reset the password").locatedBy("//a[contains(@href, 'password/reset') and contains(text(), 'Click here')]");
	public static Target RESET_PASSWORD_BTN = Target.the("Link to reset the password").locatedBy("//a[contains(text(), 'RESET PASSWORD')]");
	
	
}
