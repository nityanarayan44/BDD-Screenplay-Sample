package org.nng.qa.framework.BDDScreenplay.ui;

import net.serenitybdd.screenplay.targets.Target;

public class NewEmailUi {
	
	public static Target NewMessagePrompt = Target.the("New message window").locatedBy(".//div[text()='New Message']");
	public static Target senderEmailFieldTo = Target.the("Field to enter sender email").locatedBy(".//span[text()='To']/../..//following-sibling::td//textarea");	
	public static Target subjectField = Target.the("Field to enter subject").locatedBy(".//input[@name='subjectbox']");	
	public static Target MessageBody = Target.the("Field to enter message").locatedBy(".//div[@aria-label='Message Body']");	
	public static Target sendButton = Target.the("Button to send message").locatedBy(".//div[text()='Send']");		
	public static Target sendMessageMassage = Target.the("Verification of message that email is send").locatedBy(".//div[contains(text(),'Your message has been sent.')]");		
	public static Target senderEmailFieldRecipient = Target.the("Field to enter sender email").locatedBy(".//div[text()='Recipients']/..");	
	
	
}
