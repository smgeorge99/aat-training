Feature: Basic calculator functionality

Scenario: Add two integers
	Given one number with a value of 5
	And another number with a value of 2
	When the second number is added to the first number
	Then the result should be 7
	
Scenario: Subtract two integers
	Given one number with a value of 5
	And another number with a value of 2
	When the second number is subtracted from the first number
	Then the result should be 3
