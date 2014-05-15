package com.excella.javafortesters.videostore;

import java.math.BigDecimal;

public class Movie {
	
	private String title;
	private BigDecimal dailyCharge;
	private int frequentRenterPoint;
	
	
	public Movie(String title, String dailyChargeAmount, int frequentRenterPoint)
	{
		this.setTitle(title);
		this.dailyCharge = new BigDecimal(dailyChargeAmount);
		this.frequentRenterPoint = frequentRenterPoint;
	}
	
	
	public BigDecimal getDailyCharge()
	{
		return this.dailyCharge;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getFrequentRenterPoint() {
		return this.frequentRenterPoint;
	}
		
}
