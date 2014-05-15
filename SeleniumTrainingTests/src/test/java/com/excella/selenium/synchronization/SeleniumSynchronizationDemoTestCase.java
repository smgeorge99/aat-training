/**
 * 
 */
package com.excella.selenium.synchronization;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

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
public class SeleniumSynchronizationDemoTestCase {

//	private static final String USER_INTERACTION_URL = "http://localhost:8080/SeleniumTrainingWebApp/ajaxForm";
	private static final String USER_INTERACTION_URL = "http://seleniumtrainingapp.elasticbeanstalk.com/ajaxForm";
	
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
	public void testDemonstrateSynchronizationProblem() throws InterruptedException {
		driver.get(USER_INTERACTION_URL);
		
		WebElement europeOption = driver.findElement(By.cssSelector("option[value='Europe']"));
		europeOption.click();
		
		TimeUnit.SECONDS.sleep(4);
		
		WebElement italyOption = driver.findElement(By.cssSelector("option[value='Italy']"));
		italyOption.click();
		
		assertTrue(europeOption.isSelected());
		assertTrue(italyOption.isSelected());
	}
}
