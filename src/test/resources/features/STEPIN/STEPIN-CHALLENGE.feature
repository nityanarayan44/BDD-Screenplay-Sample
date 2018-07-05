@Positive
	Feature: Go to STePIn app and create a story 
				 
	@Positive @Demo
	Scenario: Go to the stepIn Ghost application 
	    Given User as "STePIn" has access of "Stepin Ghost Application" with the "credentials"
	    And User get the series of febbonacies
	    When User Creates a story intitle with "userId" "ThreadNumber" "RecordFibonacciNumber" "title" and with body "titleAttribute"
	    Then User Publish the story
	