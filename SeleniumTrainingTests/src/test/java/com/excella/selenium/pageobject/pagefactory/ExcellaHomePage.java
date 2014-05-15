package com.excella.selenium.pageobject.pagefactory;

import org.openqa.selenium.WebDriver;

public class ExcellaHomePage {

	private static final String EXCELLA_HOME_PAGE_URL = "http://www.excella.com/";
	
	private WebDriver driver;
	
	public ExcellaHomePage(WebDriver wd) {
		driver = wd;
	}

	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void get() {
		driver.get(EXCELLA_HOME_PAGE_URL);
	}
}
