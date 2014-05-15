package com.excella.selenium.pageobject.loadablecomponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;

public class SubmittedManipulateElementsPage extends LoadableComponent<SubmittedManipulateElementsPage>{

	private static final String MANIPULATE_ELEMENTS_TITLE = "Submitted Manipulate Elements";
	
	private WebDriver driver;
	
	public SubmittedManipulateElementsPage(WebDriver wd) {
		driver = wd;
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	@Override
	protected void load() {
		//nothing to do here.  this page will always be loaded as part of a form submission; we will never navigate here directly
	}

	@Override
	protected void isLoaded() throws Error {
		if(!MANIPULATE_ELEMENTS_TITLE.equals(getPageTitle())) {
			throw new Error("Submitted Manipulate Elements page is not loaded");
		} 
	}
	
	public String getTextBox2SubmissionValue() {
		return driver.findElement(By.id("tb2")).getText();		
	}
	
	public String getCheckbox1SubmissionValue() {
		return driver.findElement(By.id("cb1")).getText();		
	}
	
	public String getRadioButton1SubmissionValue() {
		return driver.findElement(By.id("rb1")).getText();		
	}
	
	public String getSportsSelectSubmissionValue() {
		return driver.findElement(By.id("ms1")).getText();		
	}
	
}
