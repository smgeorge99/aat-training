package com.excella.cucumber.converter;

public class GradeConverter {

	
	public static String convertScoreToGrade(int score)
	{
		
		String grade = "";
		
		if (score > 90)
		{
			grade = "A";
		} 
		else if (score > 80)
		{
			grade = "B";
		}
		else if (score > 70)
		{
			grade = "C";
		}
		else if (score > 60)
		{
			grade = "D";
		}
		else
		{
			grade = "F";
		}
		
		return grade;
	}
	
	public static String complimentOnGrade(String grade)
	{
		String compliment = "";
		
		if (grade.equals("A") || grade.equals("B"))
		{
			compliment = "Excellent!";
		} 
		else if (grade.equals("C") || grade.equals("D"))
		{
			compliment = "Good job";
		}
		else
		{
			compliment = "...";
		}
		
		return compliment;
	}
	
}
