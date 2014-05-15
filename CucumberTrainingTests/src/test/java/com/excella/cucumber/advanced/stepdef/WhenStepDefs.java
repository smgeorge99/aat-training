package com.excella.cucumber.advanced.stepdef;

import com.excella.cucumber.vending.Items;
import com.excella.cucumber.vending.VendingMachine;

import cucumber.api.java.en.When;

public class WhenStepDefs {

	private VendingMachineTestContext context;

	public WhenStepDefs(VendingMachineTestContext ctx) {
		context = ctx;
	}

	@When("^I select the bottle of water$")
	public void i_select_the_bottle_of_water() throws Throwable {
		System.out.println("WhenContext:" + context);
		VendingMachine vendingMachine = new VendingMachine();
		Integer change = vendingMachine.purchaseItem(context.getInputMoney(), Items.BOTTLED_WATER);
		context.setChange(change);
	}

}
