package com.excella.cucumber.advanced.stepdef;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;

public class GivenStepDefs {

	private VendingMachineTestContext context;
	
	public GivenStepDefs(VendingMachineTestContext ctx) {
		context = ctx;
	}
	
	@Before
	public void resetContext() {
		context.resetValues();
	}
	
	@Given("^I put \\$(\\d+) into the vending machine$")
	public void i_put_$_into_the_vending_machine(Integer input) throws Throwable {
		System.out.println("GivenContext:" + context);
	    context.setInputMoney(input);
	}
}
