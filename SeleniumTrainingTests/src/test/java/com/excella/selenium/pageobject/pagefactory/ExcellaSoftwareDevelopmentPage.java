package com.excella.selenium.pageobject.pagefactory;

import org.openqa.selenium.WebDriver;

public class ExcellaSoftwareDevelopmentPage {

	private static final String EXCELLA_SOFTWARE_DEV_URL = "http://www.excella.com/services/software-development.aspx";
	
	private WebDriver driver;
	
	public ExcellaSoftwareDevelopmentPage(WebDriver wd) {
		driver = wd;
	}

	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void get() {
		driver.get(EXCELLA_SOFTWARE_DEV_URL);
	}
}
