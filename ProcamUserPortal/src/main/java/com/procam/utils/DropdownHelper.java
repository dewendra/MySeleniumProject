package com.procam.utils;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropdownHelper {
	WebDriver driver;
	WebDriverWait wait;

	public DropdownHelper(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void selectFromList(List<WebElement> options, String partialsearchText) {

		// partialText = partialText.toLowerCase().trim();

		for (WebElement option : options) {
			if (!option.isEnabled()) {
				continue; // skip disabled items
			}

			String actualText = option.getText().trim();

			if (actualText.contains(partialsearchText)) {
				option.click();
				return;
			}
		}

		throw new RuntimeException("Option not found: " + partialsearchText);

	}

	public void searchFromDropdownList(List<WebElement> options, String partialSearchText, String actualSearchText) {
		for (WebElement option : options) {
			if (!option.isEnabled()) {
				continue;
			}
			String optionText = option.getText().trim();

			if (optionText.contains(partialSearchText) || optionText.equalsIgnoreCase(actualSearchText)) {
				try {
					option.click();
				} catch (ElementClickInterceptedException e) {
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);
				}
				return;
			}

		}
	}

}
