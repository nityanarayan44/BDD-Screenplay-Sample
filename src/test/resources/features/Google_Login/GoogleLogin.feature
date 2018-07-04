# Sesrch on wikipedia
@issue:wikiSearch @Smoke @Positive
Feature: Browse the Google Mail
		In order to browse the google mail, user login and check the mails
  
	Background:
		Given User is on "Gmail page" as a "NITYA NARAYAN GAUTAM"
	    		
	@Positive @Test11
	Scenario: Open Mail for a specific recepient
	    When User logIn to gmail as "Standard User"
	    Then User open the mail from "Sender"
	    
	@Positive @Test1
	Scenario: Send Mail to a specific recepient
	    When User logIn to gmail as "Standard User"
	    Then User compose the mail "Reciever" with "subject" and "body"