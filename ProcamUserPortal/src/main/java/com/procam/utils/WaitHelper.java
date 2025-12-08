package com.procam.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {

	WebDriver driver;

	public WaitHelper(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement waitForVisible(WebElement element) {

		return new WebDriverWait(driver, Duration.ofSeconds(7))
				.until(ExpectedConditions.visibilityOf(element));

	}

	public WebElement waitForClickable(WebElement element) {
		return new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(element));

	}
}
