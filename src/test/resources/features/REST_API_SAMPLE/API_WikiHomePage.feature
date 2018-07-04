# Sesrch on wikipedia
@issue:wikiSearch @Smoke @Positive
Feature: Sample Test for the REST APIs
		In order to test the REST APIs using the REST Assured
  
	Background:
		#Given User has access of "wikipedia page" as a "NITYA NARAYAN GAUTAM"
		Given User has access of wikipedia page as a "NITYA NARAYAN GAUTAM"

	@Positive @Test10
	Scenario: Landing Page content
	    When User request for the landing page content
	    Then User should get "200" status code for the made request
	    And User should also see the content of the page