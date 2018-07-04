// PACKAGE
package org.nng.qa.framework.BDDScreenplay.ui.google;

// IMPORT SECTION
import net.serenitybdd.screenplay.targets.Target;

// CLASS
public class GMailPage {
	
	// Before SignIn
	// 
	public static Target SIGNIN_BUTTON 	= Target.the("Gmail Sign in button").locatedBy("//*[@data-g-label='Sign in']");
	
	// ---------------------------------
	// General Controls
	// ---------------------------------
	public static Target SELECT_ALL_CHKBOX 	= Target.the("Checkbox to select all the displayed mails").locatedBy("//*[@role='checkbox']/div[@role='presentation']");
	public static Target DELETE_BUTTON	= Target.the("Delete button to delete the selected mails").locatedBy("//div[@data-tooltip='Delete']");
	public static Target ARCHIVE_BUTTON	= Target.the("Archive button to archive the selected mails").locatedBy("//div[@data-tooltip='Archive']");
	public static Target NO_MAILS		= Target.the("No mail is present").locatedBy("//td[text()='No new mail!']");
	
	// ---------------------------------
	// SPECIFIC
	// Recovery Mail from socialCode
	// ---------------------------------
	public static Target MAIL_RECOVERY = Target.the("Mail for Password Recovery").locatedBy("(//span[@email='{0}'])[1]/../../..");
	public static Target COMPOSE_BUTTON = Target.the("Compose mail button").locatedBy("//*[@role='button' and contains(text(), 'COMPOSE')]");
	public static Target COMPOSE_MAIL_TO = Target.the("Send mail To").locatedBy("//textarea[@aria-label='To']");
	public static Target COMPOSE_MAIL_SUBJECT = Target.the("Mail Subject").locatedBy("//*[@aria-label='Subject']");
	public static Target COMPOSE_MAIL_BODY = Target.the("Mail Body").locatedBy("//*[@role='textbox' and @aria-label='Message Body']");
	public static Target SEND_MAIL = Target.the("Mail Body").locatedBy("//*[contains(@data-tooltip, 'Send')]");
	// 
	
}
