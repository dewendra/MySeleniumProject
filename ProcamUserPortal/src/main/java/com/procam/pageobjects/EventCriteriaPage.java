package com.procam.pageobjects;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.procam.actiondriver.Action;
import com.procam.base.BaseClass;
import com.procam.utils.DatePickerHelper;
import com.procam.utils.DriverFactory;
import com.procam.utils.DropdownHelper;
import com.procam.utils.Logs;
import com.procam.utils.WaitHelper;

public class EventCriteriaPage extends BaseClass {

	private WebDriver driver;
	Action action;
	WaitHelper wait;
	String parentWindow;

	@FindBy(xpath = "//div[contains(@class,'fs-3')]//span[contains(@class,'btn-fa-color')]")
	private WebElement upBackBtn;

	@FindBy(xpath = "//h5[normalize-space()='Do you want to participate in the on-ground event?']")
	private WebElement onGroundEventPage;

	@FindBy(xpath = "div.d-flex a[href*='https://tatamumbaimarathon.procam.in']")
	private WebElement eventPageLink;

	@FindBy(xpath = "//input[@id='flexRadioDefault1']")
	private WebElement participateInONGroundEventYes;

	@FindBy(xpath = "//input[@id='flexRadioDefault2']")
	private WebElement participateInONGroundEventNo;

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

	@FindBy(css = "ng-select[formcontrolname='raceCategoryId'] .ng-select-container")
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
	private WebElement adharCardNumberInput;

	@FindBy(xpath = "//input[@name='panCardNumber']")
	private WebElement panCardNumberInput;

	@FindBy(xpath = "//label[@for='idproof']")
	private WebElement uploadIdProof;

	@FindBy(xpath = "//label[@for='profileImage']") // input[@type='file' and @accept='image/*']
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

	@FindBy(xpath = "//label[@for='ques']")
	private WebElement specialDay;

	@FindBy(xpath = "//label[normalize-space()='Please select the reason'] /following-sibling::ng-select//div[contains(@class,'ng-select-container')]")
	private WebElement selectTheReason;

	@FindBy(xpath = "//label[contains(normalize-space(),'special occasion')]/ancestor::div[contains(@class,'col-sm-6')]//input[@type='radio' and @value='1721']")
	private WebElement raceDayIsSpecialYes;

	@FindBy(xpath = "//h5[normalize-space()='Do you want to participate in the on-ground event?']/following-sibling::div//input[@type='radio' and @value='1722']")
	private WebElement raceDayIsSpecialNo;

	@FindBy(xpath = "//label[contains(text(),'mode of transport')]/ancestor::div/following-sibling::ng-select//span[contains(@class,'ng-arrow-wrapper')]")
	private WebElement transportToUse;

	@FindBy(xpath = "//ng-select[@formcontrolname='hearabout']//span[contains(@class,'ng-arrow-wrapper')]")
	private WebElement hearAboutInput;

	@FindBy(xpath = "//input[@id='appEnabledY']")
	private WebElement ForVirtualEventYes;
	
	@FindBy(xpath = "div.d-flex a[href*='size_chart']")
	private WebElement sizeChartOptions;

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
		this.driver = DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
		wait = new WaitHelper(driver);
	}

	public void eventLinkPage() {
		parentWindow = driver.getWindowHandle();
		wait.waitForVisible(eventPageLink);
		wait.waitForClickable(eventPageLink);
		eventPageLink.click();
		Logs.info("Clicked on Event Page link");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		
		for (String window : driver.getWindowHandles()) {
			if (!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}
		verifyEventPageLinkAndReturn();
		// driver.switchTo().window(parentWindow);
	}

	private void verifyEventPageLinkAndReturn() {
		try {
			String eventPage_actualTitle = driver.getTitle();
			Assert.assertTrue(eventPage_actualTitle.contains("Tata Mumbai Marathon"),
					"Expected title to contain 'Tata Mumbai Marathon' but found: " + eventPage_actualTitle);
		} finally {
			driver.close();
			driver.switchTo().window(parentWindow);
			Logs.info("Switched back to parent window");
		}

	}

	public MerchandiseDetailsPage enterEventDetails(Map<String, String> data) throws InterruptedException {
		waitThread(5000);
		String select_The_Reason = data.get("selectTheReason");
		String virtual_Race_Category = data.get("virtualRaceCategory");

		scrollElementInToTop(onGroundEventPage);
		Logs.info("Ground Event radio button clicking...");
		if (data.get("participateOnGround").equalsIgnoreCase("Yes")) {
			wait.waitForVisible(participateInONGroundEventYes);
			wait.waitForClickable(participateInONGroundEventYes);
			participateInONGroundEventYes.click();

		} else {
			participateInONGroundEventNo.click();
		}
		Logs.info("Ground Event radio button clicked...");

		selectRaceCategory1(data.get("raceCategory"));

		Logs.info("Selecting criteria from given options...");
		String criteria = data.get("criteriaType");
		if (criteria.equalsIgnoreCase("TimedRunner")) {
			wait.waitForVisible(timedRunner);
			wait.waitForClickable(timedRunner);
			timedRunner.click();
			Logs.info("Timed Runner radio option clicked...");
		} else if (criteria.equalsIgnoreCase("WomenWithTiming")) {
			wait.waitForVisible(WomenCriteriaWithTimingCertificate);
			wait.waitForClickable(WomenCriteriaWithTimingCertificate);
			WomenCriteriaWithTimingCertificate.click();
			Logs.info("Women WithTiming radio option clicked...");
		} else if (criteria.equalsIgnoreCase("WomenWithoutTiming")) {
			wait.waitForVisible(WomenCriteriaWithoutTimingCertificate);
			wait.waitForClickable(WomenCriteriaWithoutTimingCertificate);
			WomenCriteriaWithoutTimingCertificate.click();
			Logs.info("Women WithOut Timing radio option clicked...");
		} else if (criteria.equalsIgnoreCase(" GeneralCriteria ")) {
			wait.waitForVisible(generalCriteria);
			wait.waitForClickable(generalCriteria);
			generalCriteria.click();
			Logs.info("General Criteria radio option clicked...");
		} else {
			System.err.println("Criteria not selected....");
		}

		if (criteria.equalsIgnoreCase("TimedRunner") || criteria.equalsIgnoreCase("WomenWithTiming")) {
			Logs.info("Entering Timing Certificate Link...");
			wait.waitForVisible(timingCertificateLink);
			wait.waitForClickable(timingCertificateLink);
			timingCertificateLink.sendKeys(data.get("timingCertLink"));
			Logs.info("Timing Certificate Link entered...");
		}

		wait.waitForVisible(eventName);
		wait.waitForClickable(eventName);
		Logs.info("Entering Event Name...");
		eventName.sendKeys(data.get("eventName"));
		Logs.info("Event Name entered...");

		selectEventRaceCategory(data.get("eventRaceCategory"));

		wait.waitForVisible(bibNumber);
		wait.waitForClickable(bibNumber);
		Logs.info("Entering Bib number...");
		bibNumber.sendKeys(data.get("bibNumber"));
		Logs.info("Bib number entered...");

		scrollElementInToView(eventConductedDate);
		wait.waitForVisible(eventConductedDate);
		wait.waitForClickable(eventConductedDate);
		Logs.info("Entering Event Conducted Date...");
		DatePickerHelper.selectDate(driver, eventConductedDate, data.get("eventDate"));
		Logs.info("Event Conducted Date entered...");

		wait.waitForVisible(hoursInput);
		wait.waitForClickable(hoursInput);
		Logs.info("Entering Hours...");
		hoursInput.sendKeys(data.get("hours"));
		Logs.info("Hours entered...");

		wait.waitForVisible(minutesInput);
		wait.waitForClickable(minutesInput);
		Logs.info("Entering Minutes...");
		minutesInput.sendKeys(data.get("minutes"));
		Logs.info("Minutes entered...");

		wait.waitForVisible(secondsInput);
		wait.waitForClickable(secondsInput);
		Logs.info("Entering Seconds...");
		secondsInput.sendKeys(data.get("seconds"));
		Logs.info("Seconds entered...");

		selectIdProofFromList(data.get("idProofType"), data.get("idProofNumber"));

		waitThread(5000);
		uploadProfileimage(data.get("profileImagePath"));

		wait.waitForVisible(emergencyContactPersonName1);
		wait.waitForClickable(emergencyContactPersonName1);
		emergencyContactPersonName1.clear();
		emergencyContactPersonName1.sendKeys(data.get("emergencyName1"));
		Logs.info("Emergency Name1 entered...");

		wait.waitForVisible(emergencyContactPersonMobileNumber1);
		wait.waitForClickable(emergencyContactPersonMobileNumber1);
		emergencyContactPersonMobileNumber1.clear();
		emergencyContactPersonMobileNumber1.sendKeys(data.get("emergencyMobile1"));
		Logs.info("Emergency Mobile1 entered...");

		wait.waitForVisible(emergencyContactPersonRelationship1);
		wait.waitForClickable(emergencyContactPersonRelationship1);
		emergencyContactPersonRelationship1.clear();
		emergencyContactPersonRelationship1.sendKeys(data.get("emergencyRelation1"));
		Logs.info("Emergency Relation1 entered...");

		wait.waitForVisible(emergencyContactPersonName2);
		wait.waitForClickable(emergencyContactPersonName2);
		emergencyContactPersonName2.clear();
		emergencyContactPersonName2.sendKeys(data.get("emergencyName2"));
		Logs.info("Emergency Name2 entered...");

		wait.waitForVisible(emergencyContactPersonMobileNumber2);
		wait.waitForClickable(emergencyContactPersonMobileNumber2);
		emergencyContactPersonMobileNumber2.clear();
		emergencyContactPersonMobileNumber2.sendKeys(data.get("emergencyMobile2"));
		Logs.info("Emergency Mobile2 entered...");

		wait.waitForVisible(emergencyContactPersonRelationship2);
		wait.waitForClickable(emergencyContactPersonRelationship2);
		emergencyContactPersonRelationship2.clear();
		emergencyContactPersonRelationship2.sendKeys(data.get("emergencyRelation2"));
		Logs.info("Emergency Relation2 entered...");

		scrollElementInToView(specialDay);
		if (data.get("raceDaySpecial").equalsIgnoreCase("Yes")) {
			wait.waitForVisible(raceDayIsSpecialYes);
			wait.waitForClickable(raceDayIsSpecialYes);
			raceDayIsSpecialYes.click();
			Logs.info("Race Day Is Special clicked...");
			Logs.info("Going to select the reason...");
			selectTheReason(select_The_Reason);
		} else {
			wait.waitForVisible(raceDayIsSpecialNo);
			wait.waitForClickable(raceDayIsSpecialNo);
			raceDayIsSpecialNo.click();

		}

		selectTransportToUse(data.get("transport"));

		hearAboutUs(data.get("hearAbout"));

		scrollElementInToView(ForVirtualEventYes);
		if (data.get("virtualEvent").equalsIgnoreCase("Yes")) {
			ForVirtualEventYes.click();
			selectVirtualRaceCategory(virtual_Race_Category);
		} else {
			ForVirtualEventNo.click();
		}

		waitThread(2000);
		Logs.info("Clicking on Proceed Button....");
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].click();", proceedBtn);
		Logs.info("Proceed Button clicked....");

		Logs.info("Going for Merchandise Details Page....");
		return new MerchandiseDetailsPage();

	}

	private void selectVirtualRaceCategory(String virtualRaceCategoryToSelect) {
		wait.waitForVisible(selectVirtualRaceCategory);
		wait.waitForClickable(selectVirtualRaceCategory);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].dispatchEvent(new Event('mousedown',{bubbles:true));",
				selectVirtualRaceCategory);
		js.executeScript("arguments[0].dispatchEvent(new Event('mouseup',{bubbles:true));", selectVirtualRaceCategory);
		waitThread(3000);
		List<WebElement> virtualRaceCategoryList = driver
				.findElements(By.xpath("//ng-dropdown-panel[@role='listbox']//div[contains(@class,'ng-option')]"));
		waitThread(3000);
		System.out.println("Virtual race category list size : " + virtualRaceCategoryList);
		waitThread(3000);
		for (WebElement virtualRaceCategory : virtualRaceCategoryList) {
			System.out.println("Virtual race category : " + virtualRaceCategory.getText().toString());
		}
		waitThread(3000);
		DropdownHelper dropdown = new DropdownHelper(driver);
		dropdown.selectFromList(virtualRaceCategoryList, virtualRaceCategoryToSelect);
		Logs.info("Virtual race category selected from dropdown: " + virtualRaceCategoryToSelect);
	}

	private void selectTheReason(String reasonToSelect) {
		Logs.info("In selectTheReason method... ");
		wait.waitForVisible(selectTheReason);
		wait.waitForClickable(selectTheReason);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].dispatchEvent(new Event('mousedown', {bubbles:true}));", selectTheReason);
		js.executeScript("arguments[0].dispatchEvent(new Event('mouseup', {bubbles:true}));", selectTheReason);
		Logs.info("Select The Reason Dropdown opened.....");
		waitThread(3000);
		List<WebElement> reasonsList = driver
				.findElements(By.xpath("//ng-dropdown-panel[@role='listbox']//div[contains(@class,'ng-option')]"));
		waitThread(3000);
		System.out.println("Reason List size: " + reasonsList.size());
		for (WebElement reason : reasonsList) {
			System.out.println("Reason List name: " + reason.getText().toString());
		}
		waitThread(3000);
		DropdownHelper dropdown = new DropdownHelper(driver);
		dropdown.selectFromList(reasonsList, reasonToSelect);
		Logs.info("Reason selected from dropdown: " + reasonToSelect);
	}

	private void hearAboutUs(String hearAboutToSelect) {
		wait.waitForVisible(hearAboutInput);
		wait.waitForClickable(hearAboutInput);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].dispatchEvent(new Event('mousedown', {bubbles:true}));", hearAboutInput);
		js.executeScript("arguments[0].dispatchEvent(new Event('mouseup', {bubbles:true}));", hearAboutInput);
		Logs.info("Hear About Input Dropdown opened...");
		waitThread(5000);
		List<WebElement> hearAboutList = driver
				.findElements(By.xpath("//ng-dropdown-panel[@role='listbox']//div[contains(@class,'ng-option')]"));
		waitThread(5000);
		System.out.println("Hear About List size: " + hearAboutList.size());
		for (WebElement hearAbout : hearAboutList) {
			System.out.println("Hear About Input selected: " + hearAbout.getText().toString());
		}
		waitThread(5000);
		DropdownHelper dropdown = new DropdownHelper(driver);
		dropdown.selectFromList(hearAboutList, hearAboutToSelect);
		Logs.info("Hear about selected from dropdown: " + hearAboutToSelect);
	}

	private void uploadProfileimage(String path) {
		waitThread(5000);
		scrollElementInToView(uploadProfileImage);
		wait.waitForVisible(uploadProfileImage);
		wait.waitForClickable(uploadProfileImage);
		Logs.info("Clicking on upload profile Image for uploading file...... ");
		if (path == null || path.trim().isEmpty()) {
			Logs.info("No profile image provided. Skipping upload.");
			return;
		}

		Logs.info("Uploading profile image: " + path);

		WebElement fileInput = driver.findElement(By.id("profileImage"));

		// wait.waitForVisible(fileInput);
		fileInput.sendKeys(path);

		Logs.info("Profile image uploaded successfully");

		// -----------------------------------------------
		/*
		 * scrollElementInToView(uploadProfileImage);
		 * wait.waitForVisible(uploadProfileImage);
		 * wait.waitForClickable(uploadProfileImage);
		 * Logs.info("Clicking on upload profile Image for uploading file...... "); //
		 * uploadProfileImage.click(); String filePath =
		 * "C:\\Users\\dewen\\Downloads\\Procam testing\\Avatar Images\\pihu.png";
		 * Logs.info("Uloading file: " + path); WebElement fileInput =
		 * DriverFactory.getDriver().findElement(By.xpath("//input[@type='file']"));
		 * //fileInput.sendKeys(path); fileInput.sendKeys(filePath);
		 * Logs.info("File uploaded successfully for profile image: ");
		 */
	}

	private void selectIdProofToUpload(String idProofType) {
		scrollElementInToView(uploadIdProof);
		wait.waitForVisible(uploadIdProof);
		wait.waitForClickable(uploadIdProof);
		Logs.info("Clicking on Id Proof upload button for: " + idProofType);
		// uploadIdProof.click();
		String filePath = "";
		if (idProofType.equalsIgnoreCase("Aadhar Card")) {
			filePath = "C:\\Users\\dewen\\Downloads\\Procam_Testing\\ProcamTest\\docs\\aadhaar.png";
		} else if (idProofType.equalsIgnoreCase("PAN Card")) {
			filePath = "C:\\Users\\dewen\\Downloads\\Procam_Testing\\ProcamTest\\docs\\pan_card.jpg";
		}

		Logs.info("Id Proof Uploading file path: " + filePath);

		WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
		fileInput.sendKeys(filePath);

		Logs.info("Id Proof uploaded successfully for: " + idProofType);

	}

	private void selectIdProofFromList(String idProofToSelect, String idProofNumber) {
		scrollElementInToView(selectIdProofType);
		wait.waitForVisible(selectIdProofType);
		wait.waitForClickable(selectIdProofType);
		Logs.info("Clicking on Id proof dropdown...");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].dispatchEvent(new Event('mousedown', {bubbles:true}));", selectIdProofType);
		js.executeScript("arguments[0].dispatchEvent(new Event('mouseup', {bubbles:true}));", selectIdProofType);
		Logs.info("Id Proof Dropdown opened...");
		waitThread(5000);
		List<WebElement> idProofList = driver
				.findElements(By.xpath("//ng-dropdown-panel[@role='listbox']//div[contains(@class,'ng-option')]"));
		waitThread(5000);
		System.out.println("Id Proof List size: " + idProofList.size());
		for (WebElement idproof : idProofList) {
			System.out.println(idproof.getText().toString());
		}

		DropdownHelper dropdown = new DropdownHelper(driver);
		dropdown.selectFromList(idProofList, idProofToSelect);

		Logs.info("Id Proof selected from dropdown: " + idProofToSelect);
		waitThread(5000);
		if (idProofToSelect.equalsIgnoreCase("Aadhar Card")) {
			wait.waitForVisible(adharCardNumberInput);
			wait.waitForClickable(adharCardNumberInput);
			adharCardNumberInput.sendKeys(idProofNumber);
			Logs.info("Aadhar no entered: " + idProofNumber);

		} else if (idProofToSelect.equalsIgnoreCase("PAN Card")) {
			wait.waitForVisible(panCardNumberInput);
			wait.waitForClickable(panCardNumberInput);
			panCardNumberInput.sendKeys(idProofNumber);
			Logs.info("PAN no entered: " + idProofNumber);
		} else {
			System.out.println("Id proof not selected...");
		}

		if (idProofToSelect.equalsIgnoreCase("Aadhar Card")) {
			selectIdProofToUpload("Aadhar Card");

		} else if (idProofToSelect.equalsIgnoreCase("PAN Card")) {
			selectIdProofToUpload("PAN Card");

		} else {
			System.out.println("Id proof not selected...");
		}
	}

	private void selectTransportToUse(String transportToSelect) {
		// scrollElementInToView(transportToUse);
		waitThread(3000);
		wait.waitForVisible(transportToUse);
		wait.waitForClickable(transportToUse);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].dispatchEvent(new Event('mousedown', {bubbles:true}));", transportToUse);
		js.executeScript("arguments[0].dispatchEvent(new Event('mouseup', {bubbles:true}));", transportToUse);

		Logs.info("Transport To Use Dropdown opened...");

		waitThread(1500);
		List<WebElement> transportList = driver
				.findElements(By.xpath("//ng-dropdown-panel[@role='listbox']//div[contains(@class,'ng-option')]"));
		waitThread(5000);
		System.out.println("Transport To Use List Size: " + transportList.size());
		for (WebElement transport : transportList) {
			System.out.println(transport.getText().toString());
		}
		DropdownHelper dropdown = new DropdownHelper(driver);
		dropdown.selectFromList(transportList, transportToSelect);
		Logs.info("Transport To Use selected from dropdown: " + transportToSelect);

	}

	private void selectEventRaceCategory(String eventRaceCategoryToSelect) {
		scrollElementInToView(raceCategory);
		wait.waitForVisible(raceCategory);
		wait.waitForClickable(raceCategory);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].dispatchEvent(new Event('mousedown', {bubbles:true}));", raceCategory);
		js.executeScript("arguments[0].dispatchEvent(new Event('mouseup', {bubbles:true}));", raceCategory);

		Logs.info("Event Race Category Dropdown opened...");

		waitThread(1500);

		List<WebElement> eventRaceCategoryList = driver
				.findElements(By.xpath("//ng-dropdown-panel[@role='listbox']//div[contains(@class,'ng-option')]"));
		waitThread(5000);
		System.out.println("Event RaceCategory List Size: " + eventRaceCategoryList.size());
		for (WebElement eventRaceCategory : eventRaceCategoryList) {
			System.out.println(eventRaceCategory.getText().toString());
		}
		DropdownHelper dropdown = new DropdownHelper(driver);
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

		Actions actions = new Actions(driver);
		actions.moveToElement(selectRaceCategoryDropDown).click().pause(Duration.ofMillis(200)).click().perform();

		// safeClick(selectRaceCategoryDropDown);
		Logs.info("Rcae Category Dropdown Clicked..");
		waitThread(7000);
		Logs.info("Getting list of all available options..");
		List<WebElement> raceCategoryList = driver.findElements(
				By.xpath("//ng-dropdown-panel[@role='listbox']//div[contains(@class,'ng-dropdown-panel-items')]"));

		Logs.info("Capturing of all available options..");
		System.out.println("RaceCategory List Size: " + raceCategoryList.size());
		if (raceCategoryList.size() > 0) {
			Logs.info("Fetching the all list and printing one by one...");
			for (WebElement raceCategory : raceCategoryList) {
				System.out.println(raceCategory.getText().toString());
				Logs.info("All list printed...");
				DropdownHelper dropdown = new DropdownHelper(driver);
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
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].dispatchEvent(new Event('mousedown', {bubbles:true}));",
				selectRaceCategoryDropDown);
		js.executeScript("arguments[0].dispatchEvent(new Event('mouseup', {bubbles:true}));",
				selectRaceCategoryDropDown);

		Logs.info("Dropdown opened...");

		waitThread(1500); // give ng-select time to render the panel

		List<WebElement> raceCategoryList = driver.findElements(By.xpath("//div[contains(@class,'ng-option')]"));

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

	// -----------------------------class level methods-------------------------//

	public void scrollElementInToTop(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'start'});", element);
	}

	public void scrollElementInToView(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
	}

	public void scrollElementInToEnd(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'end'});", element);
	}

	public void safeClick(WebElement element) {
		// ((JavascriptExecutor) DriverFactory.getDriver())
		// .executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	private void waitThread(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
