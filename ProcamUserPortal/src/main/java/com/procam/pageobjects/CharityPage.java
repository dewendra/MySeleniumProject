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

import com.procam.actiondriver.Action;
import com.procam.base.BaseClass;
import com.procam.utils.CommonHelper;
import com.procam.utils.DriverFactory;
import com.procam.utils.DropdownHelper;
import com.procam.utils.Logs;

public class CharityPage extends BaseClass{
	
	private static final Logger log=LogManager.getLogger(CharityPage.class);
	private WebDriver driver;
	Action action;
	WebDriverWait wait;
	CommonHelper helper;
	@FindBy(xpath = "//h5[contains(normalize-space(),'philanthropy platform')]")
	private WebElement additionalDonation;
	
	@FindBy(xpath = "//label[normalize-space()='Yes' and @for='donationy']")
	private WebElement donationsYes;

	@FindBy(xpath = "//label[normalize-space()='No' and @for='donantionN']")
	private WebElement donationsNo;
	
	@FindBy(xpath = "//input[@formcontrolname='donationAmount']")
	private WebElement donationAmount;

	
	@FindBy(xpath = "//div[@id='ngoDonationAmount']//span//span")
	private List<WebElement> ngoDonationAmountList;

	@FindBy(xpath = "//ng-select[@id='causeName']//span[contains(@class,'ng-arrow-wrapper')]")
	private WebElement selectCauseDropDown;
	
	@FindBy(xpath = "//ng-select[@id='ngoName']//span[contains(@class,'ng-arrow-wrapper')]")
	private WebElement selectNgoDropDown;

	@FindBy(xpath = "//input[@name='panCardNumber']")
	private WebElement panCardNumber;

	@FindBy(xpath = "//input[@name='panCardName']")
	private WebElement panCardName;
	
	@FindBy(xpath = "//label[@for='generateCertificate']")
	private WebElement generateCertificate;
	
	@FindBy(xpath = "//label[@for='generateCertificateYes']")
	private WebElement generateCertificateYes;
	
	@FindBy(xpath = "//label[@for='generateCertificateNo']")
	private WebElement generateCertificateNo;
	
	@FindBy(xpath = "//h5[contains(normalize-space(),'Support the cause')]")
	private WebElement supportTheCause;
	
	@FindBy(xpath = "//label[normalize-space()='Yes' and @for='donationByFund']")
	private WebElement supportTheCauseYes;
	
	@FindBy(xpath = "//div[contains(@class,'cdk-overlay-pane')]//button[normalize-space()='Close']")
	private WebElement causePopUpCloseBtn;
	
	@FindBy(xpath = "//label[normalize-space()='No' and @for='donationByFund']")
	private WebElement supportTheCauseNo;
	
	@FindBy(xpath = "//div[contains(@class,'item-count')]")
	private WebElement itemCount;
	
	@FindBy(xpath = "//div[contains(@class,'cart-wrapper')]")
	private WebElement cartWrapper;
	
	@FindBy(xpath = "//div[contains(@class,'cart-wrapper')]//app-cart-details-view/div")
	private List<WebElement> cartDetailsViewList;
	
	@FindBy(xpath = "//div[contains(@class,'total-amount')]")
	private WebElement totalAmount;
	
	@FindBy(xpath = "//span[contains(normalize-space(),'Continue')]")
	private WebElement continueBtn;
	
	
	public CharityPage() {
		this.driver=DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		helper=new CommonHelper(driver);
		helper.waitForPageToLoad();
	}

	public MerchandiseDetailsPage charityAndTgb(Map<String, String> data) {
		
		
		
		
		
		// ---------------------Donation ----------------------------//

				// Thread.sleep(5000);
				wait.until(ExpectedConditions.visibilityOf(additionalDonation));
				// wait.until(ExpectedConditions.visibilityOf(philanthropyPlatform));
				// scrollElementInToTop(philanthropyPlatform);
				// scrollElementInToTop(additionalDonation);
				log.info("Going for selecting the Donation option....");
				log.info("Scrolling Top to the Donation option....");
				helper.scrollElementInToView(additionalDonation);

				if (data.get("donation").equalsIgnoreCase("yes")) {
					helper.clickWithRetry(donationsYes);
					log.info("Donantion Yes option selected...");
					selectDonationaAmount(data.get("donationAmount"));
					makingAdditionalDonation(data.get("searchCause"), data.get("causeOfYourChoice"), data.get("panNo"),
							data.get("nameOnPanCard"));

				} else {
					helper.clickWithRetry(donationsNo);
					log.info("donantion No option selected...");
				}
				return new MerchandiseDetailsPage();

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
}
