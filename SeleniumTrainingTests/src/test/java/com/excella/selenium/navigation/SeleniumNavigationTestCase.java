/**
 * 
 */
package com.excella.selenium.navigation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author sean
 *
 */
public class SeleniumNavigationTestCase {

	
	private static final String EXCELLA_HOME_PAGE_URL = "http://www.excella.com/";
	private static final String EXCELLA_HOME_PAGE_TITLE = 
		"Excella Consulting | Software Development, Business Intelligence, Program Management and Training";
	
	private static final String EXCELLA_SOFTWARE_DEV_URL = "http://www.excella.com/services/software-development.aspx";
	private static final String EXCELLA_SOFTWARE_DEV_PAGE_TITLE = "Software Development"; 
			
	private static final String REFRESH_EXERCISE_URL = "http://seleniumtrainingapp.elasticbeanstalk.com/refreshExercise";
	
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
	public void testGetExcellaHomePage() throws InterruptedException {
		driver.get(EXCELLA_HOME_PAGE_URL);
		TimeUnit.SECONDS.sleep(1);
		assertEquals("title is not what we expected", EXCELLA_HOME_PAGE_TITLE, driver.getTitle());
	}

	@Test
	public void testNavigateForwardAndBack() throws InterruptedException {
		driver.get(EXCELLA_HOME_PAGE_URL);
		TimeUnit.SECONDS.sleep(1);
		assertEquals("title is not what we expected", EXCELLA_HOME_PAGE_TITLE, driver.getTitle());
		
		driver.get(EXCELLA_SOFTWARE_DEV_URL);
		TimeUnit.SECONDS.sleep(1);
		assertEquals("title is not what we expected", EXCELLA_SOFTWARE_DEV_PAGE_TITLE, driver.getTitle());
		
		driver.navigate().back();
		TimeUnit.SECONDS.sleep(1);
		assertEquals("URL is not what we expected", EXCELLA_HOME_PAGE_URL, driver.getCurrentUrl());
		assertEquals("title is not what we expected", EXCELLA_HOME_PAGE_TITLE, driver.getTitle());
		
		driver.navigate().forward();
		TimeUnit.SECONDS.sleep(1);
		assertEquals("URL is not what we expected", EXCELLA_SOFTWARE_DEV_URL, driver.getCurrentUrl());
		assertEquals("title is not what we expected", EXCELLA_SOFTWARE_DEV_PAGE_TITLE, driver.getTitle());
	}

	@Test
	public void testNavigateToExcellaHomePage() throws InterruptedException {
		driver.navigate().to("http://www.excella.com");
		TimeUnit.SECONDS.sleep(1);
		assertEquals("title is not what we expected", EXCELLA_HOME_PAGE_TITLE, driver.getTitle());
	}

	@Test
	public void testRefreshPage() throws InterruptedException {
		driver.get(REFRESH_EXERCISE_URL);
		Long initialTimestamp = Long.parseLong(driver.getTitle());
		assertTrue(initialTimestamp > 0);
		
		TimeUnit.SECONDS.sleep(1);
		
		driver.navigate().refresh();
		Long refreshedTimestamp = Long.parseLong(driver.getTitle());
		
		assertTrue("refreshed timestamp should be greater than the initial timestamp", 
				refreshedTimestamp > initialTimestamp);
	}

	
}
