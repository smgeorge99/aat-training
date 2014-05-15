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
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author sean
 *
 */
public class SeleniumFindingElementsPartOneTestCase {

//	private static final String FIND_ELEMENTS_ONE_URL = "http://localhost:8080/SeleniumTrainingWebApp/findElements";
	private static final String FIND_ELEMENTS_ONE_URL = "http://seleniumtrainingapp.elasticbeanstalk.com/findElements";
	
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
	public void testFindForm1ElementById() {
		driver.get(FIND_ELEMENTS_ONE_URL);
		
		WebElement form1 = driver.findElement(By.id("form1-id"));
		assertNotNull(form1);
	}

	@Test
	public void testFindText3ElementByName() {
		driver.get(FIND_ELEMENTS_ONE_URL);
		
		WebElement text3 = driver.findElement(By.name("text3-name"));
		assertNotNull(text3);
	}

	@Test
	public void testFindAllInputsByTagName() {
		driver.get(FIND_ELEMENTS_ONE_URL);
		
		List<WebElement> elements = driver.findElements(By.tagName("input"));
		assertEquals(13, elements.size());
	}

	@Test
	public void testFindForm2InputsByTagName() {
		driver.get(FIND_ELEMENTS_ONE_URL);
		
		WebElement form2 = driver.findElement(By.id("form2-id"));
		
		List<WebElement> elements = form2.findElements(By.tagName("input"));
		assertEquals(7, elements.size());
	}

	@Test
	public void testFindForm1InputsByTagName() {
		driver.get(FIND_ELEMENTS_ONE_URL);
		
		WebElement form1 = driver.findElement(By.id("form1-id"));
		
		List<WebElement> elements = form1.findElements(By.tagName("input"));
		assertEquals(6, elements.size());
	}

	@Test
	public void testFindAllElementsByClassName() {
		driver.get(FIND_ELEMENTS_ONE_URL);
		
		List<WebElement> elements = driver.findElements(By.className("p-typewriter"));
		assertEquals(4, elements.size());
	}

	@Test
	public void testFindLinkByLinkText() {
		driver.get(FIND_ELEMENTS_ONE_URL);
		
		WebElement link = driver.findElement(By.linkText("Excella Home Page"));
		assertNotNull(link);
	}

	@Test
	public void testFindLinkByPartialLinkText() {
		driver.get(FIND_ELEMENTS_ONE_URL);
		
		WebElement link = driver.findElement(By.partialLinkText("ESPN Home Page for"));
		assertNotNull(link);
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testFindNonExistentElement() {
		driver.get(FIND_ELEMENTS_ONE_URL);
		
		driver.findElement(By.id("I do not exist"));
	}
	
}
