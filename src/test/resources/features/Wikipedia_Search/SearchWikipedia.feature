# Sesrch on wikipedia
@issue:wikiSearch @Smoke @Positive
Feature: Search on Wikipedia
  In order to test searching onwikipedia
  
	Background:
		Given User is on "wikipedia page" as a "Tester"
	    		
	@Positive @Test1
	Scenario Outline: Searching a keyword on wikipedia home page
	    When User enters a "<keyword>" on wikipedia search page
	    Then User should see results for the entered keyworked
	    Examples:
		  | keyword	|
		  | Earth 	|
		  | Mars		|
