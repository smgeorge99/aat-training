package com.excella.cucumber.vending;

public enum Items {
	BOTTLED_WATER(3),
	CHIPS(1),
	CANDY(2);
	
	Integer price;
	
	private Items(Integer cost) {
		price = cost;
	}
	
	public Integer getPrice() {
		return price;
	}
}