package com.excella.cucumber.vending;

public class VendingMachine {

	public Integer purchaseItem(Integer inputMoney, Items itemToPuchase) {
		Integer change = inputMoney - itemToPuchase.getPrice();
		return change;
	}
}
