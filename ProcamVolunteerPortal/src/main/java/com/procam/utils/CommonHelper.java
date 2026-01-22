package com.procam.utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

	public void setInputValue(WebDriver driver, WebElement element, String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='';" + "arguments[0].value=arguments[1];"
				+ "arguments[0].dispatchEvent(new Event('input', { bubbles: true }));"
				+ "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));", element, value);
	}

	public void selectFromNgSelect(By ngSelect, String optionText) {
		Logs.info("CommonHelper ->selectFromNgSelect method called... ");
		// open dropdown
		Logs.info("Ng Select Dropdown button clicking...");
		WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(ngSelect));
		try {
			Logs.info("Ng Select Dropdown button clicking...");
			dropdown.click();
		} catch (Exception e) {
			Logs.info("Ng Select Dropdown button clicking...");
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", dropdown);
		}

		By options = By.xpath("//ng-dropdown-panel//div[contains(@class,'ng-option')]");

		// Wait until options are visible
		List<WebElement> optionList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(options));
		Logs.info("Options found: " + optionList.size());
		
		// Use for printing the all available options
		for (WebElement address : optionList) {
			System.out.println(address.getText().toString());
		}

		for (WebElement option : optionList) {
			if (option.getAttribute("class").contains("ng-option-disabled")) {
				continue;
			}
			if (option.getText().trim().equalsIgnoreCase(optionText)) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", option);
				option.click();
				return;
			}
		}

		throw new RuntimeException("Option not found: " + optionText);
	}

}
