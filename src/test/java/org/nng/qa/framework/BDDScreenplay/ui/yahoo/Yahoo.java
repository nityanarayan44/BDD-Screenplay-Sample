package org.nng.qa.framework.BDDScreenplay.ui.yahoo;

import net.serenitybdd.screenplay.targets.Target;

public class Yahoo {
	
	public static final Target EMAIL_INPUT = Target.the("email box").locatedBy("//input[@id='login-username']");
	public static final Target NEXT_BTN = Target.the("email next button").locatedBy("//input[@type='submit']");
	public static final Target PASSWORD_INPUT = Target.the("password input box").locatedBy("//input[@id='login-passwd']");
	public static final Target SIGN_IN_BTN = Target.the("Sign in button").locatedBy("//button[@id='login-signin']");
	public static final Target MAIL_BTN = Target.the("Mail button").locatedBy("(//span[text()='Mail'])[1]");
	public static final Target COMPOSE_BTN = Target.the("Compose button").locatedBy("//span[text()='Compose']");

}

