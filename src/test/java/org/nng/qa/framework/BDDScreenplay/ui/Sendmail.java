package org.nng.qa.framework.BDDScreenplay.ui;

import net.serenitybdd.screenplay.targets.Target;

public class Sendmail {
	public static Target userNameYahoo = Target.the("user name of yahoo account").locatedBy("//input[@name='username’]");
	public static Target nextYahoo = Target.the("next").locatedBy("///input[@value='Next’]");
	public static Target passwordYahoo = Target.the("password of yahoo account").locatedBy("//input[@name='password’]]");
	public static Target composeYahoo = Target.the("compose button of yahoo account").locatedBy("//a[text()='Compose’]");
	public static Target recipientYahoo = Target.the("mail recipients").locatedBy("//div[@data-test-id='recipient-input']//input[1]");
	public static Target messageBodyYahoo = Target.the("message body of email").locatedBy("//div[@aria-label='Message body’]");
	public static Target sendButtonYahoo = Target.the("send button to send an email").locatedBy("//span[text()='Send']");
	
	

}
