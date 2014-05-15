package com.excella.selenium.synchronization;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class AjaxActionsCompleteCondition implements ExpectedCondition<Boolean> {

	@Override
	public Boolean apply(WebDriver driver) {
		return areAjaxActionsComplete(driver);
	}

	private static boolean areAjaxActionsComplete(WebDriver wd) {
		boolean condition = false;

		JavascriptExecutor jsExecutor = (JavascriptExecutor) wd;

		try {
			condition = (Boolean) jsExecutor.executeScript("return jQuery.active == 0");
		} catch (WebDriverException wde) {
			if (StringUtils.contains(wde.getMessage(), "jQuery is not defined")) {
				condition = true;
			} else {
				throw wde;
			}
		}

		return condition;
	}
}
