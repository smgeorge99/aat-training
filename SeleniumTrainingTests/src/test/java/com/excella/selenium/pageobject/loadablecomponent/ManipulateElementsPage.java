package com.excella.selenium.pageobject.loadablecomponent;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;

public class ManipulateElementsPage extends LoadableComponent<ManipulateElementsPage>{

	private static final String MANIPULATE_ELEMENTS_URL = "http://seleniumtrainingapp.elasticbeanstalk.com/manipulateElements";
	private static final String MANIPULATE_ELEMENTS_TITLE = "Manipulate Elements";
	
	private WebDriver driver;
	
	public ManipulateElementsPage(WebDriver wd) {
		driver = wd;
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	@Override
	protected void load() {
		driver.get(MANIPULATE_ELEMENTS_URL);
	}

	@Override
	protected void isLoaded() throws Error {
		if(!MANIPULATE_ELEMENTS_TITLE.equals(getPageTitle())) {
			throw new Error("Manipulate Elements page is not loaded");
		} 
	}
	
	public void enterTextBox1Value(String value) {
		WebElement element = driver.findElement(By.id("textBox1Id"));
		clearAndEnterValue(element, value);
	}
	
	public String getTextBox1Value() {
		WebElement element = driver.findElement(By.id("textBox1Id"));
		return element.getAttribute("value");
	}
	
	public void enterTextBox2Value(String value) {
		WebElement element = driver.findElement(By.id("textBox2Id"));
		clearAndEnterValue(element, value);
	}
	
	public String getTextBox2Value() {
		WebElement element = driver.findElement(By.id("textBox2Id"));
		return element.getAttribute("value");
	}
	
	public void clickFemaleRadioButton() {
		driver.findElement(By.id("radioButtonFemaleId")).click();
	}
	
	public boolean isFemaleRadioButtonSelected() {
		return driver.findElement(By.id("radioButtonFemaleId")).isSelected();
	}
	
	public boolean isMaleRadioButtonSelected() {
		return driver.findElement(By.id("radioButtonMaleId")).isSelected();
	}
	
	public void clickCheckBoxBoolean() {
		WebElement element = driver.findElement(By.id("checkBoxBooleanId"));
		element.click();
	}
	
	public boolean isCheckBoxBooleanSelected() {
		return driver.findElement(By.id("checkBoxBooleanId")).isSelected();
	}
	
	public void clickCheckBoxYes() {
		WebElement element = driver.findElement(By.id("checkBoxlistYes"));
		element.click();
	}
	
	public boolean isCheckBoxYesSelected() {
		return driver.findElement(By.id("checkBoxlistYes")).isSelected();
	}
	
	public void selectSeason(String season) {
		WebElement element = driver.findElement(By.id("singleSelectId"));
		Select select = new Select(element);
		select.selectByVisibleText(season);
	}
	
	public void selectSports(String...sports) {
		WebElement element = driver.findElement(By.id("multipleSelectId"));
		Select select = new Select(element);
		
		for (String sport : sports) {
			select.selectByVisibleText(sport);
		}
	}
	
	public boolean areAllSportsSelected(String...expectedSelectedText) {	
		boolean areAllSportsSelected = true;
		
		WebElement element = driver.findElement(By.id("multipleSelectId"));
		Select select = new Select(element);
		List<WebElement> selectedOptions = select.getAllSelectedOptions();
		
		if(expectedSelectedText.length == selectedOptions.size()) {			
			List<String> actualSelectedText = new ArrayList<>();
			for (WebElement option : selectedOptions) {
				actualSelectedText.add(option.getText());
			}
			
			for (int i = 0; i < expectedSelectedText.length; i++) {
				if(!actualSelectedText.contains(expectedSelectedText[i])){
					areAllSportsSelected = false;
					break;
				}
			}
		} else {
			areAllSportsSelected = false;
		}
		
		return areAllSportsSelected;
	}
	
	public String getSelectedSeasonText() {
		WebElement element = driver.findElement(By.id("singleSelectId"));
		Select select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}
	
	public SubmittedManipulateElementsPage submitForm() {
		driver.findElement(By.tagName("form")).submit();
		
		SubmittedManipulateElementsPage page = new SubmittedManipulateElementsPage(driver);
		return page.get();
	}
	
	private void clearAndEnterValue(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}
}
