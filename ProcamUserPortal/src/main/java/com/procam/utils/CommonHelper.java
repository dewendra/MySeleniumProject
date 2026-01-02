package com.procam.utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonHelper {

	private WebDriver driver;
	private WebDriverWait wait;

	public CommonHelper(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}

	public void selectFromNgSelect(By dropdown, String optionText) {

		// open dropdown
		wait.until(ExpectedConditions.elementToBeClickable(dropdown)).click();

		By options = By.xpath("//ng-dropdown-panel//div[contains(@class,'ng-option')]");

		// Wait until options are visible
		new WebDriverWait(driver, Duration.ofSeconds(15))
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(options));

		List<WebElement> optionList = driver.findElements(options);

		for (WebElement option : optionList) {
			if (option.getText().trim().equalsIgnoreCase(optionText)) {
				option.click();
				return;
			}
		}

		throw new RuntimeException("Option not found: " + optionText);
	}

}
