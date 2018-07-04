package org.nng.qa.framework.BDDScreenplay.ui;

import net.serenitybdd.screenplay.targets.Target;

public class GmailLoginPage {
	public static Target UserNameField = Target.the("Field for userName").locatedBy(".//input[@type='email']");
	public static Target PasswordField = Target.the("Field for password").locatedBy(".//input[@name='password']");
}
