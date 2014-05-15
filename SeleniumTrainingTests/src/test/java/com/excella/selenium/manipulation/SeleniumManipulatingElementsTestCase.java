/**
 * 
 */
package com.excella.selenium.manipulation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * @author sean
 *
 */
public class SeleniumManipulatingElementsTestCase {

//	private static final String MANIPULATE_ELEMENTS_URL = "http://localhost:8080/SeleniumTrainingWebApp/manipulateElements";
	private static final String MANIPULATE_ELEMENTS_URL = "http://seleniumtrainingapp.elasticbeanstalk.com/manipulateElements";
	
	private static WebDriver driver;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver = new FirefoxDriver();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

	@Test
	public void testAddTextToEmptyTextBox() {
		driver.get(MANIPULATE_ELEMENTS_URL);
		
		WebElement element = driver.findElement(By.id("textBox1Id"));
		assertEquals(StringUtils.EMPTY, element.getAttribute("value"));
		element.sendKeys("firstTest");
		assertEquals("firstTest", element.getAttribute("value"));
	}

	@Test
	public void testAddTextToPopulatedTextBox() {
		driver.get(MANIPULATE_ELEMENTS_URL);
		
		WebElement element = driver.findElement(By.id("textBox2Id"));
		assertEquals("default text", element.getAttribute("value"));
		element.clear();
		element.sendKeys("firstTest");
		assertEquals("firstTest", element.getAttribute("value"));
	}

	@Test
	public void testUncheckCheckBox() {
		driver.get(MANIPULATE_ELEMENTS_URL);
		
		WebElement element = driver.findElement(By.id("checkBoxBooleanId"));
		assertTrue(element.isSelected());
		element.click();
		assertFalse(element.isSelected());
	}

	@Test
	public void testCheckUncheckedCheckBox() {
		driver.get(MANIPULATE_ELEMENTS_URL);
		
		WebElement element = driver.findElement(By.id("checkBoxlistYes"));
		assertFalse(element.isSelected());
		element.click();
		assertTrue(element.isSelected());
	}

	@Test
	public void testSelectRadioButton() {
		driver.get(MANIPULATE_ELEMENTS_URL);
		
		WebElement femaleRadioButton = driver.findElement(By.id("radioButtonFemaleId"));
		WebElement maleRadioButton = driver.findElement(By.id("radioButtonMaleId"));
		assertFalse(femaleRadioButton.isSelected());
		assertTrue(maleRadioButton.isSelected());
		femaleRadioButton.click();
		assertFalse(maleRadioButton.isSelected());
		assertTrue(femaleRadioButton.isSelected());
	}	

	@Test
	public void testSelectSingleItem() {
		driver.get(MANIPULATE_ELEMENTS_URL);
		
		WebElement element = driver.findElement(By.id("singleSelectId"));
		Select select = new Select(element);
		assertFalse(select.isMultiple());
		assertEquals(StringUtils.EMPTY, select.getFirstSelectedOption().getText());
		select.selectByVisibleText("Fall");
		assertEquals("Fall", select.getFirstSelectedOption().getText());
	}

	@Test
	public void testSelectMultipleItems() {
		driver.get(MANIPULATE_ELEMENTS_URL);
		
		WebElement element = driver.findElement(By.id("multipleSelectId"));
		Select select = new Select(element);
		assertTrue(select.isMultiple());
		select.selectByVisibleText("Football");
		select.selectByVisibleText("Baseball");
		assertAllSelectedElements(select, "Football", "Baseball");
	}
	
	public void assertAllSelectedElements(Select select, String...expectedSelectedText) {		
		List<WebElement> selectedOptions = select.getAllSelectedOptions();
		assertEquals(expectedSelectedText.length, selectedOptions.size());
		List<String> actualSelectedText = new ArrayList<>();
		for (WebElement option : selectedOptions) {
			actualSelectedText.add(option.getText());
		}
		
		for (int i = 0; i < expectedSelectedText.length; i++) {
			assertTrue(actualSelectedText.contains(expectedSelectedText[i]));
		}
	}
	
	@Test
	public void testVerifyFormSubmission() {
		driver.get(MANIPULATE_ELEMENTS_URL);
		
		WebElement element = driver.findElement(By.id("multipleSelectId"));
		Select select = new Select(element);
		assertTrue(select.isMultiple());
		select.selectByVisibleText("Football");
		select.selectByVisibleText("Baseball");
		
		WebElement form = driver.findElement(By.tagName("form"));
		form.submit();
		
		assertEquals("default text", driver.findElement(By.id("tb2")).getText());
		assertEquals("true", driver.findElement(By.id("cb1")).getText());
		assertEquals("M", driver.findElement(By.id("rb1")).getText());
		assertEquals("[Football, Baseball]", driver.findElement(By.id("ms1")).getText());
	}
	
}
