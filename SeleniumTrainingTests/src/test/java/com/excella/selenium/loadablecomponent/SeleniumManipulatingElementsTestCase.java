/**
 * 
 */
package com.excella.selenium.loadablecomponent;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.excella.selenium.pageobject.loadablecomponent.ManipulateElementsPage;
import com.excella.selenium.pageobject.loadablecomponent.SubmittedManipulateElementsPage;

/**
 * @author sean
 *
 */
public class SeleniumManipulatingElementsTestCase {
	
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

	private ManipulateElementsPage getManipulateElementsPage() {
		ManipulateElementsPage page = new ManipulateElementsPage(driver);
		page.get();
		
		return page;
	}
	
	@Test
	public void testAddTextToEmptyTextBox() {
		ManipulateElementsPage page = getManipulateElementsPage();
		
		assertEquals(StringUtils.EMPTY, page.getTextBox1Value());
		page.enterTextBox1Value("firstTest");
		assertEquals("firstTest", page.getTextBox1Value());
	}

	@Test
	public void testAddTextToPopulatedTextBox() {
		ManipulateElementsPage page = getManipulateElementsPage();
		
		assertEquals("default text", page.getTextBox2Value());
		page.enterTextBox2Value("firstTest");
		assertEquals("firstTest", page.getTextBox2Value());
	}

	@Test
	public void testUncheckCheckBox() {
		ManipulateElementsPage page = getManipulateElementsPage();
		
		assertTrue(page.isCheckBoxBooleanSelected());
		page.clickCheckBoxBoolean();
		assertFalse(page.isCheckBoxBooleanSelected());
	}

	@Test
	public void testCheckUncheckedCheckBox() {
		ManipulateElementsPage page = getManipulateElementsPage();
		
		assertFalse(page.isCheckBoxYesSelected());
		page.clickCheckBoxYes();;
		assertTrue(page.isCheckBoxYesSelected());
	}

	@Test
	public void testSelectRadioButton() {
		ManipulateElementsPage page = getManipulateElementsPage();
		
		assertFalse(page.isFemaleRadioButtonSelected());
		assertTrue(page.isMaleRadioButtonSelected());
		page.clickFemaleRadioButton();
		assertFalse(page.isMaleRadioButtonSelected());
		assertTrue(page.isFemaleRadioButtonSelected());
	}	

	@Test
	public void testSelectSingleItem() {
		ManipulateElementsPage page = getManipulateElementsPage();
		
		page.selectSeason("Fall");
		assertEquals("Fall", page.getSelectedSeasonText());
	}

	@Test
	public void testSelectMultipleItems() {
		ManipulateElementsPage page = getManipulateElementsPage();
		
		page.selectSports("Football","Baseball");
		assertTrue(page.areAllSportsSelected("Football", "Baseball"));
	}
	
	
	@Test
	public void testVerifyFormSubmission() {
		ManipulateElementsPage page = getManipulateElementsPage();
		
		page.selectSports("Football","Baseball");
		
		
		SubmittedManipulateElementsPage submittedPage = page.submitForm(); 
		
		assertEquals("default text", submittedPage.getTextBox2SubmissionValue());
		assertEquals("true", submittedPage.getCheckbox1SubmissionValue());
		assertEquals("M", submittedPage.getRadioButton1SubmissionValue());
		assertEquals("[Football, Baseball]", submittedPage.getSportsSelectSubmissionValue());
	}
	
}
