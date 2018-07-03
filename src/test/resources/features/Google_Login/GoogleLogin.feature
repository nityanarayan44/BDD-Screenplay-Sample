# Sesrch on wikipedia
@issue:wikiSearch @Smoke @Positive
Feature: Browse the Google Mail
		In order to browse the google mail, user login and check the mails
  
	Background:
		Given User is on Gmail home page as a "NITYA NARAYAN GAUTAM"
	    		
	@Positive @Test1
	Scenario: GMail login
	    When User has access of gmail as "Standard User"
	    Then User should see list of mails