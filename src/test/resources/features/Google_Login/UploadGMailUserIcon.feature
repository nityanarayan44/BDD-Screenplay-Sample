# Sesrch on wikipedia
@issue:wikiSearch @Smoke @Positive
Feature: Browse the Google Mail
		In order to browse the google mail, user login and check the mails
  
	Background:
		Given User is on "Gmail page" as a "NITYA NARAYAN GAUTAM"
	    		
	@Positive @Test10
	Scenario: GMail login
	    When User logIn to gmail as "Standard User"
	    #Then User change the user icon