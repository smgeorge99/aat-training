package com.excella.javafortesters.videostore;


public class SDMovie extends Movie {

	private static final String DAILY_CHARGE_AMOUNT = "1.00";
	private static final int FREQUENT_RENTER_POINT = 1;
	
	
	public SDMovie(String title)
	{
		super(title, DAILY_CHARGE_AMOUNT, FREQUENT_RENTER_POINT);
	}
	
}
