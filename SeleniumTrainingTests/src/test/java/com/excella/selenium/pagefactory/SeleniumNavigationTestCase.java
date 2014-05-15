/**
 * 
 */
package com.excella.selenium.pagefactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.excella.selenium.pageobject.pagefactory.ExcellaHomePage;
import com.excella.selenium.pageobject.pagefactory.ExcellaSoftwareDevelopmentPage;
import com.excella.selenium.pageobject.pagefactory.RefreshExercisePage;

/**
 * @author sean
 *
 */
public class SeleniumNavigationTestCase {

	
	private static final String EXCELLA_HOME_PAGE_TITLE = 
		"Excella Consulting | Software Development, Business Intelligence, Program Management and Training";
	
	private static final String EXCELLA_SOFTWARE_DEV_PAGE_TITLE = "Software Development"; 
			
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
		ExcellaHomePage page = new ExcellaHomePage(driver);
		page.get();
		TimeUnit.SECONDS.sleep(1);
		assertEquals("title is not what we expected", EXCELLA_HOME_PAGE_TITLE, page.getPageTitle());
	}

	@Test
	public void testNavigateForwardAndBack() throws InterruptedException {
		ExcellaHomePage page = new ExcellaHomePage(driver);
		page.get();
		TimeUnit.SECONDS.sleep(1);
		assertEquals("title is not what we expected", EXCELLA_HOME_PAGE_TITLE, driver.getTitle());
		
		ExcellaSoftwareDevelopmentPage devPage = new ExcellaSoftwareDevelopmentPage(driver);
		devPage.get();
		TimeUnit.SECONDS.sleep(1);
		assertEquals("title is not what we expected", EXCELLA_SOFTWARE_DEV_PAGE_TITLE, driver.getTitle());
		
		driver.navigate().back();
		TimeUnit.SECONDS.sleep(1);
		assertEquals("title is not what we expected", EXCELLA_HOME_PAGE_TITLE, driver.getTitle());
		
		driver.navigate().forward();
		TimeUnit.SECONDS.sleep(1);
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
		RefreshExercisePage page = new RefreshExercisePage(driver);
		page.get();
		Long initialTimestamp = Long.parseLong(page.getPageTitle());
		assertTrue(initialTimestamp > 0);
		
		TimeUnit.SECONDS.sleep(1);
		
		driver.navigate().refresh();
		Long refreshedTimestamp = Long.parseLong(driver.getTitle());
		
		assertTrue("refreshed timestamp should be greater than the initial timestamp", 
				refreshedTimestamp > initialTimestamp);
	}

	
}
