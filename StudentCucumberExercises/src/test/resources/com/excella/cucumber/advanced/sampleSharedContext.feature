@ContextSharingScenarios
Feature: Context Sharing Scenarios

Scenario: Vending Machine
	Given I put $5 into the vending machine
	When I select the bottle of water
	Then I should recieve $2 in change