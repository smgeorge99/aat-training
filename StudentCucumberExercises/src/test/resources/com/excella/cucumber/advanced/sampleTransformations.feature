@TransformationScenarios
Feature: Transformation Examples

Scenario: Valid HOV3 vehicles
	Given I am a police officer
	When I see the following vehicles in the HOV-3 lanes
	| type			|	numberOfOccupants	|
	| car			|		3				|
	| motorcycle	|		1				|
	| hybrid		|		2				|
	Then I will not issue a ticket for an HOV-3 violation
		
Scenario: Solar System Planets
	Given I am a student
	When I am asked to name the planets in the solar system
	Then I will answer the science question correctly
	| Mercury	|
	| Venus		|
	| Earth		|
	| Mars		|
	| Jupiter	|
	| Saturn	|
	| Uranus	|
	| Neptune	|
		
Scenario: United States Constitution
	Given I am a student
	When I am asked to recite the Preamble to the US Constitution
	Then I will answer the civics question correctly
	"""
	We the People of the United States, in Order to form a more perfect Union, establish Justice, insure domestic Tranquility, provide for the common defence, promote the general Welfare, and secure the Blessings of Liberty to ourselves and our Posterity, do ordain and establish this Constitution for the United States of America.
	"""