package screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;

public class StepInLoginPageUi {
	public static Target EMAIL_ADDRESS = Target.the("Email address field").locatedBy("//input[@type='email']");
	public static Target PASSWORD  = Target.the("Password field").locatedBy("//input[@type='password']");
	public static Target SIGN_IN   = Target.the("Sign in button").locatedBy("//span[text()='Sign in']");	
}
