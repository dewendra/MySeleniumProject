package com.procam.pageobjects;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
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
import com.procam.utils.CommonHelper;
import com.procam.utils.DatePickerHelper;
import com.procam.utils.DriverFactory;
import com.procam.utils.DropdownHelper;
import com.procam.utils.Logs;
import com.procam.utils.WaitHelper;

public class EventCriteriaPage extends BaseClass {

	private WebDriver driver;
	Action action;
	WebDriverWait wait;
	String parentWindow;
	CommonHelper helper;

	@FindBy(xpath = "//div[contains(@class,'fs-3')]//span[contains(@class,'btn-fa-color')]")
	private WebElement upBackBtn;

	@FindBy(xpath = "//h5[normalize-space()='Do you want to participate in the on-ground event?']")
	private WebElement onGroundEventPage;

//	@FindBy(css = "div.d-flex a[href='https://tatamumbaimarathon.procam.in']")
//	private WebElement eventPageLink;

	@FindBy(xpath = "//input[@id='flexRadioDefault1']")
	private WebElement participateInONGroundEventYes;

	@FindBy(xpath = "//input[@id='flexRadioDefault2']")
	private WebElement participateInONGroundEventNo;

	@FindBy(xpath = "//h5[normalize-space()='Select your race category :-']")
	private WebElement selectYourRaceCategory;

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

	@FindBy(css = "//app-select[@name='eventName']//input")
	private WebElement eventName;

	@FindBy(css = "ng-select[formcontrolname='raceCategoryId'] .ng-select-container")
	private WebElement raceCategory;

	@FindBy(xpath = "//input[@name='bib']")
	private WebElement bibNumber;

	@FindBy(xpath = "//h5[normalize-space()='Timing Details :-']")
	private WebElement timingDetails;

	@FindBy(xpath = "//input[contains(@class,'calendar-input')]")
	private WebElement eventConductedDate;

	@FindBy(xpath = "//input[@name='finishTime' and @formcontrolname='hours']")
	private WebElement hoursInput;

	@FindBy(xpath = "//input[@name='finishTime' and @formcontrolname='min']")
	private WebElement minutesInput;

	@FindBy(xpath = "//input[@name='finishTime' and @formcontrolname='sec']")
	private WebElement secondsInput;

	@FindBy(xpath = "//h5[normalize-space()='Additional Details :-']")
	private WebElement additionalDetails;

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

	@FindBy(xpath = "//label[contains(normalize-space(),'2nd Emergency contact person')]")
	private WebElement emergencyContactPerson2;

	@FindBy(xpath = "//input[@name='emergencyNameSec']")
	private WebElement emergencyContactPersonName2;

	@FindBy(xpath = "//input[@name='mobileSecond']")
	private WebElement emergencyContactPersonMobileNumber2;

	@FindBy(xpath = "//input[@name='relationShipSecoEmer']")
	private WebElement emergencyContactPersonRelationship2;

	@FindBy(xpath = "//label[contains(normalize-space(),'Are you attempting the Procam Slam this year?')]")
	private WebElement procamSlam;

	@FindBy(xpath = "//label[contains(normalize-space(),'Procam Slam')]/ancestor::div[contains(@class,'d-flex')]/following-sibling::div//label[normalize-space()='Yes']/preceding-sibling::input[@type='radio']")
	private WebElement procamSlamYes;

	@FindBy(xpath = "//label[contains(normalize-space(),'Procam Slam')]/ancestor::div[contains(@class,'d-flex')]/following-sibling::div//label[normalize-space()='No']/preceding-sibling::input[@type='radio']")
	private WebElement procamSlamNo;

	@FindBy(xpath = "//label[contains(text(),'Choose the cycle')]/following-sibling::ng-select//span[contains(@class,'ng-arrow-wrapper')]")
	private WebElement selectProcamCycleDropDown;

	@FindBy(xpath = "//label[contains(normalize-space(),'Are you participating')]/ancestor::div[contains(@class,'d-flex')]/following-sibling::div//label[normalize-space()='Yes']/preceding-sibling::input[@type='radio']")
	private WebElement participatingFirstTimeYes;

	@FindBy(xpath = "//label[contains(normalize-space(),'Are you participating')]/ancestor::div[contains(@class,'d-flex')]/following-sibling::div//label[normalize-space()='No']/preceding-sibling::input[@type='radio']")
	private WebElement participatingFirstTimeNo;

	@FindBy(xpath = "//label[@for='ques']")
	private WebElement specialDay;

	@FindBy(xpath = "//label[normalize-space()='Please select the reason']/following-sibling::ng-select//div[contains(@class,'ng-select-container')]")
	private WebElement selectTheReason;

	@FindBy(xpath = "//label[contains(normalize-space(),'special occasion')]/ancestor::div[contains(@class,'d-flex')]/following-sibling::div//label[normalize-space()='Yes']/preceding-sibling::input[@type='radio']")
	private WebElement raceDayIsSpecialYes;

	@FindBy(xpath = "//label[contains(normalize-space(),'special occasion')]/ancestor::div[contains(@class,'d-flex')]/following-sibling::div//label[normalize-space()='No']/preceding-sibling::input[@type='radio']")
	private WebElement raceDayIsSpecialNo;

	@FindBy(xpath = "//label[contains(text(),'T-Shirt Size')]/ancestor::div/following-sibling::ng-select//span[contains(@class,'ng-arrow-wrapper')]")
	private WebElement selectTshirtDropDown;

	@FindBy(xpath = "//label[contains(text(),'mode of transport')]/ancestor::div/following-sibling::ng-select//span[contains(@class,'ng-arrow-wrapper')]")
	private WebElement transportToUse;

	@FindBy(xpath = "//ng-select[@formcontrolname='hearabout']//span[contains(@class,'ng-arrow-wrapper')]")
	private WebElement hearAboutInput;

	@FindBy(xpath = "//label[contains(normalize-space(),'hear about our event')]")
	private WebElement hearAboutOurEvent;
	@FindBy(xpath = "//h5[contains(normalize-space(), 'participate in virtual event')]")
	private WebElement participateInVirtualEvent;

	@FindBy(css = "div.d-flex a[href*='size_chart']")
	private WebElement sizeChartOptions;

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
		this.driver = DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		helper = new CommonHelper(driver);
		helper.waitForPageToLoad();
		// helper.waitForAngularLoad();
	}

	public void eventLinkPage() {
		Logs.info("Reached on Event criteria Page...");
		Logs.info("getting the parent window handle..");
		parentWindow = driver.getWindowHandle();
		System.out.println("Parent window id is ->" + parentWindow);

		Logs.info("Finding the event link page....");
		WebElement eventPageLink = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("div.d-flex a[href*='tatamumbaimarathon']")));
		helper.scrollIntoViewCenter(eventPageLink);

		try {
			Logs.info("Event page link found and going to Click eventPageLink");
			wait.until(ExpectedConditions.elementToBeClickable(eventPageLink));
			helper.clickWithRetry(eventPageLink);
			//eventPageLink.click();
			Logs.info("Clicked on Event Page link");
		} catch (ElementClickInterceptedException e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", eventPageLink);
		}

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		for (String window : driver.getWindowHandles()) {
			if (!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}
		verifyEventPageLinkAndReturn();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h5[contains(text(),'on-ground event')]")));
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

		String select_The_Reason = data.get("selectTheReason");
		String virtual_Race_Category = data.get("virtualRaceCategory");

		wait.until(ExpectedConditions.visibilityOf(onGroundEventPage));

		helper.scrollElementInToTop(onGroundEventPage);

		Logs.info("Ground Event radio button clicking...");
		if (data.get("participateOnGround").equalsIgnoreCase("Yes")) {
			helper.clickWithRetry(participateInONGroundEventYes);
			Logs.info("Ground Event Yes radio button clicked...");

		} else {
			helper.clickWithRetry(participateInONGroundEventNo);
			Logs.info("Ground Event No radio button clicked...");
		}

		wait.until(ExpectedConditions.visibilityOf(selectYourRaceCategory));
		Logs.info("Scrolling the page.....");
		helper.scrollElementInToTop(selectYourRaceCategory);
		Logs.info("Going to select the race category");
		selectRaceCategory(data.get("raceCategory"));
		Logs.info("Rce category selected");

		Logs.info("Selecting criteria from given options...");
		String criteria = data.get("criteriaType");
		if (criteria.equalsIgnoreCase("TimedRunner")) {
			helper.clickWithRetry(timedRunner);
			Logs.info("Timed Runner radio option clicked...");
		} else if (criteria.equalsIgnoreCase("WomenWithTiming")) {
			helper.clickWithRetry(WomenCriteriaWithTimingCertificate);
			Logs.info("Women WithTiming radio option clicked...");
		} else if (criteria.equalsIgnoreCase("WomenWithoutTiming")) {
			helper.clickWithRetry(WomenCriteriaWithoutTimingCertificate);
			Logs.info("Women WithOut Timing radio option clicked...");
		} else if (criteria.equalsIgnoreCase(" GeneralCriteria ")) {
			helper.clickWithRetry(generalCriteria);
			Logs.info("General Criteria radio option clicked...");
		} else {
			System.err.println("Criteria not selected....");
		}

		helper.scrollElementInToTop(timingDetails);
		if (criteria.equalsIgnoreCase("TimedRunner") || criteria.equalsIgnoreCase("WomenWithTiming")) {
			Logs.info("Entering Timing Certificate Link...");
			wait.until(ExpectedConditions.elementToBeClickable(timingCertificateLink));
			timingCertificateLink.sendKeys(data.get("timingCertLink"));
			Logs.info("Timing Certificate Link entered...");
		}

		Logs.info("Entering Event Name...");
		// Thread.sleep(5000);
		selectEventName(data.get("searchEventName"), data.get("eventName"));

		selectEventRaceCategory(data.get("eventRaceCategory"));

		wait.until(ExpectedConditions.elementToBeClickable(bibNumber));
		Logs.info("Entering Bib number...");
		bibNumber.sendKeys(data.get("bibNumber"));
		Logs.info("Bib number entered...");

		helper.scrollElementInToView(eventConductedDate);
		wait.until(ExpectedConditions.elementToBeClickable(eventConductedDate)).click();
		Logs.info("Entering Event Conducted Date...");
		DatePickerHelper.selectDate(driver, eventConductedDate, data.get("eventDate"));
		Logs.info("Event Conducted Date entered...");

		wait.until(ExpectedConditions.elementToBeClickable(hoursInput));
		Logs.info("Entering Hours...");
		hoursInput.sendKeys(data.get("hours"));
		Logs.info("Hours entered...");

		wait.until(ExpectedConditions.elementToBeClickable(minutesInput));
		Logs.info("Entering Minutes...");
		minutesInput.sendKeys(data.get("minutes"));
		Logs.info("Minutes entered...");

		wait.until(ExpectedConditions.elementToBeClickable(secondsInput));
		Logs.info("Entering Seconds...");
		secondsInput.sendKeys(data.get("seconds"));
		Logs.info("Seconds entered...");

		Logs.info("Scrolling to Additional details ....");
		helper.scrollElementInToTop(additionalDetails);

		selectIdProofFromList(data.get("idProofType"), data.get("idProofNumber"));

		uploadProfileimage(data.get("profileImagePath"));

		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(emergencyContactPersonName1));
		Logs.info("Scrolling to Emergency Name1 ....");
		helper.scrollElementInToTop(emergencyContactPersonName1);
		emergencyContactPersonName1.clear();
		emergencyContactPersonName1.sendKeys(data.get("emergencyName1"));
		Logs.info("Emergency Name1 entered...");

		wait.until(ExpectedConditions.elementToBeClickable(emergencyContactPersonMobileNumber1));
		emergencyContactPersonMobileNumber1.clear();
		emergencyContactPersonMobileNumber1.sendKeys(data.get("emergencyMobile1"));
		Logs.info("Emergency Mobile1 entered...");

		wait.until(ExpectedConditions.elementToBeClickable(emergencyContactPersonRelationship1));
		emergencyContactPersonRelationship1.clear();
		emergencyContactPersonRelationship1.sendKeys(data.get("emergencyRelation1"));
		Logs.info("Emergency Relation1 entered...");

		//Thread.sleep(2000);
		//Logs.info("Scrolling to Emergency Name2 ....");
		//helper.scrollElementInToTop(emergencyContactPerson2);
		wait.until(ExpectedConditions.elementToBeClickable(emergencyContactPersonName2));
		emergencyContactPersonName2.clear();
		emergencyContactPersonName2.sendKeys(data.get("emergencyName2"));
		Logs.info("Emergency Name2 entered...");

		wait.until(ExpectedConditions.elementToBeClickable(emergencyContactPersonMobileNumber2));
		emergencyContactPersonMobileNumber2.clear();
		emergencyContactPersonMobileNumber2.sendKeys(data.get("emergencyMobile2"));
		Logs.info("Emergency Mobile2 entered...");

		wait.until(ExpectedConditions.visibilityOf(emergencyContactPersonRelationship2));
		Logs.info("Scrolling to Emergency Relation2 ....");
		//Thread.sleep(2000);
		helper.scrollElementInToTop(emergencyContactPersonRelationship2);
		wait.until(ExpectedConditions.elementToBeClickable(emergencyContactPersonRelationship2));
		emergencyContactPersonRelationship2.clear();
		emergencyContactPersonRelationship2.sendKeys(data.get("emergencyRelation2"));
		Logs.info("Emergency Relation2 entered...");

		// ----------------- Procam Slam Option--------------------//
		// wait.until(ExpectedConditions.visibilityOf(procamSlam));
		// scrollElementInToTop(procamSlam);

		// ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",
		// procamSlam);
		// Thread.sleep(2000);
		// scrollElementInToTop(emergencyContactPerson2);
		if (data.get("procamSlamOptions").equalsIgnoreCase("Yes")) {
			helper.clickWithRetry(procamSlamYes);
			Logs.info("Procam Slam Yes Option clicked...");
			Logs.info("Going to select the cycle...");
			selectTheSlamCycle(data.get("slamCycle"));
		} else {
			helper.clickWithRetry(procamSlamNo);
			Logs.info("Procam Slam No Option clicked...");
		}

		// ----------------- Participating First Time Option--------------------//

		if (data.get("participatingFirstTime").equalsIgnoreCase("Yes")) {
			helper.clickWithRetry(participatingFirstTimeYes);
			Logs.info("Participating First Time Yes Option clicked...");
		} else {
			helper.clickWithRetry(participatingFirstTimeNo);
			Logs.info("Participating First Time No Option clicked...");
		}

		// ------------------- Race day Special Option------------------//

		if (data.get("raceDaySpecial").equalsIgnoreCase("Yes")) {
			helper.clickWithRetry(raceDayIsSpecialYes);
			Logs.info("Race Day Special Yes option clicked...");
			Logs.info("Going to select the reason...");
			selectTheReason(select_The_Reason);
		} else {
			helper.clickWithRetry(raceDayIsSpecialNo);
			Logs.info("Race Day Special No option clicked...");
		}

		selectTransportToUse(data.get("transport"));

		selectTheTshirt(data.get("tshirtSize"));

		wait.until(ExpectedConditions.visibilityOf(hearAboutOurEvent));
		Logs.info("Scrolling to Hear About ....");
		helper.scrollElementInToView(hearAboutOurEvent);

		hearAboutUs(data.get("hearAbout"));

		// -------------------- Virtual Event Option--------------------//

		if (data.get("virtualEvent").equalsIgnoreCase("Yes")) {
			helper.clickWithRetry(ForVirtualEventYes);
			selectVirtualRaceCategory(virtual_Race_Category);
		} else {
			helper.clickWithRetry(ForVirtualEventNo);
		}

		Logs.info("Clicking on Proceed Button....");
		helper.clickWithRetry(proceedBtn);
		Logs.info("Proceed Button clicked....");

		Logs.info("Going for Merchandise Details Page....");
		return new MerchandiseDetailsPage();

	}

	// ----------- Selecting t-shirt size----------------//
	private void selectTheTshirt(String tshirtToSelect) throws InterruptedException {
		helper = new CommonHelper(driver);
		wait.until(ExpectedConditions.elementToBeClickable(selectTshirtDropDown));

		Logs.info("Selecting tshirt size from dropdown: ");

		By tshirtSizeDropdown = By.xpath(
				"//label[contains(text(),'T-Shirt Size')]/ancestor::div/following-sibling::ng-select//span[contains(@class,'ng-arrow-wrapper')]");
		helper.selectFromNgSelect(tshirtSizeDropdown, tshirtToSelect);

		Logs.info("T-shirt size selected: " + tshirtToSelect);

	}

	// ----------- Procam Slam Cycle----------------//
	private void selectTheSlamCycle(String slamCycleToSelect) throws InterruptedException {
		Logs.info("In selectTheSlamCycle method... ");
		helper = new CommonHelper(driver);
		wait.until(ExpectedConditions.elementToBeClickable(selectProcamCycleDropDown));

		Logs.info("Selecting procam slam cycle from dropdown: ");

		By slamCycleDropdown = By.xpath(
				"//label[contains(text(),'Choose the cycle')]/following-sibling::ng-select//span[contains(@class,'ng-arrow-wrapper')]");
		helper.selectFromNgSelect(slamCycleDropdown, slamCycleToSelect);

		Logs.info("Procam slam cycle selected: " + slamCycleToSelect);

	}

	private void selectVirtualRaceCategory(String virtualRaceCategoryToSelect) {

		wait.until(ExpectedConditions.elementToBeClickable(selectVirtualRaceCategory));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].dispatchEvent(new Event('mousedown',{bubbles:true));",
				selectVirtualRaceCategory);
		js.executeScript("arguments[0].dispatchEvent(new Event('mouseup',{bubbles:true));", selectVirtualRaceCategory);
		;
		List<WebElement> virtualRaceCategoryList = driver
				.findElements(By.xpath("//ng-dropdown-panel[@role='listbox']//div[contains(@class,'ng-option')]"));

		System.out.println("Virtual race category list size : " + virtualRaceCategoryList);

		for (WebElement virtualRaceCategory : virtualRaceCategoryList) {
			System.out.println("Virtual race category : " + virtualRaceCategory.getText().toString());
		}

		DropdownHelper dropdown = new DropdownHelper(driver);
		dropdown.selectFromList(virtualRaceCategoryList, virtualRaceCategoryToSelect);
		Logs.info("Virtual race category selected from dropdown: " + virtualRaceCategoryToSelect);
	}

	private void selectTheReason(String reasonToSelect) {
		Logs.info("In selectTheReason method... ");
		wait.until(ExpectedConditions.elementToBeClickable(selectTheReason));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].dispatchEvent(new Event('mousedown', {bubbles:true}));", selectTheReason);
		js.executeScript("arguments[0].dispatchEvent(new Event('mouseup', {bubbles:true}));", selectTheReason);
		Logs.info("Select The Reason Dropdown opened.....");

		List<WebElement> reasonsList = driver
				.findElements(By.xpath("//ng-dropdown-panel[@role='listbox']//div[contains(@class,'ng-option')]"));

		System.out.println("Reason List size: " + reasonsList.size());
		for (WebElement reason : reasonsList) {
			System.out.println("Reason List name: " + reason.getText().toString());
		}
		DropdownHelper dropdown = new DropdownHelper(driver);
		dropdown.selectFromList(reasonsList, reasonToSelect);
		Logs.info("Reason selected from dropdown: " + reasonToSelect);
	}

	private void hearAboutUs(String hearAboutToSelect) {
		wait.until(ExpectedConditions.elementToBeClickable(hearAboutInput));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].dispatchEvent(new Event('mousedown', {bubbles:true}));", hearAboutInput);
		js.executeScript("arguments[0].dispatchEvent(new Event('mouseup', {bubbles:true}));", hearAboutInput);
		Logs.info("Hear About Input Dropdown opened...");
		List<WebElement> hearAboutList = driver
				.findElements(By.xpath("//ng-dropdown-panel[@role='listbox']//div[contains(@class,'ng-option')]"));
		System.out.println("Hear About List size: " + hearAboutList.size());
		for (WebElement hearAbout : hearAboutList) {
			System.out.println(hearAbout.getText().toString());
		}
		DropdownHelper dropdown = new DropdownHelper(driver);
		dropdown.selectFromList(hearAboutList, hearAboutToSelect);
		Logs.info("Hear about selected from dropdown: " + hearAboutToSelect);
	}

	private void uploadProfileimage(String filePath) {
		wait.until(ExpectedConditions.elementToBeClickable(uploadProfileImage));
		helper.scrollElementInToView(uploadProfileImage);

		Logs.info("Clicking on upload profile Image for uploading file...... ");

		if (filePath == null || filePath.trim().isEmpty()) {
			Logs.info("No profile image provided. Skipping upload.");
			return;
		}

		Logs.info("Uploading profile image(path): " + filePath);

		WebElement fileInput = driver.findElement(By.cssSelector("input#profileImage"));

		// wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input#profileImage")));
		// wait.until(ExpectedConditions.visibilityOf(fileInput));
		// Make visible if hidden
		((JavascriptExecutor) driver).executeScript("arguments[0].style.display='block';", fileInput);

		// Clear existing uploaded file if present
		((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", fileInput);

		// Upload new file
		fileInput.sendKeys(filePath);
		System.out.println(fileInput.getAttribute("value"));

		// fileInput.clear();
		Logs.info("file input path captured: " + fileInput.getTagName());
		Logs.info("file input path captured: " + fileInput.getText());
		// fileInput.sendKeys(fielPath);

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
		wait.until(ExpectedConditions.elementToBeClickable(uploadIdProof));
		helper.scrollElementInToView(uploadIdProof);
		Logs.info("Clicking on Id Proof upload button for: " + idProofType);
		// uploadIdProof.click();
		String filePath = "";
		if (idProofType.equalsIgnoreCase("Aadhar Card")) {
			filePath = "C:\\Users\\dewen\\Downloads\\Procam_Testing\\ProcamTest\\docs\\aadhaar.png";
		} else if (idProofType.equalsIgnoreCase("PAN Card")) {
			filePath = "C:\\Users\\dewen\\Downloads\\Procam_Testing\\ProcamTest\\docs\\pan_card.jpg";
		}

		Logs.info("Id Proof Uploading file path: " + filePath);

		WebElement fileInput = driver.findElement(By.xpath(" //label[@for='idproof']/following-sibling::input[@type='file']"));
		fileInput.sendKeys(filePath);

		Logs.info("Id Proof uploaded successfully for: " + idProofType);

	}

	private void selectIdProofFromList(String idProofToSelect, String idProofNumber) {
		wait.until(ExpectedConditions.elementToBeClickable(selectIdProofType));
		helper.scrollElementInToView(selectIdProofType);
		Logs.info("Clicking on Id proof dropdown...");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].dispatchEvent(new Event('mousedown', {bubbles:true}));", selectIdProofType);
		js.executeScript("arguments[0].dispatchEvent(new Event('mouseup', {bubbles:true}));", selectIdProofType);
		Logs.info("Id Proof Dropdown opened...");
		List<WebElement> idProofList = driver
				.findElements(By.xpath("//ng-dropdown-panel[@role='listbox']//div[contains(@class,'ng-option')]"));
		System.out.println("Id Proof List size: " + idProofList.size());
		for (WebElement idproof : idProofList) {
			System.out.println(idproof.getText().toString());
		}

		DropdownHelper dropdown = new DropdownHelper(driver);
		dropdown.selectFromList(idProofList, idProofToSelect);

		Logs.info("Id Proof selected from dropdown: " + idProofToSelect);
		if (idProofToSelect.equalsIgnoreCase("Aadhar Card")) {
			wait.until(ExpectedConditions.elementToBeClickable(adharCardNumberInput));
			adharCardNumberInput.sendKeys(idProofNumber);
			Logs.info("Aadhar no entered: " + idProofNumber);

		} else if (idProofToSelect.equalsIgnoreCase("PAN Card")) {
			wait.until(ExpectedConditions.elementToBeClickable(panCardNumberInput));
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
		wait.until(ExpectedConditions.elementToBeClickable(transportToUse));
		// scrollElementInToView(transportToUse);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].dispatchEvent(new Event('mousedown', {bubbles:true}));", transportToUse);
		js.executeScript("arguments[0].dispatchEvent(new Event('mouseup', {bubbles:true}));", transportToUse);

		Logs.info("Transport To Use Dropdown opened...");

		List<WebElement> transportList = driver
				.findElements(By.xpath("//ng-dropdown-panel[@role='listbox']//div[contains(@class,'ng-option')]"));
		System.out.println("Transport To Use List Size: " + transportList.size());
		for (WebElement transport : transportList) {
			System.out.println(transport.getText().toString());
		}
		DropdownHelper dropdown = new DropdownHelper(driver);
		dropdown.selectFromList(transportList, transportToSelect);
		Logs.info("Transport To Use selected from dropdown: " + transportToSelect);

	}

	private void selectEventRaceCategory(String eventRaceCategoryToSelect) {
		wait.until(ExpectedConditions.elementToBeClickable(raceCategory));
		helper.scrollElementInToView(raceCategory);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].dispatchEvent(new Event('mousedown', {bubbles:true}));", raceCategory);
		js.executeScript("arguments[0].dispatchEvent(new Event('mouseup', {bubbles:true}));", raceCategory);

		Logs.info("Event Race Category Dropdown opened...");

		List<WebElement> eventRaceCategoryList = driver
				.findElements(By.xpath("//ng-dropdown-panel[@role='listbox']//div[contains(@class,'ng-option')]"));
		System.out.println("Event RaceCategory List Size: " + eventRaceCategoryList.size());
		for (WebElement eventRaceCategory : eventRaceCategoryList) {
			System.out.println(eventRaceCategory.getText().toString());
		}
		DropdownHelper dropdown = new DropdownHelper(driver);
		dropdown.selectFromList(eventRaceCategoryList, eventRaceCategoryToSelect);
		Logs.info("Event Race Category selected from dropdown: " + eventRaceCategoryToSelect);

	}

	private void selectRaceCategory1(String receCategoryToSelect) {

		wait.until(ExpectedConditions.elementToBeClickable(selectRaceCategoryDropDown));
		System.out.println("Dropdown displayed: " + selectRaceCategoryDropDown.isDisplayed());
		System.out.println("Dropdown enabled: " + selectRaceCategoryDropDown.isEnabled());
		Logs.info("Rcae Category Dropdown Clicking..");

		Actions actions = new Actions(driver);
		actions.moveToElement(selectRaceCategoryDropDown).click().pause(Duration.ofMillis(200)).click().perform();

		// safeClick(selectRaceCategoryDropDown);
		Logs.info("Rcae Category Dropdown Clicked..");
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

	private void selectRaceCategory(String receCategoryToSelect) throws InterruptedException {
		// scrollElementInToView(selectRaceCategoryDropDown);
		helper = new CommonHelper(driver);
		wait.until(ExpectedConditions.elementToBeClickable(selectRaceCategoryDropDown));

		Logs.info("Selecting race category: ");

		By receCategoryDropdown = By
				.xpath("//ng-select[@bindvalue='name']//div[contains(@class,'ng-select-container')]");
		helper.selectFromNgSelect(receCategoryDropdown, receCategoryToSelect);

		Logs.info("Race Category selected: " + receCategoryToSelect);
	}

	private void selectEventName(String searchEventName, String eventNameToSelect) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(eventName));
		By eventNameDropdown = By.xpath("//app-select[@name='eventName']//input");

		// helper.selectFromNgSelect(eventNameDropdown, eventNameToSelect);
		// Thread.sleep(5000);
		helper.searchAndSelectFromNgSelect(eventNameDropdown, searchEventName, eventNameToSelect);
		Logs.info("Event name Selected: " + eventNameToSelect);
	}

	// -----------------------------class level methods-------------------------//

	

	private void waitThread(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
