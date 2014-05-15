package com.excella.selenium.pageobject.pagefactory;

import org.openqa.selenium.WebDriver;

public class RefreshExercisePage {

	private static final String REFRESH_EXERCISE_URL = "http://seleniumtrainingapp.elasticbeanstalk.com/refreshExercise";
	
	private WebDriver driver;
	
	public RefreshExercisePage(WebDriver wd) {
		driver = wd;
	}

	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void get() {
		driver.get(REFRESH_EXERCISE_URL);
	}
}
