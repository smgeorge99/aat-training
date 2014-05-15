package com.excella.cucumber.advanced.stepdef;

import static org.junit.Assert.assertEquals;
import cucumber.api.java.en.Then;

public class ThenStepDefs {

	private VendingMachineTestContext context;

	public ThenStepDefs(VendingMachineTestContext ctx) {
		context = ctx;
	}

	@Then("^I should recieve \\$(\\d+) in change$")
	public void i_should_recieve_$_in_change(Integer expectedChange) throws Throwable {
		System.out.println("ThenContext:" + context);
		assertEquals(context.getChange(), expectedChange);
	}

}
