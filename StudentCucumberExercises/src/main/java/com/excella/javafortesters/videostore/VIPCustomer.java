package com.excella.javafortesters.videostore;

public class VIPCustomer extends Customer {
	
	private static final String DISCOUNT_RATE = "0.10";
	
	public VIPCustomer(String name) {
		super(name, DISCOUNT_RATE);
		this.setPointMultiplier(2);
	}


}
