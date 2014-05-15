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
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author sean
 *
 */
public class SeleniumSynchronizationExplicitTestCase {

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
	public void testWaitUntilElementPresent() throws InterruptedException {
		driver.get(USER_INTERACTION_URL);
		
		WebElement europeOption = driver.findElement(By.cssSelector("option[value='Europe']"));
		europeOption.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement italyOption = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("option[value='Italy']")));
		
		italyOption.click();
		
		assertTrue(europeOption.isSelected());
		assertTrue(italyOption.isSelected());
	}

	@Test
	public void testWaitUntilElementVisible() throws InterruptedException {
		driver.get(USER_INTERACTION_URL);
		
		WebElement europeOption = driver.findElement(By.cssSelector("option[value='Europe']"));
		europeOption.click();
		
		WebDriverWait wait = 
				(WebDriverWait) new WebDriverWait(driver, 5)
					.ignoring(StaleElementReferenceException.class)
					.pollingEvery(100, TimeUnit.MILLISECONDS)
					.withMessage("Italy option doesn't exist.  I cannot wait anymore");
					
		
		WebElement italyOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("option[value='Italy']")));
		
		italyOption.click();
		
		assertTrue(europeOption.isSelected());
		assertTrue(italyOption.isSelected());
	}

	@Test
	public void testWaitUntilTextPresentInElement() throws InterruptedException {
		driver.get(USER_INTERACTION_URL);
		
		WebElement europeOption = driver.findElement(By.cssSelector("option[value='Europe']"));
		europeOption.click();
		
		WebDriverWait wait = 
				(WebDriverWait) new WebDriverWait(driver, 5)
					.ignoring(StaleElementReferenceException.class)
					.pollingEvery(100, TimeUnit.MILLISECONDS)
					.withMessage("Italy option doesn't exist.  I cannot wait anymore");
					
		wait.until(ExpectedConditions.textToBePresentInElementLocated((By.cssSelector("option[value='Italy']")), "Italy"));
		WebElement italyOption = driver.findElement(By.cssSelector("option[value='Italy']"));
		
		italyOption.click();
		
		assertTrue(europeOption.isSelected());
		assertTrue(italyOption.isSelected());
	}

	@Test
	public void testWaitUntilElementClickable() throws InterruptedException {
		driver.get(USER_INTERACTION_URL);
		
		WebElement europeOption = driver.findElement(By.cssSelector("option[value='Europe']"));
		europeOption.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement italyOption = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("option[value='Italy']")));
		
		italyOption.click();
		
		assertTrue(europeOption.isSelected());
		assertTrue(italyOption.isSelected());
	}

	@Test
	public void testWaitUntilAjaxActionsAreComplete() throws InterruptedException {
		driver.get(USER_INTERACTION_URL);
		
		WebElement europeOption = driver.findElement(By.cssSelector("option[value='Europe']"));
		europeOption.click();
		
		WebDriverWait wait = 
				(WebDriverWait) new WebDriverWait(driver, 5)
					.withMessage("Italy option doesn't exist.  I cannot wait anymore");
					
		wait.until(new AjaxActionsCompleteCondition());
		WebElement italyOption = driver.findElement(By.cssSelector("option[value='Italy']"));
		
		italyOption.click();
		
		assertTrue(europeOption.isSelected());
		assertTrue(italyOption.isSelected());
	}
}
