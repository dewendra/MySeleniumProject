package com.procam.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.procam.actiondriver.Action;
import com.procam.base.BaseClass;
import com.procam.utils.DriverFactory;
import com.procam.utils.DropdownHelper;
import com.procam.utils.Logs;
import com.procam.utils.WaitHelper;

public class EventCriteriaPage extends BaseClass {

	Action action;
	WaitHelper wait;
	@FindBy(xpath = "//div[contains(@class,'fs-3')]//span[contains(@class,'btn-fa-color')]")
	private WebElement upBackBtn;

	@FindBy(xpath = "//h5[normalize-space()='Do you want to participate in the on-ground event?']")
	private WebElement onGroundEventPage;

	@FindBy(xpath = "//input[@id='flexRadioDefault1']")
	private WebElement participateInONGroundEventYes;

	@FindBy(xpath = "//input[@id='flexRadioDefault2']")
	private WebElement participateInONGroundEventNo;

	// @FindBy(xpath =
	// "//ng-select[@bindvalue='name']//span[@class='ng-arrow-wrapper']")
	// @FindBy(xpath = "//ng-select[@bindvalue='name']")
	@FindBy(xpath = "//ng-select[@bindvalue='name']//div[contains(@class,'ng-select-container')]")
	private WebElement selectRaceCategoryDropDown;

	@FindBy(xpath = "//ng-dropdown-panel[@role='listbox']//div[contains(@class,'ng-option')]")
	private WebElement raceCategoryDropDownList;

	@FindBy(xpath = "//input[@id='Timed Runner']")
	private WebElement timedRunner;

	@FindBy(xpath = "//label[contains(normalize-space(), \"Women's Criteria (with prior timing certificate)\")]")
	private WebElement WomenCriteriaWithTimingCertificate;

	@FindBy(xpath = "//label[contains(normalize-space(), \"Women's Criteria (without prior timing certificate)\")]")
	private WebElement WomenCriteriaWithoutTimingCertificate;

	@FindBy(xpath = "//label[contains(normalize-space(), \"General Criteria\")]")
	private WebElement generalCriteria;

	@FindBy(xpath = "//input[@name='timingcerfLink']")
	private WebElement timingCertificateLink;

	@FindBy(xpath = "//input[@name='eventName']")
	private WebElement eventName;

	@FindBy(xpath = "//div[contains(@class,'ng-placeholder') and normalize-space()='Select Category']")
	private WebElement raceCategory;

	@FindBy(xpath = "//input[@name='bib']")
	private WebElement bibNumber;

	@FindBy(xpath = "//input[contains(@class,'calendar-input')]")
	private WebElement eventConductedDate;

	@FindBy(xpath = "//input[@name='finishTime' and @formcontrolname='hours']")
	private WebElement hoursInput;

	@FindBy(xpath = "//input[@name='finishTime' and @formcontrolname='min']")
	private WebElement minutesInput;

	@FindBy(xpath = "//input[@name='finishTime' and @formcontrolname='sec']")
	private WebElement secondsInput;

	@FindBy(xpath = "//ng-select[@formcontrolname='idProofType']//span[contains(@class,'ng-arrow-wrapper')]")
	private WebElement selectIdProofType;

	@FindBy(xpath = "//input[@name='adharCardNumber']")
	private WebElement selectedIdProofNumberInput;

	@FindBy(xpath = "//label[@for='idproof']")
	private WebElement uploadIdProof;

	@FindBy(xpath = "//label[@for='profileImage']")
	private WebElement uploadProfileImage;

	@FindBy(xpath = "//input[@name='emergencyName']")
	private WebElement emergencyContactPersonName1;

	@FindBy(xpath = "//input[@name='mobile']")
	private WebElement emergencyContactPersonMobileNumber1;

	@FindBy(xpath = "//input[@name='relationShipFirstEmer']")
	private WebElement emergencyContactPersonRelationship1;

	@FindBy(xpath = "//input[@name='emergencyNameSec']")
	private WebElement emergencyContactPersonName2;

	@FindBy(xpath = "//input[@name='mobileSecond']")
	private WebElement emergencyContactPersonMobileNumber2;

	@FindBy(xpath = "//input[@name='relationShipSecoEmer']")
	private WebElement emergencyContactPersonRelationship2;

	@FindBy(xpath = "//ng-select[@bindvalue='key']//span[contains(@class,'ng-arrow-wrapper')]")
	private WebElement transportToUse;

	@FindBy(xpath = "//input[@type='radio' and @value='1799']")
	private WebElement raceDayIsSpecialYes;

	@FindBy(xpath = "//input[@type='radio' and @value='1800']")
	private WebElement raceDayIsSpecialNo;

	@FindBy(xpath = "//ng-select[@formcontrolname='hearabout']//span[contains(@class,'ng-arrow-wrapper')]")
	private WebElement hearAboutInput;

	@FindBy(xpath = "//input[@id='appEnabledY']")
	private WebElement ForVirtualEventYes;

	@FindBy(xpath = "//input[@id='appEnabledN']")
	private WebElement ForVirtualEventNo;

	@FindBy(xpath = "//ng-select[@bindvalue='raceCategoryName']//span[contains(@class,'ng-arrow-wrapper')]")
	private WebElement selectVirtualRaceCategory;

	@FindBy(xpath = "//div[contains(@class,'ng-dropdown-panel')]//div/div")
	private WebElement virtualRaceCategoryOptions;

	@FindBy(xpath = "//button[@type='submit' and normalize-space()='Back']")
	private WebElement downBackBtn;

	@FindBy(xpath = "//button[normalize-space()='Proceed']")
	private WebElement proceedBtn;

	public EventCriteriaPage() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
		wait = new WaitHelper(DriverFactory.getDriver());
	}

	public void enterEventDetails() {
		waitThread(5000);
		scrollElementInToTop(onGroundEventPage);
		wait.waitForVisible(participateInONGroundEventYes);
		wait.waitForClickable(participateInONGroundEventYes);
		Logs.info("Ground Event radio button clicking...");
		participateInONGroundEventYes.click();
		Logs.info("Ground Event radio button clicked...");

		// waitThread(5000);
		// wait.waitForVisible(selectRaceCategoryDropDown);
		// wait.waitForClickable(selectRaceCategoryDropDown);
		// Logs.info("Rcae Category Dropdown Clicking..");
		// selectRaceCategoryDropDown.click();
		// Logs.info("Rcae Category Dropdown Clicked..");

		// wait.waitForVisible(raceCategoryDropDownList);
		// wait.waitForClickable(raceCategoryDropDownList);
		selectRaceCategory1("Open 10K (10 km)");

		wait.waitForVisible(timedRunner);
		wait.waitForClickable(timedRunner);
		Logs.info("Timed Runner radio button clicking...");
		timedRunner.click();
		Logs.info("Timed Runner radio button clicked...");

		wait.waitForVisible(timingCertificateLink);
		wait.waitForClickable(timingCertificateLink);
		Logs.info("Entering Timing Certificate Link...");
		timingCertificateLink.sendKeys("https://www.example.com/timming/certificate");
		Logs.info("Timing Certificate Link entered...");

		wait.waitForVisible(eventName);
		wait.waitForClickable(eventName);
		Logs.info("Entering Event Name...");
		eventName.sendKeys("Vedanta Delhi Half Marathon 2025");
		Logs.info("Event Name entered...");

		// wait.waitForVisible(raceCategory);
		// wait.waitForClickable(raceCategory);
		// raceCategory.click();
		selectEventRaceCategory("10 Km");

		wait.waitForVisible(bibNumber);
		wait.waitForClickable(bibNumber);
		Logs.info("Entering Bib number...");
		bibNumber.sendKeys("12005");
		Logs.info("Bib number entered...");

		wait.waitForVisible(eventConductedDate);
		wait.waitForClickable(eventConductedDate);
		Logs.info("Entering Event Conducted Date...");
		eventConductedDate.sendKeys("19-10-2025");
		Logs.info("Event Conducted Date entered...");

		wait.waitForVisible(hoursInput);
		wait.waitForClickable(hoursInput);
		Logs.info("Entering Hours...");
		hoursInput.sendKeys("01");
		Logs.info("Hours entered...");

		wait.waitForVisible(minutesInput);
		wait.waitForClickable(minutesInput);
		minutesInput.sendKeys("24");

		wait.waitForVisible(secondsInput);
		wait.waitForClickable(secondsInput);
		secondsInput.sendKeys("38");

		wait.waitForVisible(selectIdProofType);
		wait.waitForClickable(selectIdProofType);
		selectIdProofType.click();
		selectAddressFromList("Aadhar Card");

		wait.waitForVisible(selectedIdProofNumberInput);
		wait.waitForClickable(selectedIdProofNumberInput);
		selectedIdProofNumberInput.sendKeys("8888 1111 5555");

		wait.waitForVisible(uploadIdProof);
		wait.waitForClickable(uploadIdProof);
		uploadIdProof.click();

		wait.waitForVisible(uploadProfileImage);
		wait.waitForClickable(uploadProfileImage);
		uploadProfileImage.click();

		wait.waitForVisible(emergencyContactPersonName1);
		wait.waitForClickable(emergencyContactPersonName1);
		emergencyContactPersonName1.clear();
		emergencyContactPersonName1.sendKeys("Pihu Fifteen");

		wait.waitForVisible(emergencyContactPersonMobileNumber1);
		wait.waitForClickable(emergencyContactPersonMobileNumber1);
		emergencyContactPersonMobileNumber1.clear();
		emergencyContactPersonMobileNumber1.sendKeys("9876543225");

		wait.waitForVisible(emergencyContactPersonRelationship1);
		wait.waitForClickable(emergencyContactPersonRelationship1);
		emergencyContactPersonRelationship1.clear();
		emergencyContactPersonRelationship1.sendKeys("Mother");

		wait.waitForVisible(emergencyContactPersonName2);
		wait.waitForClickable(emergencyContactPersonName2);
		emergencyContactPersonName2.clear();
		emergencyContactPersonName2.sendKeys("John Fifteen");

		wait.waitForVisible(emergencyContactPersonMobileNumber2);
		wait.waitForClickable(emergencyContactPersonMobileNumber2);
		emergencyContactPersonMobileNumber2.clear();
		emergencyContactPersonMobileNumber2.sendKeys("9876543215");

		wait.waitForVisible(emergencyContactPersonRelationship2);
		wait.waitForClickable(emergencyContactPersonRelationship2);
		emergencyContactPersonRelationship2.clear();
		emergencyContactPersonRelationship2.sendKeys("Father");

		wait.waitForVisible(transportToUse);
		wait.waitForClickable(transportToUse);
		transportToUse.click();
		selectTransportToUse("Car");

		wait.waitForVisible(raceDayIsSpecialNo);
		wait.waitForClickable(raceDayIsSpecialNo);
		raceDayIsSpecialNo.click();

		wait.waitForVisible(hearAboutInput);
		wait.waitForClickable(hearAboutInput);
		hearAboutInput.click();
		selectTransportToUse("Online");

		wait.waitForVisible(ForVirtualEventNo);
		wait.waitForClickable(ForVirtualEventNo);
		ForVirtualEventNo.click();

		wait.waitForVisible(proceedBtn);
		wait.waitForClickable(proceedBtn);
		// proceedBtn.click();

	}

	private void selectTransportToUse(String transportToSelect) {
		// TODO Auto-generated method stub

	}

	private void selectAddressFromList(String addressToSelect) {
		// TODO Auto-generated method stub

	}

	private void selectEventRaceCategory(String eventRaceCategoryToSelect) {
		wait.waitForVisible(raceCategory);
		wait.waitForClickable(raceCategory);
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		js.executeScript("arguments[0].dispatchEvent(new Event('mousedown', {bubbles:true}));",
				selectRaceCategoryDropDown);
		js.executeScript("arguments[0].dispatchEvent(new Event('mouseup', {bubbles:true}));",
				selectRaceCategoryDropDown);

		Logs.info("Dropdown opened...");

		waitThread(1500);
		
		List<WebElement> eventRaceCategoryList = DriverFactory.getDriver()
				.findElements(By.xpath("//div[contains(@class,'ng-option')]"));
		waitThread(5000);
		System.out.println("Event RaceCategory List Size: " + eventRaceCategoryList.size());
		for (WebElement eventRaceCategory : eventRaceCategoryList) {
			System.out.println(eventRaceCategory.getText().toString());
		}
		DropdownHelper dropdown = new DropdownHelper(DriverFactory.getDriver());
		dropdown.selectFromList(eventRaceCategoryList, eventRaceCategoryToSelect);
		Logs.info("Event Race Category selected from dropdown: " + eventRaceCategoryToSelect);

	}

	private void selectRaceCategory(String receCategoryToSelect) {

		waitThread(7000);
		wait.waitForVisible(selectRaceCategoryDropDown);
		wait.waitForClickable(selectRaceCategoryDropDown);
		System.out.println("Dropdown displayed: " + selectRaceCategoryDropDown.isDisplayed());
		System.out.println("Dropdown enabled: " + selectRaceCategoryDropDown.isEnabled());
		Logs.info("Rcae Category Dropdown Clicking..");

		Actions actions = new Actions(DriverFactory.getDriver());
		actions.moveToElement(selectRaceCategoryDropDown).click().pause(Duration.ofMillis(200)).click().perform();

		// safeClick(selectRaceCategoryDropDown);
		Logs.info("Rcae Category Dropdown Clicked..");
		waitThread(7000);
		Logs.info("Getting list of all available options..");
		List<WebElement> raceCategoryList = DriverFactory.getDriver().findElements(
				By.xpath("//ng-dropdown-panel[@role='listbox']//div[contains(@class,'ng-dropdown-panel-items')]"));

		Logs.info("Capturing of all available options..");
		System.out.println("RaceCategory List Size: " + raceCategoryList.size());
		if (raceCategoryList.size() > 0) {
			Logs.info("Fetching the all list and printing one by one...");
			for (WebElement raceCategory : raceCategoryList) {
				System.out.println(raceCategory.getText().toString());
				Logs.info("All list printed...");
				DropdownHelper dropdown = new DropdownHelper(DriverFactory.getDriver());
				Logs.info("selecting the options from the available list by using helper class..");
				dropdown.selectFromList(raceCategoryList, receCategoryToSelect);
				Logs.info("Race Category selected from dropdown: " + receCategoryToSelect);

			}
		} else {
			Logs.info("List is empty");
		}

	}

	private void selectRaceCategory1(String receCategoryToSelect) {

		wait.waitForVisible(selectRaceCategoryDropDown);
		wait.waitForClickable(selectRaceCategoryDropDown);

		// OPEN DROPDOWN USING JS (stable)
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		js.executeScript("arguments[0].dispatchEvent(new Event('mousedown', {bubbles:true}));",
				selectRaceCategoryDropDown);
		js.executeScript("arguments[0].dispatchEvent(new Event('mouseup', {bubbles:true}));",
				selectRaceCategoryDropDown);

		Logs.info("Dropdown opened...");

		waitThread(1500); // give ng-select time to render the panel

		List<WebElement> raceCategoryList = DriverFactory.getDriver()
				.findElements(By.xpath("//div[contains(@class,'ng-option')]"));

		System.out.println("Options found: " + raceCategoryList.size());

		if (raceCategoryList.size() == 0) {
			throw new RuntimeException("Dropdown opened but no options visible—means it closed instantly.");
		}

		for (WebElement option : raceCategoryList) {
			if (option.getText().trim().equalsIgnoreCase(receCategoryToSelect)) {
				js.executeScript("arguments[0].scrollIntoView(true);", option);
				option.click();
				Logs.info("Selected: " + receCategoryToSelect);
				return;
			}
		}

		throw new RuntimeException("Option not found: " + receCategoryToSelect);
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

	public void safeClick(WebElement element) {
		// ((JavascriptExecutor) DriverFactory.getDriver())
		// .executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
		((JavascriptExecutor) DriverFactory.getDriver()).executeScript("arguments[0].click();", element);
	}

	private void waitThread(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
