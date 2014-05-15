package com.excella.cucumber.advanced.stepdef;


public class VendingMachineTestContext {

	private Integer inputMoney;
	private Integer change;
	
	public Integer getInputMoney() {
		return inputMoney;
	}
	public void setInputMoney(Integer inputMoney) {
		this.inputMoney = inputMoney;
	}

	public Integer getChange() {
		return change;
	}
	public void setChange(Integer change) {
		this.change = change;
	}
	
	public void resetValues() {
		inputMoney = null;
		change = null;
	}
}
