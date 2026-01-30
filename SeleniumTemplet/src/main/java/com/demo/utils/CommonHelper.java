package com.demo.utils;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.TimeoutException;

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

	public void searchAndSelectFromNgSelect2(By ngSelect, String partialSearchtext, String actualSearchText) {

		Logs.info("ngSelect: " + ngSelect);
		Logs.info("Partial Search Text: " + partialSearchtext);
		Logs.info("Actula search text: " + actualSearchText);
		Logs.info("CommonHelper ->searchAndselectFromNgSelect2 method called...");
		// open dropdwon
		Logs.info("Clicking Ng Select Dropdown button...");
		WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(ngSelect));
		clickWithRetry(dropdown);

		// 1. Find the input field inside the ng-select and type the partial text
		Logs.info("Finding the input field inside the ng-select and type the partial text");
		// WebElement inputField =
		// dropdown.findElement(By.xpath(".//input[@type='text']"));
		// WebElement inputField =null;
		try {
			WebElement inputField = wait
					.until(d -> dropdown.findElement(By.cssSelector(".ng-input input[type='text']:not([disabled])")));

			WebElement activeInput = driver.switchTo().activeElement();

			activeInput.clear();
			Logs.info("input field cleared...");
			activeInput.sendKeys(partialSearchtext);
			Logs.info("Typed partial search: " + partialSearchtext);
			waitForOptionsToLoad();
		} catch (TimeoutException e) {
			Logs.warn("No input found for this ng-select, using fallback selection mode.");
		} catch (Exception e) {
			Logs.warn("Error while typing into input: " + e.getMessage());
		}

		// 2. Wait for dropdown panel
		// wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("ng-dropdown-panel")));

		// 3. Wait for the filtered options to appear
		Logs.info("Waiting for the filtered options to appear");
		By optionsXpath = By.xpath("//ng-dropdown-panel//div[contains(@class,'ng-option')]");
		List<WebElement> filteredOptions = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(optionsXpath));

		// Thread.sleep(5000);
		// Use for printing the all available options
		Logs.info("Printing the all available options");
		System.out.println("Total options available :->" + filteredOptions.size());
		for (WebElement option : filteredOptions) {
			System.out.println(option.getText().toString());
		}

		// 4. Select the first match or iterate to find the best match
		Logs.info("Selecting the actual options");
		for (WebElement option : filteredOptions) {
			String optionText = option.getText().trim();
			if (optionText.contains(actualSearchText) || optionText.equalsIgnoreCase(actualSearchText)) {
				clickWithRetry(option);
				// option.click();
				Logs.info("Selected options :->" + optionText);
				return;
			}
		}
		throw new RuntimeException("Option not found: " + actualSearchText);
	}

	public void searchAndSelectFromNgSelect(By ngSelect, String partialSearchText, String actualSearchText)
			throws InterruptedException {
		Logs.info("ngSelect: " + ngSelect);
		Logs.info("PartialSearchText: " + partialSearchText);
		Logs.info("ActualSearchText: " + actualSearchText);
		Logs.info("CommonHelper ->searchAndselectFromNgSelect method called... ");
		// open dropdown
		Logs.info("Ng Select Dropdown button clicking...");
		WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(ngSelect));
		try {
			Logs.info("Ng Select Dropdown button clicking...");
			dropdown.click();
			Logs.info("Ng Select Dropdown button clicked...");
			// Thread.sleep(5000);
		} catch (Exception e) {
			Logs.info("Ng Select Dropdown button clicking...");
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", dropdown);
			Logs.info("Ng Select Dropdown button clicked...");
			// Thread.sleep(5000);
		}

		// 1. Find the input field inside the ng-select and type the partial text
		Logs.info("Finding the input field inside the ng-select and type the partial text");
		WebElement inputField = dropdown.findElement(By.xpath(".//input[@type='text']"));

		inputField.clear();
		Logs.info("input field cleared...");
		inputField.sendKeys(partialSearchText);
		Logs.info("input field partial text typed...");
		Thread.sleep(5000);

		// 2. Wait for dropdown panel
		// wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("ng-dropdown-panel")));

		// 3. Wait for the filtered options to appear
		Logs.info("Waiting for the filtered options to appear");
		By optionsXpath = By.xpath("//ng-dropdown-panel//div[contains(@class,'ng-option')]");
		List<WebElement> filteredOptions = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(optionsXpath));

		/*
		 * List<WebElement> filteredOptions = wait.until(driver -> { List<WebElement>
		 * opts = driver.findElements(optionsXpath); //if (opts.size() > 0) return opts;
		 * if(!opts.isEmpty() && opts.get(0).isDisplayed()) { return opts; }
		 * 
		 * return null;// keep waiting });
		 */

		// Thread.sleep(5000);
		// Use for printing the all available options
		Logs.info("Printing the all available options");
		System.out.println("Total options available :->" + filteredOptions.size());
		for (WebElement option : filteredOptions) {
			System.out.println(option.getText().toString());
		}

		// 4. Select the first match or iterate to find the best match
		Logs.info("Selecting the actual options");
		for (WebElement option : filteredOptions) {
			String optionText = option.getText().trim();
			if (optionText.contains(actualSearchText) || optionText.equalsIgnoreCase(actualSearchText)) {
				option.click();
				Logs.info("Selected options :->" + optionText);
				return;
			}
		}
		// throw new RuntimeException("Option not found: " + optionText);
	}

	public void selectFromNgSelect(By ngSelect, String optionText) throws InterruptedException {

		Logs.info("CommonHelper ->selectFromNgSelect method called... ");

		// STEP 1: Click dropdown
		WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(ngSelect));
		Logs.info("Clicking ng-select dropdown...");
		clickWithRetry(dropdown);
		Logs.info("Ng Select Dropdown button clicked...");

		// Locators
		By panelLocator = By.cssSelector("ng-dropdown-panel");
		By optionLocator = By.xpath("//ng-dropdown-panel//div[contains(@class,'ng-option')]");

		// STEP 2: Wait for panel to open (phase 1)
		Logs.info("Waiting for dropdown panel to appear...");
		wait.until(ExpectedConditions.visibilityOfElementLocated(panelLocator));
		List<WebElement> optionList = null;
		int retries = 3;

		// STEP 3: Retry loading options (handles slow backend delays)
		for (int attempt = 1; attempt <= retries; attempt++) {

			try {
				Logs.info("Attempt " + attempt + ": Waiting for dropdown options...");
				optionList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(optionLocator));
				if (optionList != null && optionList.isEmpty()) {
					Logs.info("Options loaded: " + optionList.size());
					break;
				}
			} catch (TimeoutException e) {
				Logs.warn("Timeout waiting for options, retrying...");
			}

			// Short backoff delay
			Thread.sleep(1000);
		}

		if (optionList == null || optionList.isEmpty()) {
			throw new RuntimeException("No options found for select: " + optionText);
		}

		// Debug print options
		Logs.info("Available options:");
		for (WebElement option : optionList) {
			Logs.info(" → " + option.getText().trim());
		}

		// STEP 4: Select matching option
		for (WebElement option : optionList) {
			String text = option.getText().trim();

			if (option.getAttribute("class").contains("ng-option-disabled")) {
				continue;
			}
			if (text.equalsIgnoreCase(optionText)) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", option);
				try {
					clickWithRetry(option);

				} catch (Exception e) {
					// Fallback click if Selenium click fails
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);
				}
				Logs.info("Selected options :->" + optionText);
				return;
			}
		}

		throw new RuntimeException("Option not found: " + optionText);
	}

	// ------------------------------------------------//
	public void waitForPageToLoad() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
				.equals("complete"));
	}

	public void waitForAngularLoad() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(w -> js.executeScript("return window.getAllAngularTestabilities ? "
						+ "window.getAllAngularTestabilities().every(x=>x.isStable()) : true"));
	}

	public void clickWithRetry(WebElement element) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element)).click();
			Logs.info("Clicked using normal Selenium click.");
		} catch (Exception e) {
			Logs.info("Normal click failed. Retrying with JS click...");
			try {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				Logs.info("Clicked using JS click.");
			} catch (Exception ex) {
				Logs.info("Both click attempts failed: " + ex.getMessage());
				throw ex; // rethrow to avoid silently skipping real failures
			}
		}
	}

	public void scrollElementInToTop(WebElement element) {
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView({block: 'start', behavior:'smooth', inline:'nearest'});", element);
	}

	public void scrollIntoViewCenter(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center',inline:'center'});",
				element);
	}

	public void scrollElementInToView(WebElement element) {
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView({block:'center', behavior:'smooth', inline:'nearest'});", element);
	}

	public void scrollElementInToEnd(WebElement element) {
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView({block: 'end', behavior:'smooth', inline:'nearest'});", element);
	}

	private void waitForOptionsToLoad() {
		By option = By.xpath("//ng-dropdown-panel//div[contains(@class,'ng-option')]");
		new WebDriverWait(driver, Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(400))
				.until(driver -> driver.findElements(option).size() > 0);
	}

}
