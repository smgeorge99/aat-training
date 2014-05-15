/**
 * 
 */
package com.excella.selenium.manipulation;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

/**
 * @author sean
 *
 */
public class SeleniumUserInteractionTestCase {

//	private static final String USER_INTERACTION_URL = "http://localhost:8080/SeleniumTrainingWebApp/userInteraction";
	private static final String USER_INTERACTION_URL = "http://seleniumtrainingapp.elasticbeanstalk.com/userInteraction";
	
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
	public void testDragAndDrop1() throws InterruptedException {
		driver.get(USER_INTERACTION_URL);
		WebElement element = driver.findElement(By.id("makeMeDroppable"));
		assertEquals("Drop Area", element.getText());

		TimeUnit.SECONDS.sleep(2);
		Action dragAndDrop = 
				new Actions(driver)
					.clickAndHold(driver.findElement(By.id("makeMeDraggable")))
					.moveToElement(driver.findElement(By.id("makeMeDroppable")))
					.release()
					.build();
		
		dragAndDrop.perform();
		TimeUnit.SECONDS.sleep(2);
		assertEquals("Successful Drop!", element.getText());
	}

	@Test
	public void testDragAndDrop2() throws InterruptedException {
		driver.get(USER_INTERACTION_URL);
		WebElement element = driver.findElement(By.id("makeMeDroppable"));
		assertEquals("Drop Area", element.getText());

		TimeUnit.SECONDS.sleep(2);
		Action dragAndDrop = 
				new Actions(driver)
					.dragAndDrop(driver.findElement(By.id("makeMeDraggable")), driver.findElement(By.id("makeMeDroppable")))
					.build();
		
		dragAndDrop.perform();
		TimeUnit.SECONDS.sleep(2);
		
		assertEquals("Successful Drop!", element.getText());
	}
}
