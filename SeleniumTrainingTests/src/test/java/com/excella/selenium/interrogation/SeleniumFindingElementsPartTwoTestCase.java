/**
 * 
 */
package com.excella.selenium.interrogation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

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
public class SeleniumFindingElementsPartTwoTestCase {

//	private static final String FIND_ELEMENTS_URL = "http://localhost:8080/SeleniumTrainingWebApp/findElements";
	private static final String FIND_ELEMENTS_URL = "http://seleniumtrainingapp.elasticbeanstalk.com/findElements";
	
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
	public void testFindAllElementsByClass() {
		driver.get(FIND_ELEMENTS_URL);
		
		List<WebElement> elements = driver.findElements(By.cssSelector(".p-typewriter"));
		assertEquals(4, elements.size());
	}

	@Test
	public void testFindAllSubmitButtons() {
		driver.get(FIND_ELEMENTS_URL);
		
		List<WebElement> elements = driver.findElements(By.cssSelector("input[type='submit']"));
		assertEquals(2, elements.size());
	}

	@Test
	public void testFindLabelElementForTextBox3() {
		driver.get(FIND_ELEMENTS_URL);
		
		WebElement element = driver.findElement(By.cssSelector("label[for='text3-id']"));
		assertNotNull(element);
	}

	@Test
	public void testFindThirdInputOnFirstForm() {
		driver.get(FIND_ELEMENTS_URL);
		
		WebElement element = driver.findElement(By.cssSelector("form#form1-id input:nth-child(7)"));
		assertNotNull(element);
		System.out.println(element.getTagName() + ", " + element.getAttribute("type"));
	}

	@Test
	public void testFindInBetweenTwoFormsText() {
		driver.get(FIND_ELEMENTS_URL);
		
		WebElement element = driver.findElement(By.cssSelector("p#middle-sentence"));
		assertNotNull(element);
	}

	@Test
	public void testFindElementsWhoseNameEndsWithName() {
		driver.get(FIND_ELEMENTS_URL);
		
		List<WebElement> elements = driver.findElements(By.cssSelector("[name$='name']"));
		assertEquals(6, elements.size());
	}

	
}
