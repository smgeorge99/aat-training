package com.excella.selenium.pageobject.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InterrogateElementsExercisePage {

	private static final String INTERROGATE_ELEMENTS_URL = "http://seleniumtrainingapp.elasticbeanstalk.com/interrogateElements";
	
	private WebDriver driver;
	
	@FindBy(css="input#text3-id")
	private WebElement textBox3;
	
	@FindBy(id="text2-id")
	private WebElement textBox2;
	
	@FindBy(name="text5-name")
	private WebElement textBox5;
	
	@FindBy(css="p#last-sentence")
	private WebElement lastSentence;
	
	@FindBy(id="excellaHomePageLink")
	private WebElement excellaHomeLink;
	
	@FindBy(css="input[value='opt1']")
	private WebElement option1;
	
	@FindBy(css="input[value='opt4']")
	private WebElement option4;
	
	@FindBy(css="input[name='checkbox2']")
	private WebElement checkbox2;
	
	@FindBy(css="input[value='opt2']")
	private WebElement option2;
	
	@FindBy(css="input[value='opt3']")
	private WebElement option3;
	
	@FindBy(css="input[name='checkbox1']")
	private WebElement checkbox1;

	@FindBy(css="div.invisible-div")
	private WebElement invisibleDiv;
	
	public InterrogateElementsExercisePage(WebDriver wd) {
		driver = wd;
		PageFactory.initElements(driver, this);
	}

	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void get() {
		driver.get(INTERROGATE_ELEMENTS_URL);
	}
	
	public boolean isTextBox3Enabled() {
		return isElementEnabled(textBox3);
	}
	
	public boolean isInvisibleDivEnabled() {
		return isElementEnabled(invisibleDiv);
	}
	
	public String getTextBox2Value() {
		return getElementValue(textBox2);
	}
	
	public String getTextBox3Value() {
		return getElementValue(textBox3);
	}
	
	public String getTextBox5Value() {
		return getElementValue(textBox5);
	}
	
	public String getLastSentenceText() {
		return getElementText(lastSentence);
	}
	
	public boolean isOption1Selected() {
		return isElementSelected(option1);
	}
	
	public boolean isOption2Selected() {
		return isElementSelected(option2);
	}
	
	public boolean isCheckbox1Selected() {
		return isElementSelected(checkbox1);
	}
	
	public boolean isCheckbox2Selected() {
		return isElementSelected(checkbox2);
	}
	
	public boolean isOption3Selected() {
		return isElementSelected(option3);
	}
	
	public boolean isOption4Selected() {
		return isElementSelected(option4);
	}
	
	public String getExcellaHomeLinkText() {
		return getElementText(excellaHomeLink);
	}
	
	public String getInvisibleDivText() {
		return getElementText(invisibleDiv);
	}
	
	public String getInvisibleDivTagName() {
		return invisibleDiv.getTagName();
	}
	
	public String getInvisibleDivClass() {
		return invisibleDiv.getAttribute("class");
	}
	
	public boolean isInvisibleDivDisplayed() {
		return invisibleDiv.isDisplayed();
	}
	
	public boolean isInvisibleDivSelected() {
		return isElementSelected(invisibleDiv);
	}
	
	private String getElementValue(WebElement element) {
		return element.getAttribute("value");
	}
	
	private String getElementText(WebElement element) {
		return element.getText();
	}
	
	private boolean isElementSelected(WebElement element) {
		return element.isSelected();
	}
	
	private boolean isElementEnabled(WebElement element) {
		return element.isEnabled();
	}
}
