package com.excella.cucumber.advanced.stepdef;

import static org.junit.Assert.assertEquals;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ScenarioOutlineStepDefs {

	int numberOne = 0;
	int numberTwo = 0;
	int actualResult = 0;
	
	@After()
	public void afterStatement() {
		System.out.println("running after scenario");
	}
	
	@Before(order=1000)
	public void beforeStatement() {
		System.out.println("running before scenario");
	}
	
	@Before(order=2000)
	public void resetValues() {
		System.out.println("resetting calculator values");
		numberOne = 0;
		numberTwo = 0;
		actualResult = 0;
	}
	
	@Given("^one number with a value of (\\d+)$")
	public void one_addend_with_a_value_of(int addend) throws Throwable {
	    numberOne = addend;
	}

	@Given("^another number with a value of (\\d+)$")
	public void another_addend_with_a_value_of(int addend) throws Throwable {
	    numberTwo = addend;
	}

	@When("^the second number is \"(.*?)\" the first number$")
	public void the_second_number_is_the_first_number(String operation) throws Throwable {
	    if(operation.equals("added to")) {
			actualResult = numberOne + numberTwo;			
	    } else if (operation.equals("subtracted from")) {
			actualResult = numberOne - numberTwo;			
	    }
	}

	@Then("^the result should be (\\d+)$")
	public void the_difference_should_be(int expectedResult) throws Throwable {
	    assertEquals(expectedResult, actualResult);
	}
}
