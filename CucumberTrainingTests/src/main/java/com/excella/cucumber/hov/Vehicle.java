package com.excella.cucumber.hov;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Vehicle {

	private String type;
	private Integer numberOfOccupants;
	
	
	public boolean isHOV3Eligible() {
		return type.equals("hybrid") ||
				type.equals("motorcycle") || 
				numberOfOccupants >= 3;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	
}
