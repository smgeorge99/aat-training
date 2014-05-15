package com.excella.cucumber.student;

import java.util.List;

public class Student {
	
	private String civicsAnswer;
	private List<String> scienceAnswer;
	
	public String getCivicsAnswer() {
		return civicsAnswer;
	}
	public void setCivicsAnswer(String civicsAnswer) {
		this.civicsAnswer = civicsAnswer;
	}
	public List<String> getScienceAnswer() {
		return scienceAnswer;
	}
	public void setScienceAnswer(List<String> scienceAnswer) {
		this.scienceAnswer = scienceAnswer;
	}
}
