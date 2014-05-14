package com.excella.javafortesters.videostore;


public class HDMovie extends Movie {

	private static final String DAILY_CHARGE_AMOUNT = "3.00";
	private static final int FREQUENT_RENTER_POINT = 2;
	
	
	public HDMovie(String title)
	{
		super(title, DAILY_CHARGE_AMOUNT, FREQUENT_RENTER_POINT);
	}
	

}
