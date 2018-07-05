# STEP-IN Challenge
Feature: Go to STePIn app and create a story 
				 
	@Positive @Test1
	Scenario: Go to the stepIn Ghost application 
	    Given User as "STePIn" has access with the "credentials"
	    And User get the series of febbonacies
	    When User Creates a story intitle with "userId" "ThreadNumber" "RecordFibonacciNumber" "title" and with body "titleAttribute"
	    Then User Publish the story