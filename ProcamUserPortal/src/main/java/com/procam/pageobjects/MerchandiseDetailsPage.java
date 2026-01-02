package com.procam.pageobjects;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.procam.actiondriver.Action;
import com.procam.base.BaseClass;
import com.procam.utils.DriverFactory;
import com.procam.utils.Logs;
import com.procam.utils.WaitHelper;

public class MerchandiseDetailsPage extends BaseClass {

	private WebDriver driver;
	Action action;
	WaitHelper wait;
	String parentWindow;

	@FindBy(xpath = "//div[contains(@class,'fs-3')]//span[contains(@class,'btn-fa-color')]")
	private WebElement upBackBtn;

	@FindBy(xpath = "//input[@id='addonsY']")
	private WebElement addonsYes;

	@FindBy(xpath = "//input[@id='addonsN']")
	private WebElement addonsNo;

	@FindBy(xpath = "//div[contains(@class,'addOn-container')]")
	private List<WebElement> addOnList;

	@FindBy(xpath = "//img[contains(@class,'max-image')]")
	private WebElement addOnImage;

	@FindBy(xpath = "//div[contains(@class,'addOn-container row')]//p[contains(@class,'h5')]")
	private WebElement addOnName;

	@FindBy(xpath = "//div[contains(@class,'addOn-container row')]//div[contains(@class,'addOn-price')]")
	private WebElement addOnPrice;

	@FindBy(xpath = "//div[contains(@class,'addOn-container row')]//div[contains(@class,'quantity-holder')]")
	private WebElement quantity;

	@FindBy(xpath = "//div[contains(@class,'addOn-container row')]//div[contains(@class,'btn-color')]")
	private WebElement addButton;

	@FindBy(xpath = "//select[contains(@class,'form-select')]")
	private WebElement addSizeDropdown;

	@FindBy(xpath = "//input[@id='donationy']")
	private WebElement donantionYes;

	@FindBy(xpath = "//label[@for='donantionN']")
	private WebElement donantionNo;

	@FindBy(xpath = "//input[@name='fundRaise']/following-sibling::label[normalize-space()='Yes']")
	private WebElement fundRaiseYes;

	@FindBy(xpath = "//input[@name='fundRaise']/following-sibling::label[normalize-space()='No']")
	private WebElement fundRaiseNo;

	@FindBy(css = "a[href*='tmm-green-bib']")
	private WebElement greenBibhowPage;

	@FindBy(xpath = "//input[@id='donationyGreenBib']")
	private WebElement greenBibyes;

	@FindBy(xpath = "//input[@id='donantionNGreenBib']")
	private WebElement greenBibNo;

	@FindBy(xpath = "//button[@type='submit' and normalize-space()='Back']")
	private WebElement downBackBtn;

	@FindBy(xpath = "//button[normalize-space()='Proceed']")
	private WebElement proceedBtn;

	public MerchandiseDetailsPage() {
		this.driver = DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
		wait = new WaitHelper(driver);
	}

	public OrderSummaryPage enterMerchandiseDetails(Map<String, String> data) throws InterruptedException {

		waitThread(5000);

		// ------------------------Addons Option-----------------------//
		Logs.info("Checking if Addons section is available...");
		if (isAddOnsSectionAvailable()) {
			Logs.info("Addons section found");
			scrollElementInToView(addonsYes);
			if (data.get("addOns").equalsIgnoreCase("yes")) {
				wait.waitForClickable(addonsYes);
				addonsYes.click();
				Logs.info("addons Yes option selected...");
				Logs.info("Going to select addons form available merchandise...");

				selectAddOns(data.get("addOnName"));

			} else {
				Logs.info("addons No option selected...");
				addonsNo.click();

			}
		} else {
			Logs.info("Addons section NOT present : skipping to Donation");
		}

		waitThread(2000);

		// ---------------------Donation ----------------------------//

		Logs.info("Going for selecting the Donation option....");
		if (data.get("donation").equalsIgnoreCase("yes")) {
			scrollElementInToView(donantionYes);
			wait.waitForVisible(donantionYes);
			wait.waitForClickable(donantionYes);
			waitThread(2000);
			donantionYes.click();
			Logs.info("donantion Yes option selected...");
		} else {
			Logs.info("donantion No option selected...");
		}

		// ---------------Fund Raiser--------------------------//
		Logs.info("Going for selecting the fund Raise option....");
		if (data.get("fundRaise").equalsIgnoreCase("Yes")) {
			wait.waitForVisible(fundRaiseYes);
			wait.waitForClickable(fundRaiseYes);
			waitThread(2000);
			fundRaiseYes.click();
		} else {
			Logs.info("Fund Raise No option selected....");
		}

		// ---------------TGB Selection--------------------------//
		greenBibLinkPage();
		if (data.get("tgb").equalsIgnoreCase("yes")) {
			wait.waitForVisible(greenBibyes);
			wait.waitForClickable(greenBibyes);
			greenBibyes.click();
		} else {
			Logs.info("TGB No option selected....");
		}

		// ----------------------Proceed Button----------------------//
		waitThread(2000);
		scrollElementInToView(proceedBtn);
		Logs.info("Going for clicking the proceed Button....");
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].click();", proceedBtn);
		Logs.info("Proceed Btn clickied....");
		Logs.info("Going for Order Summary Page....");
		return new OrderSummaryPage();

	}

	// ---------------TGB how page(seperate page)
	// Selection--------------------------//
	public void greenBibLinkPage() {
		parentWindow = driver.getWindowHandle();
		wait.waitForVisible(greenBibhowPage);
		wait.waitForClickable(greenBibhowPage);
		greenBibhowPage.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		for (String window : driver.getWindowHandles()) {
			if (!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}
		verifygreenBibLinkPageAndReturn();
	}

	private void verifygreenBibLinkPageAndReturn() {
		try {
			String greenBibPage_actualTitle = driver.getTitle();
			Assert.assertTrue(greenBibPage_actualTitle.contains("Green Bib"),
					"Expected title to contain 'Green Bib' but found: " + greenBibPage_actualTitle);
		} finally {
			driver.close();
			driver.switchTo().window(parentWindow);
			Logs.info("Switched back to parent window");
		}

	}

	private void selectAddOns(String addOnToSelect) throws InterruptedException {

		// WebDriver driver = driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Logs.info("Fetching list of AddOns...");

		waitThread(5000);
		List<WebElement> addOnCards = driver.findElements(By.xpath("//div[contains(@class,'addOn-container')]"));

		Logs.info("Total AddOns found: " + addOnCards.size());

		for (WebElement addOn : addOnCards) {

			// Find the AddOn name inside the card
			WebElement nameElement = addOn.findElement(By.xpath(".//p[contains(@class,'h5')]"));
			String addOnName = nameElement.getText().trim();

			Logs.info("Checking AddOn: " + addOnName);

			if (addOnName.equalsIgnoreCase(addOnToSelect)) {
				waitThread(5000);

				Logs.info("MATCH FOUND -> " + addOnName);
				scrollElementInToView(nameElement);
				waitThread(5000);

				// Click PLUS BUTTON inside this addon card
				WebElement plusBtn = addOn.findElement(By.xpath(".//div[contains(@class,'btn-color')]"));

				wait.until(ExpectedConditions.elementToBeClickable(plusBtn)).click();
				Logs.info("Clicked (+) button to add addon.");

				// Let Angular load the dropdown below (if required)
				Thread.sleep(5000);

				// --- CHECK FOR DROPDOWN AFTER ADDON EXPANDS ---
				// Find the FIRST DROPDOWN that appears below this card
				WebElement dropdownCard = wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath(".//div[@class='card mb-2 ng-star-inserted']")));

				Logs.info("Dropdown card appeared... searching dropdown");

				WebElement dropdown = dropdownCard.findElement(By.xpath(".//select[contains(@class,'form-select')]"));

				wait.until(ExpectedConditions.elementToBeClickable(dropdown));
				dropdown.click();

				// Select size M
				selectByVisibleText(dropdown, "M");

				Logs.info("Selected size: M");

				return;

				/*
				 * if (dropdownList.size() > 0) {
				 * 
				 * Logs.info("Dropdown FOUND for AddOn -> Selecting size...");
				 * 
				 * WebElement sizeDropdown = dropdownList.get(0);
				 * 
				 * wait.until(ExpectedConditions.visibilityOf(sizeDropdown));
				 * wait.until(ExpectedConditions.elementToBeClickable(sizeDropdown)).click();
				 * 
				 * // Select the size (You can parameterize this if needed)
				 * selectByVisibleText(sizeDropdown, "M");
				 * 
				 * Logs.info("Size 'M' selected successfully!");
				 * 
				 * } else { Logs.
				 * info("NO dropdown available for this AddOn. Continuing without size selection."
				 * ); }
				 * 
				 * return; // done with required addon
				 */ }
		}

		throw new RuntimeException("AddOn not found: " + addOnToSelect);
	}

	public void selectByVisibleText(WebElement dropdown, String text) {

		List<WebElement> options = dropdown.findElements(By.tagName("option"));
		Logs.info("Available size options: " + options.size());

		for (WebElement option : options) {
			String optionText = option.getText().trim();

			if (optionText.equalsIgnoreCase(text.trim())) {

				if (!option.isEnabled()) {
					throw new RuntimeException("Option is disabled: " + text);
				}

				option.click();
				Logs.info("Clicked option: " + text);
				return;
			}
		}

		throw new RuntimeException("Option not found: " + text);
	}

	private boolean isAddOnsSectionAvailable() {
		List<WebElement> addOnsList = driver.findElements(By.xpath("//div[contains(@class,'addOn-container')]"));

		return !addOnsList.isEmpty();

	}

	// ----------------------class level methods-------------------//

	public void addItem() {
		addButton.click();
	}

	public int getQuantity() {
		return Integer.parseInt(quantity.getText().trim());

	}

	public String getPrice() {
		return addOnPrice.getText().replace("Price :", "").trim();
	}

	private void waitThread(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void scrollElementInToTop(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'start', inline:'nearest'});",
				element);
	}

	public void scrollElementInToView(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center', inline:'nearest'});",
				element);
	}

	public void scrollElementInToEnd(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'end', inline:'nearest'});",
				element);
	}

}
