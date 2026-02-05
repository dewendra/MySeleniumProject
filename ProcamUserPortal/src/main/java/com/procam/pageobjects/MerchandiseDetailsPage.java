package com.procam.pageobjects;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.procam.actiondriver.Action;
import com.procam.base.BaseClass;
import com.procam.utils.CommonHelper;
import com.procam.utils.DriverFactory;
import com.procam.utils.DropdownHelper;
import com.procam.utils.Logs;

public class MerchandiseDetailsPage extends BaseClass {

	private static final Logger log=LogManager.getLogger(MerchandiseDetailsPage.class);
	private WebDriver driver;
	Action action;
	WebDriverWait wait;
	String parentWindow;
	CommonHelper helper;

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

	@FindBy(xpath = "//h4[contains(normalize-space(),'philanthropy platform')]")
	private WebElement philanthropyPlatform;

	@FindBy(xpath = "//ng-select[@id='causeName']//span[contains(@class,'ng-arrow-wrapper')]")
	private WebElement selectCauseDropDown;

	@FindBy(xpath = "//input[@name='panCardNumber']")
	private WebElement panCardNumber;

	@FindBy(xpath = "//input[@name='panCardName']")
	private WebElement panCardName;
	

	@FindBy(xpath = "//h5[contains(normalize-space(),'fundraising page')]")
	private WebElement fundraisingPageOption;

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
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		helper = new CommonHelper(driver);
	}

	public OrderSummaryPage enterMerchandiseDetails(Map<String, String> data) throws InterruptedException {
		// Thread.sleep(7000);
		// ------------------------Addons Option-----------------------//
		log.info("Checking if Addons section is available...");
		if (isAddOnsSectionAvailable()) {
			log.info("Addons section found");
			helper.scrollElementInToView(addonsYes);
			if (data.get("addOns").equalsIgnoreCase("yes")) {
				helper.clickWithRetry(addonsYes);
				log.info("addons Yes option selected...");
				log.info("Going to select addons form available merchandise...");

				selectAddOns(data.get("addOnName"));

			} else {
				log.info("addons No option selected...");
				helper.clickWithRetry(addonsNo);

			}
		} else {
			log.info("Addons section NOT present : skipping to Donation");
		}

		
		// ---------------Fund Raiser--------------------------//
		log.info("Going for selecting the fund Raise option....");
		/*
		 * if (data.get("fundRaise").equalsIgnoreCase("Yes")) {
		 * helper.clickWithRetry(fundRaiseYes); } else {
		 * helper.clickWithRetry(fundRaiseNo);
		 * Logs.info("Fund Raise No option selected...."); }
		 */

		// ---------------TGB Selection--------------------------//
		if (isGreenBibSectionAvailable()) {
			log.info("Green Bib section found");
			greenBibLinkPage();
			helper.scrollElementInToView(greenBibyes);
			if (data.get("tgb").equalsIgnoreCase("Yes")) {
				helper.clickWithRetry(greenBibyes);
				log.info("Green Bib Yes option selected...");
			} else {
				log.info("Green Bib No option selected...");
				helper.clickWithRetry(greenBibNo);
			}
		} else {
			log.info("Green Bib section NOT present : skipping to Green Bib");
		}

		/*
		 * if (data.get("tgb").equalsIgnoreCase("yes")) {
		 * helper.clickWithRetry(greenBibyes); } else {
		 * helper.clickWithRetry(greenBibNo); Logs.info("TGB No option selected...."); }
		 */

		// ----------------------Proceed Button----------------------//
		helper.scrollElementInToView(proceedBtn);
		log.info("Going for clicking the proceed Button....");
		helper.clickWithRetry(proceedBtn);

		log.info("Going for Order Summary Page....");
		return new OrderSummaryPage();

	}

	// ----------------------Additional Donation----------------------//
	private void selectDonationaAmount(String donationAmountToSelect) {

		List<WebElement> donationList = driver.findElements(By.xpath("//div[@id='ngoDonationAmount']//span//span"));
		System.out.println("Total donation options available:->" + donationList.size());

		for (WebElement amount : donationList) {
			System.out.println(amount.getText());
		}
		/*
		 * for (WebElement amount : donationList) { String amountText =
		 * amount.getText().trim(); if
		 * (amountText.equalsIgnoreCase(donationAmountToSelect)) { amount.click();
		 * return; } }
		 */

		DropdownHelper dropdown = new DropdownHelper(driver);
		dropdown.selectFromList(donationList, donationAmountToSelect);
		log.info("Donation amount selected from dropdown: " + donationAmountToSelect);

	}

	private void makingAdditionalDonation(String causeToSearch, String causeToSelect, String panNumber,
			String nameOnPan) {

		wait.until(ExpectedConditions.elementToBeClickable(selectCauseDropDown));
		helper.scrollElementInToTop(selectCauseDropDown);
		log.info("Selecting Cause from dropdown: ");

		By causeDropdown = By.xpath("//ng-select[@id='causeName']//span[contains(@class,'ng-arrow-wrapper')]");
		System.out.println("Dropdown cause: ->" + causeDropdown);
		try {
			//helper.selectFromNgSelect(causeDropdown, causeToSelect);
			 helper.searchAndSelectFromNgSelect2(causeDropdown, causeToSearch, causeToSelect);
			 log.info("Cause selected: " + causeToSelect);
		} catch (Exception e) {

			e.printStackTrace();
		}

		wait.until(ExpectedConditions.elementToBeClickable(panCardNumber));
		panCardNumber.sendKeys(panNumber);

		wait.until(ExpectedConditions.elementToBeClickable(panCardName));
		panCardName.sendKeys(nameOnPan);

	}

	// ---------------TGB how page(seperate page)
	// Selection--------------------------//
	public void greenBibLinkPage() {
		parentWindow = driver.getWindowHandle();
		wait.until(ExpectedConditions.elementToBeClickable(greenBibhowPage));
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
			log.info("Switched back to parent window");
		}

	}

	private void selectAddOns(String addOnToSelect) throws InterruptedException {

		// WebDriver driver = driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		log.info("Fetching list of AddOns...");

		waitThread(5000);
		List<WebElement> addOnCards = driver.findElements(By.xpath("//div[contains(@class,'addOn-container')]"));

		log.info("Total AddOns found: " + addOnCards.size());

		for (WebElement addOn : addOnCards) {

			// Find the AddOn name inside the card
			WebElement nameElement = addOn.findElement(By.xpath(".//p[contains(@class,'h5')]"));
			String addOnName = nameElement.getText().trim();

			log.info("Checking AddOn: " + addOnName);

			if (addOnName.equalsIgnoreCase(addOnToSelect)) {
				waitThread(5000);

				log.info("MATCH FOUND -> " + addOnName);
				helper.scrollElementInToView(nameElement);
				waitThread(5000);

				// Click PLUS BUTTON inside this addon card
				WebElement plusBtn = addOn.findElement(By.xpath(".//div[contains(@class,'btn-color')]"));

				wait.until(ExpectedConditions.elementToBeClickable(plusBtn)).click();
				log.info("Clicked (+) button to add addon.");

				// Let Angular load the dropdown below (if required)
				Thread.sleep(5000);

				// --- CHECK FOR DROPDOWN AFTER ADDON EXPANDS ---
				// Find the FIRST DROPDOWN that appears below this card
				WebElement dropdownCard = wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath(".//div[@class='card mb-2 ng-star-inserted']")));

				log.info("Dropdown card appeared... searching dropdown");

				WebElement dropdown = dropdownCard.findElement(By.xpath(".//select[contains(@class,'form-select')]"));

				wait.until(ExpectedConditions.elementToBeClickable(dropdown));
				dropdown.click();

				// Select size M
				selectByVisibleText(dropdown, "M");

				log.info("Selected size: M");

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
		log.info("Available size options: " + options.size());

		for (WebElement option : options) {
			String optionText = option.getText().trim();

			if (optionText.equalsIgnoreCase(text.trim())) {

				if (!option.isEnabled()) {
					throw new RuntimeException("Option is disabled: " + text);
				}

				option.click();
				log.info("Clicked option: " + text);
				return;
			}
		}

		throw new RuntimeException("Option not found: " + text);
	}

	private boolean isAddOnsSectionAvailable() {
		List<WebElement> addOnsList = driver.findElements(By.xpath("//div[contains(@class,'addOn-container')]"));

		return !addOnsList.isEmpty();

	}

	// ---------------Checking the Green bib option available-----------

	private boolean isGreenBibSectionAvailable() {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		List<WebElement> greenBibOptions = driver.findElements(By.xpath("//input[@id='donationyGreenBib']"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return !greenBibOptions.isEmpty();
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

}
