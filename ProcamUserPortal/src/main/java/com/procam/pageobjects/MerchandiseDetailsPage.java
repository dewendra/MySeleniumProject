package com.procam.pageobjects;

import java.rmi.server.LogStream;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.procam.actiondriver.Action;
import com.procam.base.BaseClass;
import com.procam.utils.DriverFactory;
import com.procam.utils.DropdownHelper;
import com.procam.utils.Logs;
import com.procam.utils.WaitHelper;

public class MerchandiseDetailsPage extends BaseClass {

	Action action;
	WaitHelper wait;

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

	@FindBy(xpath = "//input[@id='donantionN']")
	private WebElement donantionNo;

	@FindBy(xpath = "//input[@name='fundRaise']/following-sibling::label[normalize-space()='Yes']")
	private WebElement fundRaiseYes;

	@FindBy(xpath = "//input[@name='fundRaise']/following-sibling::label[normalize-space()='No']")
	private WebElement fundRaiseNo;

	@FindBy(xpath = "//button[@type='submit' and normalize-space()='Back']")
	private WebElement downBackBtn;

	@FindBy(xpath = "//button[normalize-space()='Proceed']")
	private WebElement proceedBtn;

	// List<WebElement>addOnList=DriverFactory.getDriver().findElements(By.xpath("//div[contains(@class,'addOn-container
	// row')]"));

	public MerchandiseDetailsPage() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
		wait = new WaitHelper(DriverFactory.getDriver());
	}

	public OrderSummaryPage enterMerchandiseDetails() throws InterruptedException {
		waitThread(5000);
		// wait.waitForVisible(addonsYes);
		scrollElementInToView(addonsYes);

		wait.waitForVisible(addonsYes);
		wait.waitForClickable(addonsYes);
		addonsYes.click();

		waitThread(2000);
		Logs.info("Going for selecting the Addons....");
		selectAddOns("Unisex Herringbone Polo -India Blue");
		//selectAddOns("Unisex Flyer Cap-Blue");
		//selectAddOns1("Unisex Flyer Cap-Blue");

		wait.waitForVisible(donantionNo);
		wait.waitForClickable(donantionNo);
		donantionNo.click();

		wait.waitForVisible(fundRaiseNo);
		wait.waitForClickable(fundRaiseNo);
		fundRaiseNo.click();

		waitThread(2000);
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) DriverFactory.getDriver();
		javascriptExecutor.executeScript("arguments[0].click();", proceedBtn);

		return new OrderSummaryPage();

	}

	private void selectAddOns1(String addOnToSelect) throws InterruptedException {

		WebDriver driver = DriverFactory.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		Logs.info("Fetching list of AddOns...");
		List<WebElement> addOnCards = driver.findElements(By.xpath("//div[contains(@class,'addOn-container')]"));
		Logs.info("Total AddOns found: " + addOnCards.size());

		for (int i = 0; i < addOnCards.size(); i++) {

			// ALWAYS RE-FIND the element to avoid stale
			WebElement addOn = driver.findElements(By.xpath("//div[contains(@class,'addOn-container')]")).get(i);

			WebElement nameElement = addOn.findElement(By.xpath(".//p[contains(@class,'h5')]"));
			String addOnName = nameElement.getText().trim();

			Logs.info("Checking AddOn: " + addOnName);

			if (addOnName.equalsIgnoreCase(addOnToSelect)) {

				Logs.info("MATCH FOUND -> " + addOnName);
				scrollElementInToView(nameElement);

				WebElement plusBtn = addOn.findElement(By.xpath(".//div[contains(@class,'btn-color')]"));
				wait.until(ExpectedConditions.elementToBeClickable(plusBtn)).click();
				Logs.info("Clicked (+) button");
				// Logs.info("(+) button and and another div opened for selecting the addon
				// size...");

				Thread.sleep(5000);

				// 🔥🔥 KEY FIX: RE-FIND THE SAME ADDON CARD AGAIN AFTER CLICK
				WebElement addOnNext = driver.findElements(By.xpath("//div[contains(@class,'addOn-container')]"))
						.get(i);

				// Now search dropdown INSIDE this fresh AddOn card
				Logs.info("getting list of all available dropdowns...");
				List<WebElement> dropdownList = addOnNext
						.findElements(By.xpath(".//select[contains(@class,'form-select')]"));
				System.out.println("List of dropdowns:" + dropdownList.size());

				if (dropdownList.isEmpty()) {
					Logs.info("No dropdown for this addOn → skipping size selection.");
					return;
				}

				Logs.info("working on the 1st dropdowns....");
				WebElement sizeDropdown = dropdownList.get(0);

				Logs.info("Clicking on 1st dropdown...");

				wait.until(ExpectedConditions.visibilityOf(sizeDropdown));
				wait.until(ExpectedConditions.elementToBeClickable(sizeDropdown));
				Logs.info("1st dropdown clicked...");
				sizeDropdown.click();
				Logs.info("getting list of 1st dropdowns...");
				selectByVisibleText(sizeDropdown, "M");

				Logs.info("Size M selected.");
				return;
			}
		}

		throw new RuntimeException("AddOn not found: " + addOnToSelect);
	}

	private void selectAddOns(String addOnToSelect) throws InterruptedException {

		WebDriver driver = DriverFactory.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Logs.info("Fetching list of AddOns...");

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
				WebElement dropdownCard = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                    By.xpath(".//div[@class='card mb-2 ng-star-inserted']")
	            ));

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
				 */			}
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
		((JavascriptExecutor) DriverFactory.getDriver()).executeScript("arguments[0].scrollIntoView({block: 'start'});",
				element);
	}

	public void scrollElementInToView(WebElement element) {
		((JavascriptExecutor) DriverFactory.getDriver())
				.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
	}

	public void scrollElementInToEnd(WebElement element) {
		((JavascriptExecutor) DriverFactory.getDriver()).executeScript("arguments[0].scrollIntoView({block: 'end'});",
				element);
	}

}
