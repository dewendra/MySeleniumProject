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
import com.procam.utils.DatePickerHelper;
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

	public MerchandiseDetailsPage enterEventDetails() throws InterruptedException {
		waitThread(5000);
		scrollElementInToTop(onGroundEventPage);
		wait.waitForVisible(participateInONGroundEventYes);
		wait.waitForClickable(participateInONGroundEventYes);
		Logs.info("Ground Event radio button clicking...");
		participateInONGroundEventYes.click();
		Logs.info("Ground Event radio button clicked...");
		
		selectRaceCategory1("Open 10K (10 km)");

		wait.waitForVisible(WomenCriteriaWithTimingCertificate);
		wait.waitForClickable(WomenCriteriaWithTimingCertificate);
		Logs.info("Timed Runner radio button clicking...");
		WomenCriteriaWithTimingCertificate.click();
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

		selectEventRaceCategory("10 Km");

		wait.waitForVisible(bibNumber);
		wait.waitForClickable(bibNumber);
		Logs.info("Entering Bib number...");
		bibNumber.sendKeys("12005");
		Logs.info("Bib number entered...");

		wait.waitForVisible(eventConductedDate);
		wait.waitForClickable(eventConductedDate);
		Logs.info("Entering Event Conducted Date...");
		//eventConductedDate.sendKeys("19-10-2025");
		DatePickerHelper.selectDate(DriverFactory.getDriver(), eventConductedDate, "19-10-2025");
		Logs.info("Event Conducted Date entered...");

		wait.waitForVisible(hoursInput);
		wait.waitForClickable(hoursInput);
		Logs.info("Entering Hours...");
		hoursInput.sendKeys("01");
		Logs.info("Hours entered...");

		wait.waitForVisible(minutesInput);
		wait.waitForClickable(minutesInput);
		Logs.info("Entering Minutes...");
		minutesInput.sendKeys("24");
		Logs.info("Minutes entered...");

		wait.waitForVisible(secondsInput);
		wait.waitForClickable(secondsInput);
		Logs.info("Entering Seconds...");
		secondsInput.sendKeys("38");
		Logs.info("Seconds entered...");

		selectIdProofFromList("PAN Card");
		uploadProfileimage();
		
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

		selectTransportToUse("Car");

		wait.waitForVisible(raceDayIsSpecialNo);
		wait.waitForClickable(raceDayIsSpecialNo);
		raceDayIsSpecialNo.click();

		hearAboutUs("Online");

		wait.waitForVisible(ForVirtualEventNo);
		wait.waitForClickable(ForVirtualEventNo);
		ForVirtualEventNo.click();
		
		waitThread(2000);
		JavascriptExecutor javascriptExecutor=(JavascriptExecutor)DriverFactory.getDriver();
		javascriptExecutor.executeScript("arguments[0].click();", proceedBtn);
		//wait.waitForVisible(proceedBtn);
		//wait.waitForClickable(proceedBtn);
		//proceedBtn.isEnabled();
		//proceedBtn.click();
		return new MerchandiseDetailsPage();

	}

	private void hearAboutUs(String hearAboutToSelect) {
		wait.waitForVisible(hearAboutInput);
		wait.waitForClickable(hearAboutInput);
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		js.executeScript("arguments[0].dispatchEvent(new Event('mousedown', {bubbles:true}));", hearAboutInput);
		js.executeScript("arguments[0].dispatchEvent(new Event('mouseup', {bubbles:true}));", hearAboutInput);
		Logs.info("Id Proof Dropdown opened...");
		waitThread(5000);
		List<WebElement> hearAboutList = DriverFactory.getDriver()
				.findElements(By.xpath("//ng-dropdown-panel[@role='listbox']//div[contains(@class,'ng-option')]"));
		waitThread(5000);
		System.out.println("Hear About List size: " + hearAboutList.size());
		for (WebElement hearAbout : hearAboutList) {
			System.out.println("" + hearAbout.getText().toString());
		}
		waitThread(5000);
		DropdownHelper dropdown = new DropdownHelper(DriverFactory.getDriver());
		dropdown.selectFromList(hearAboutList, hearAboutToSelect);
		Logs.info("Hear about selected from dropdown: " + hearAboutToSelect);

	}

	private void uploadProfileimage() {
		scrollElementInToView(uploadProfileImage);
		wait.waitForVisible(uploadProfileImage);
		wait.waitForClickable(uploadProfileImage);
		Logs.info("Clicking on upload profile Image for: ");
		//uploadProfileImage.click();
		String filePath = "C:\\Users\\dewen\\Downloads\\Procam testing\\Avatar Images\\pihu.png";
		Logs.info("Uloading file: " + filePath);
		WebElement fileInput = DriverFactory.getDriver().findElement(By.xpath("//input[@type='file']"));
		fileInput.sendKeys(filePath);
		Logs.info("File uploaded successfully for profile image: ");
	}

	private void selectIdProofToUpload(String idProofType) {
		scrollElementInToView(uploadIdProof);
		wait.waitForVisible(uploadIdProof);
		wait.waitForClickable(uploadIdProof);
		Logs.info("Clicking on upload button for: " + idProofType);
		//uploadIdProof.click();
		String filePath = "";
		if (idProofType.equalsIgnoreCase("Aadhar Card")) {
			filePath = "C:\\Users\\dewen\\Downloads\\Procam testing\\ProcamTest\\docs\\aadhaar.png";
		} else if (idProofType.equalsIgnoreCase("PAN Card")) {
			filePath = "C:\\Users\\dewen\\Downloads\\Procam testing\\ProcamTest\\docs\\pan_card.jpg";
		}

		Logs.info("Uploading file: " + filePath);

		WebElement fileInput = DriverFactory.getDriver().findElement(By.xpath("//input[@type='file']"));
		fileInput.sendKeys(filePath);

		Logs.info("File uploaded successfully for: " + idProofType);

	}

	private void selectIdProofFromList(String idProofToSelect) {
		scrollElementInToView(selectIdProofType);
		wait.waitForVisible(selectIdProofType);
		wait.waitForClickable(selectIdProofType);
		Logs.info("Clicking on Id proof dropdown...");
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		js.executeScript("arguments[0].dispatchEvent(new Event('mousedown', {bubbles:true}));", selectIdProofType);
		js.executeScript("arguments[0].dispatchEvent(new Event('mouseup', {bubbles:true}));", selectIdProofType);
		Logs.info("Id Proof Dropdown opened...");
		waitThread(5000);
		List<WebElement> idProofList = DriverFactory.getDriver()
				.findElements(By.xpath("//ng-dropdown-panel[@role='listbox']//div[contains(@class,'ng-option')]"));
		waitThread(5000);
		System.out.println("Id Proof List size: " + idProofList.size());
		for (WebElement idproof : idProofList) {
			System.out.println(idproof.getText().toString());
		}

		DropdownHelper dropdown = new DropdownHelper(DriverFactory.getDriver());
		dropdown.selectFromList(idProofList, idProofToSelect);

		Logs.info("Id Proof selected from dropdown: " + idProofToSelect);
		waitThread(5000);
		if (idProofToSelect.equalsIgnoreCase("Aadhar Card")) {
			wait.waitForVisible(adharCardNumberInput);
			wait.waitForClickable(adharCardNumberInput);
			adharCardNumberInput.sendKeys("8888 1111 5555");

		} else if (idProofToSelect.equalsIgnoreCase("PAN Card")) {
			wait.waitForVisible(panCardNumberInput);
			wait.waitForClickable(panCardNumberInput);
			panCardNumberInput.sendKeys("PIHUF1234F");
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
		scrollElementInToView(transportToUse);
		wait.waitForVisible(transportToUse);
		wait.waitForClickable(transportToUse);
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		js.executeScript("arguments[0].dispatchEvent(new Event('mousedown', {bubbles:true}));", transportToUse);
		js.executeScript("arguments[0].dispatchEvent(new Event('mouseup', {bubbles:true}));", transportToUse);

		Logs.info("Dropdown opened...");

		waitThread(1500);
		List<WebElement> transportList = DriverFactory.getDriver()
				.findElements(By.xpath("//ng-dropdown-panel[@role='listbox']//div[contains(@class,'ng-option')]"));
		waitThread(5000);
		System.out.println("Transport List Size: " + transportList.size());
		for (WebElement transport : transportList) {
			System.out.println(transport.getText().toString());
		}
		DropdownHelper dropdown = new DropdownHelper(DriverFactory.getDriver());
		dropdown.selectFromList(transportList, transportToSelect);
		Logs.info("Transport selected from dropdown: " + transportToSelect);

	}

	private void selectAddressFromList(String addressToSelect) {
		// TODO Auto-generated method stub

	}

	private void selectEventRaceCategory(String eventRaceCategoryToSelect) {
		scrollElementInToView(raceCategory);
		wait.waitForVisible(raceCategory);
		wait.waitForClickable(raceCategory);
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		js.executeScript("arguments[0].dispatchEvent(new Event('mousedown', {bubbles:true}));", raceCategory);
		js.executeScript("arguments[0].dispatchEvent(new Event('mouseup', {bubbles:true}));", raceCategory);

		Logs.info("Dropdown opened...");

		waitThread(1500);

		List<WebElement> eventRaceCategoryList = DriverFactory.getDriver()
				.findElements(By.xpath("//ng-dropdown-panel[@role='listbox']//div[contains(@class,'ng-option')]"));
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
