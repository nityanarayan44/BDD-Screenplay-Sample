# Gaurav 
@issue:gaurav @Smoke @Positive
Feature: Send an email from gmail to yahoo and then send mail from yahoo to gmail 
	    		
	@Positive @TestG
	Scenario: Send email from gmail to yahoo
		Given User open gmail url
	    When User should able to see compose button to send an email from gmail with user "gmail_user"
	    When User should able to write mail and send from gmail to "mindfireautomation@yahoo.com" with message "Automation test is ready" and with subject "Automation subject"
	   
	