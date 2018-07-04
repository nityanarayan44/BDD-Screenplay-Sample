package org.nng.qa.framework.BDDScreenplay.ui.yahoo;

import net.serenitybdd.screenplay.targets.Target;

public class Yahoo {
	
	public static final Target EMAIL_INPUT = Target.the("email box").locatedBy("//input[@id='login-username']");
	public static final Target NEXT_BTN = Target.the("email next button").locatedBy("//input[@type='submit']");
	public static final Target PASSWORD_INPUT = Target.the("password input box").locatedBy("//input[@id='login-passwd']");
	public static final Target SIGN_IN_BTN = Target.the("Sign in button").locatedBy("//button[@id='login-signin']");
	public static final Target MAIL_BTN = Target.the("Mail button").locatedBy("(//span[text()='Mail'])[1]");
	public static final Target COMPOSE_BTN = Target.the("Compose button").locatedBy("//span[text()='Compose']");
	public static final Target MAIL_SUBJECT = Target.the("Mail Subject").locatedBy("//*[@class='subj']//span[@title]");
	public static final Target MAIL_DATA = Target.the("Mail Data").locatedBy("//table[@dir]//tr/td");
	public static final Target RECIPIENT = Target.the("Recipient name").locatedBy("//input[@name='to-field']");
	public static final Target SUBJECT = Target.the("Subject").locatedBy("//input[@id='subject-field']");
	public static final Target MESSAGE_BODY = Target.the("Message Text").locatedBy("//div[@aria-label='Message Body']");
	public static final Target SEND= Target.the("Send").locatedBy("//*[text()='Send']");
}

