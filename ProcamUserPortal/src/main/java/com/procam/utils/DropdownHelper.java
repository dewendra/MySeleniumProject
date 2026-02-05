package com.procam.utils;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropdownHelper {
	private static final Logger log=LogManager.getLogger(DropdownHelper.class);
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
		
		log.info("Total Option available in dropdown: "+options.size());
		for (WebElement option : options) {
			
			if (!option.isEnabled()) {
				continue;
			}
			String optionText = option.getText().trim();
			log.info("Option text:-> "+optionText);

			if (optionText.contains(partialSearchText) || optionText.equalsIgnoreCase(actualSearchText)) {
				try {

					option.click();
				} catch (ElementClickInterceptedException e) {
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});",
							option);
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);

					// 🔥 Commit selection (MOST IMPORTANT)
					// inputField.sendKeys(Keys.TAB);

					// Wait until dropdown closes
					// wait.until(ExpectedConditions.invisibilityOfElementLocated(dropdownContainer));
				}
				return;
			}

		}
	}

	public void searchFromDropdownList2(WebElement inputField, By dropdownContainer, String actualSearchText) {
		
		System.out.println("Search stirng is : ==="+actualSearchText);
		
		List<WebElement> options = wait.until(
				ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'position-relative')]//li")));
		log.info("Total Option available in dropdown: "+options.size());
		

		for (WebElement option : options) {

			String optionText = option.getText().trim();
			log.info("Option text:-> "+optionText);
			if (optionText.equalsIgnoreCase(actualSearchText)) {

				// Scroll into view
				//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", option);

				// JS click (Angular friendly)
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);

				// 🔥 Commit selection (MOST IMPORTANT)
				inputField.sendKeys(Keys.TAB);

				// Wait until dropdown closes
				wait.until(ExpectedConditions.invisibilityOfElementLocated(dropdownContainer));

				return;
			}
		}

		throw new RuntimeException("Option not found in dropdown: " + actualSearchText);
	}

}
