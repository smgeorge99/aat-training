@ScenarioOutlines
Feature: Basic calculator functionality

@Addition
Scenario Outline: Add two integers
	Given one number with a value of <firstNumber>
	And another number with a value of <secondNumber>
	When the second number is "added to" the first number
	Then the result should be <expectedResult>
	Examples:
	|firstNumber	|	secondNumber	|	expectedResult	|
	|	5			|		2			|		7			|
	|	5			|		10			|		15			|
	|	7			|		15			|		22			|
	|	16			|		2			|		18			|
	|	1			|		2			|		3			|	

@Subtraction
Scenario Outline: Subtract two integers
	Given one number with a value of <firstNumber>
	And another number with a value of <secondNumber>
	When the second number is "subtracted from" the first number
	Then the result should be <expectedResult>
	Examples:
	|firstNumber	|	secondNumber	|	expectedResult	|
	|	5			|		2			|		3			|
	|	15			|		10			|		5			|
	|	27			|		11			|		16			|
	|	16			|		2			|		14			|
	|	11			|		2			|		9			|