package com.excella.javafortesters.videostore;

import java.math.BigDecimal;

public class Customer {

	private String name;
	private BigDecimal discountRate;
	private int pointMultiplier;
	
	public Customer(String name, String discountRate) {
		this.name = name;
		this.discountRate = new BigDecimal(discountRate);
		this.pointMultiplier = 1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getDiscountRate() {
		return this.discountRate;
	}

	public int getPointMultiplier() {
		return this.pointMultiplier;
	}

	public void setPointMultiplier(int pointMultiplier) {
		this.pointMultiplier = pointMultiplier;
	}

}
