/**
 * 
 */
package com.excella.selenium.interrogation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author sean
 *
 */
public class SeleniumInterrogatingElementsTestCase {

//	private static final String INTERROGATE_ELEMENTS_URL = "http://localhost:8080/SeleniumTrainingWebApp/interrogateElements";
	private static final String INTERROGATE_ELEMENTS_URL = "http://seleniumtrainingapp.elasticbeanstalk.com/interrogateElements";
	
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
	public void testFindAndVerifyDisabledElement() {
		driver.get(INTERROGATE_ELEMENTS_URL);
		
		WebElement element = driver.findElement(By.cssSelector("input#text3-id"));
		assertFalse(element.isEnabled());
	}

	@Test
	public void testFindAndVerifyTextBox2Value() {
		driver.get(INTERROGATE_ELEMENTS_URL);
		
		WebElement element = driver.findElement(By.id("text2-id"));
		assertEquals("defaultText2", element.getAttribute("value"));
	}

	@Test
	public void testFindAndVerifyTextBox3Value() {
		driver.get(INTERROGATE_ELEMENTS_URL);
		
		WebElement element = driver.findElement(By.cssSelector("input#text3-id"));
		assertEquals("defaultText3", element.getAttribute("value"));
	}

	@Test
	public void testFindAndVerifyTextBox5Value() {
		driver.get(INTERROGATE_ELEMENTS_URL);
		
		WebElement element = driver.findElement(By.name("text5-name"));
		assertEquals("defaultText5", element.getAttribute("value"));
	}

	@Test
	public void testFindAndVerifyIAmAfterElement() {
		driver.get(INTERROGATE_ELEMENTS_URL);
		
		WebElement element = driver.findElement(By.cssSelector("p#last-sentence"));
		assertEquals("I am after the last form.", element.getText());
//		System.out.println("Size:" + element.getSize().toString() + ", Location:" + element.getLocation().toString());
	}

	@Test
	public void testFindAndVerifyExcellaLinkText() {
		driver.get(INTERROGATE_ELEMENTS_URL);
		
		WebElement element = driver.findElement(By.cssSelector("a#excellaHomePageLink"));
		assertEquals("Excella Home Page", element.getText());
	}

	@Test
	public void testFindAndVerifySelectedRadioButton1() {
		driver.get(INTERROGATE_ELEMENTS_URL);
		
		WebElement element = driver.findElement(By.cssSelector("input[value='opt1']"));
		assertEquals("radio", element.getAttribute("type"));
		assertEquals("radio1", element.getAttribute("name"));
		assertTrue(element.isSelected());
	}

	@Test
	public void testFindAndVerifySelectedRadioButton2() {
		driver.get(INTERROGATE_ELEMENTS_URL);
		
		WebElement element = driver.findElement(By.cssSelector("input[value='opt4']"));
		assertEquals("radio", element.getAttribute("type"));
		assertEquals("radio2", element.getAttribute("name"));
		assertTrue(element.isSelected());
	}

	@Test
	public void testFindAndVerifySelectedCheckbox() {
		driver.get(INTERROGATE_ELEMENTS_URL);
		
		WebElement element = driver.findElement(By.cssSelector("input[name='checkbox2']"));
		assertEquals("checkbox", element.getAttribute("type"));
		assertTrue(element.isSelected());
	}

	@Test
	public void testFindAndVerifyUnSelectedRadioButton1() {
		driver.get(INTERROGATE_ELEMENTS_URL);
		
		WebElement element = driver.findElement(By.cssSelector("input[value='opt2']"));
		assertEquals("radio", element.getAttribute("type"));
		assertEquals("radio1", element.getAttribute("name"));
		assertFalse(element.isSelected());
	}

	@Test
	public void testFindAndVerifyUnSelectedRadioButton2() {
		driver.get(INTERROGATE_ELEMENTS_URL);
		
		WebElement element = driver.findElement(By.cssSelector("input[value='opt3']"));
		assertEquals("radio", element.getAttribute("type"));
		assertEquals("radio2", element.getAttribute("name"));
		assertFalse(element.isSelected());
	}

	@Test
	public void testFindAndVerifyUnSelectedCheckbox() {
		driver.get(INTERROGATE_ELEMENTS_URL);
		
		WebElement element = driver.findElement(By.cssSelector("input[name='checkbox1']"));
		assertEquals("checkbox", element.getAttribute("type"));
		assertFalse(element.isSelected());
	}

	@Test
	public void testFindAndVerifyInvisibleDiv() {
		driver.get(INTERROGATE_ELEMENTS_URL);
		
		WebElement element = driver.findElement(By.cssSelector("div.invisible-div"));
		assertEquals("div", element.getTagName());
		assertFalse(element.isDisplayed());
		assertEquals("invisible-div", element.getAttribute("class"));
		assertFalse(element.isSelected());
		assertTrue(element.isEnabled());
		String text = element.getText();
		assertNotNull(text);
		assertEquals(0, text.length());
		assertEquals(StringUtils.EMPTY, text);
//		assertEquals("invisible text", element.getText());
//		System.out.println("Size:" + element.getSize().toString() + ", Location:" + element.getLocation().toString());
	}
}
