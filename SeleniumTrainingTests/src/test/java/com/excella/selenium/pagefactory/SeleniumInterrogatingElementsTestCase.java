/**
 * 
 */
package com.excella.selenium.pagefactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.excella.selenium.pageobject.pagefactory.InterrogateElementsExercisePage;

/**
 * @author sean
 *
 */
public class SeleniumInterrogatingElementsTestCase {
	
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
	
	public InterrogateElementsExercisePage getInterrogationPage() {
		InterrogateElementsExercisePage page = new InterrogateElementsExercisePage(driver);
		page.get();
		return page;
	}

	@Test
	public void testFindAndVerifyDisabledElement() {
		InterrogateElementsExercisePage page = getInterrogationPage();
		
		assertFalse(page.isTextBox3Enabled());
	}

	@Test
	public void testFindAndVerifyTextBox2Value() {
		InterrogateElementsExercisePage page = getInterrogationPage();
		
		assertEquals("defaultText2", page.getTextBox2Value());
	}

	@Test
	public void testFindAndVerifyTextBox3Value() {
		InterrogateElementsExercisePage page = getInterrogationPage();
		
		assertEquals("defaultText3", page.getTextBox3Value());
	}

	@Test
	public void testFindAndVerifyTextBox5Value() {
		InterrogateElementsExercisePage page = getInterrogationPage();
		
		assertEquals("defaultText5", page.getTextBox5Value());
	}

	@Test
	public void testFindAndVerifyIAmAfterElement() {
		InterrogateElementsExercisePage page = getInterrogationPage();
		
		assertEquals("I am after the last form.", page.getLastSentenceText());
	}

	@Test
	public void testFindAndVerifyExcellaLinkText() {
		InterrogateElementsExercisePage page = getInterrogationPage();
		
		assertEquals("Excella Home Page", page.getExcellaHomeLinkText());
	}

	@Test
	public void testFindAndVerifySelectedRadioButton1() {
		InterrogateElementsExercisePage page = getInterrogationPage();
		
		assertTrue(page.isOption1Selected());
	}

	@Test
	public void testFindAndVerifySelectedRadioButton2() {
		InterrogateElementsExercisePage page = getInterrogationPage();
		
		assertTrue(page.isOption4Selected());
	}

	@Test
	public void testFindAndVerifySelectedCheckbox() {
		InterrogateElementsExercisePage page = getInterrogationPage();
		
		assertTrue(page.isCheckbox2Selected());
	}

	@Test
	public void testFindAndVerifyUnSelectedRadioButton1() {
		InterrogateElementsExercisePage page = getInterrogationPage();
		
		assertFalse(page.isOption2Selected());
	}

	@Test
	public void testFindAndVerifyUnSelectedRadioButton2() {
		InterrogateElementsExercisePage page = getInterrogationPage();
		
		assertFalse(page.isOption3Selected());
	}

	@Test
	public void testFindAndVerifyUnSelectedCheckbox() {
		InterrogateElementsExercisePage page = getInterrogationPage();
		
		assertFalse(page.isCheckbox1Selected());
	}

	@Test
	public void testFindAndVerifyInvisibleDiv() {
		InterrogateElementsExercisePage page = getInterrogationPage();
		
		assertEquals("div", page.getInvisibleDivTagName());
		assertFalse(page.isInvisibleDivDisplayed());
		assertEquals("invisible-div", page.getInvisibleDivClass());
		assertFalse(page.isInvisibleDivSelected());
		assertTrue(page.isInvisibleDivEnabled());
		String text = page.getInvisibleDivText();
		assertNotNull(text);
		assertEquals(0, text.length());
		assertEquals(StringUtils.EMPTY, text);
//		assertEquals("invisible text", element.getText());
//		System.out.println("Size:" + element.getSize().toString() + ", Location:" + element.getLocation().toString());
	}
	
}
