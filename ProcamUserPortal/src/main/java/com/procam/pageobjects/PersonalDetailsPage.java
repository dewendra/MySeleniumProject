package com.procam.pageobjects;

import java.time.Duration;
import java.util.List;
import java.util.Map;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.procam.base.BaseClass;
import com.procam.utils.CommonHelper;
import com.procam.utils.DatePickerHelper;
import com.procam.utils.DriverFactory;
import com.procam.utils.DropdownHelper;
import com.procam.utils.Logs;
import com.procam.utils.TypingHelper;
import com.procam.utils.WaitHelper;

public class PersonalDetailsPage extends BaseClass {
	
	private static final Logger log=LogManager.getLogger(PersonalDetailsPage.class);
	private WebDriver driver;
	// WaitHelper wait;
	private CommonHelper helper; 

	WebDriverWait wait;

	@FindBy(xpath = "//div[contains(@class,'fs-3')]//span[contains(@class,'btn-fa-color')]")
	private WebElement upBackBtn;

	@FindBy(xpath = "//h5[contains(normalize-space(), 'Personal Information')]")
	private WebElement personalInformation;

	@FindBy(xpath = "//input[@name='firstName']")
	private WebElement firstName;

	@FindBy(xpath = "//input[@name='middleName']")
	private WebElement middleName;

	@FindBy(xpath = "//input[@name='lastName']")
	private WebElement lastName;

	@FindBy(xpath = "//input[@name='emailId']")
	private WebElement emailId;

	@FindBy(xpath = "//div[contains(@class,'ng-input') and @role='combobox']")
	private WebElement mobileCode;

	@FindBy(xpath = "//input[@name='mobile']")
	private WebElement mobile;

	@FindBy(xpath = "//label[@for='gender']")
	private WebElement genderOption;

	@FindBy(xpath = "//input[@id='genderMale']")
	private WebElement genderMale;

	@FindBy(xpath = "//input[@id='genderFemale']")
	private WebElement genderFemale;

	@FindBy(xpath = "//input[contains(@class,'calendar-input')]")
	private WebElement dateOfBirth;

	@FindBy(xpath = "//div/select[contains(@class,'yearpicker')]")
	private WebElement yearpicker;

	@FindBy(xpath = "//div/select[contains(@class,'monthpicker')]")
	private WebElement monthpicker;

	@FindBy(xpath = "//input[@id='search-text' and @placeholder='Enter pinocde to search']")
	private WebElement pincode;

	@FindBy(xpath = "//input[@name='address']")
	private WebElement address;

	@FindBy(xpath = "(//input[@id='search-text' and @placeholder='Enter text to search'])[1]")
	private WebElement country;

	@FindBy(xpath = "(//input[@id='search-text' and @placeholder='Enter text to search'])[2]")
	private WebElement state;

	@FindBy(xpath = "(//input[@id='search-text' and @placeholder='Enter text to search'])[3]")
	private WebElement city;

	@FindBy(xpath = "//app-select[@id='nationality']//input[@placeholder='Enter text to search']")
	private WebElement nationality;

	@FindBy(xpath = "//input[@id='wantToGiveRCYes']")
	private WebElement runningClubYes;

	@FindBy(xpath = "//input[@id='wantToGiveRCNo']")
	private WebElement runningClubNo;
	
	@FindBy(xpath = "//app-select[@name='runningGroup']//input")
	private WebElement runningGroupInput;

	@FindBy(xpath = "//label[contains(text(),'Occupation')]/following-sibling::ng-select//span[contains(@class,'ng-arrow-wrapper')]")
	private WebElement occupation;

	@FindBy(xpath = "//button[@type='submit' and normalize-space()='Back']")
	private WebElement downBackBtn;

	@FindBy(xpath = "//button[normalize-space()='Proceed' or contains(normalize-space(),'Continue')]")
	private WebElement continueOrproceedBtn;

	@FindBy(xpath = "//button[@type='submit' and contains(normalize-space(),'Continue')]")
	private WebElement continueBtn;
	
	public PersonalDetailsPage() {
		this.driver = DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		helper = new CommonHelper(driver);
	}

	public EventCriteriaPage enterDetails(Map<String, String> data) throws InterruptedException {
		String first_Name = data.get("firstName");
		String middle_Name = data.get("middleName");
		String last_Name = data.get("lastName");
		String mobile_Number = data.get("mobile");
		String user_gender = data.get("gender");
		String date_Of_Birth = data.get("dob");
		String userAddres = data.get("address");
		String nationality = data.get("nationality");

		wait.until(ExpectedConditions.visibilityOf(firstName));
		wait.until(ExpectedConditions.elementToBeClickable(firstName));
		firstName.clear();
		log.info("Entering First Name");
		helper.setInputValue(driver, firstName, first_Name);
		// firstName.sendKeys(data.get("firstName"));
		// TypingHelper.slowTyping(firstName, first_Name, 100);
		log.info("Entered First Name -> " + first_Name);

		wait.until(ExpectedConditions.visibilityOf(middleName));
		middleName.clear();
		// Logs.info("Entering Middle Name");
		helper.setInputValue(driver, middleName, middle_Name);
		// middleName.sendKeys(data.get("middleName"));
		// TypingHelper.slowTyping(middleName, middle_Name, 100);
		// Logs.info("Entered Middle Name -> "+middle_Name);

		wait.until(ExpectedConditions.visibilityOf(lastName));
		lastName.clear();
		log.info("Entering Last Name");
		helper.setInputValue(driver, lastName, last_Name);
		// lastName.sendKeys(data.get("lastName"));
		// TypingHelper.slowTyping(lastName, last_Name, 100);
		log.info("Entered Last Name -> " + last_Name);

		/*
		 * wait.waitForVisible(mobileCode); wait.waitForClickable(mobileCode);
		 * mobileCode.clear(); Logs.info("Entering Mobile Code");
		 * mobileCode.sendKeys(data.get("mobileCode"));
		 */

		helper.scrollElementInToTop(personalInformation);
		wait.until(ExpectedConditions.visibilityOf(mobile));
		wait.until(ExpectedConditions.elementToBeClickable(mobile));
		mobile.clear();
		log.info("Entering Mobile Number");
		helper.setInputValue(driver, mobile, mobile_Number);
		// mobile.sendKeys(mobile_Number);
		// TypingHelper.slowTyping(mobile, mobile_Number, 100);
		log.info("Entered mobile Number -> " + mobile_Number);

		log.info("Selecting gender");
		wait.until(ExpectedConditions.visibilityOf(genderOption));
		if (user_gender.equalsIgnoreCase("Female")) {
			helper.clickWithRetry(genderFemale);
			log.info("Gender selected -> " + user_gender);
		} else {
			helper.clickWithRetry(genderMale);
			log.info("Gender selected -> " + user_gender);
		}

		log.info("Entering Date of Birth.....");
		// scrollElementInToTop(personalInformation);
		// By dobBy=By.xpath("//input[contains(@class,'calendar-input')]");
		// WebElement dobWebElement =
		// wait.until(ExpectedConditions.visibilityOfElementLocated(dobBy));
		wait.until(ExpectedConditions.elementToBeClickable(dateOfBirth)).click();
		DatePickerHelper.selectDate(driver, dateOfBirth, date_Of_Birth);
		log.info("Date of Birth entered -> " + date_Of_Birth);

		selectAddressFromDropdown(data.get("pincode"), data.get("addressDropdown"));

		wait.until(ExpectedConditions.elementToBeClickable(address)).click();
		log.info("Entering Address");
		address.clear();
		address.sendKeys(userAddres);
		log.info("Entered address : ->" + userAddres);

		selectNationality(data.get("searchNationality"), data.get("nationality"));

		if (data.get("runningClubOption").equalsIgnoreCase("Yes")) {
			helper.clickWithRetry(runningClubYes);
			selectRunningGroup(data.get("searchRunningClub"), data.get("runningClub"));
		} else {
			helper.clickWithRetry(runningClubNo);
		}

		selectOccupation(data.get("occupation"));

		log.info("Clicking continue Or proceed Btn");
		helper.clickWithRetry(continueOrproceedBtn);
		log.info("Going for Event Criteria Page....");
		return new EventCriteriaPage();

	}

	private void selectRunningGroup(String searchRunningGroupName, String runningGroupNameToSelect) {
		wait.until(ExpectedConditions.elementToBeClickable(address));
		log.info("Selecting Runnig Group");
		
		runningGroupInput.click();
		
		runningGroupInput.sendKeys(searchRunningGroupName);
		log.info("Waiting for dropdown options to appear...");
		
		By runningGroupdropDown=By.xpath("//div[contains(@class,'position-relative')]//li");
		
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(runningGroupdropDown, 0));
		List<WebElement> runningGroupsName=driver.findElements(runningGroupdropDown);
		System.out.println("Running group size: "+runningGroupsName.size());
		
		for(WebElement runningGroupName:runningGroupsName) {
			System.out.println(runningGroupName.getText());
		}
		DropdownHelper dropdown=new DropdownHelper(driver);
		dropdown.searchFromDropdownList(runningGroupsName, searchRunningGroupName, runningGroupNameToSelect);
		//dropdown.searchFromDropdownList2(runningGroupInput, runningGroupdropDown, runningGroupNameToSelect);
		log.info("Running group name selected from dropdown: " + runningGroupNameToSelect);
	}

	

	public void selectNationality(String searchNationality, String nationalityToSelect)  {

		helper.scrollElementInToView(nationality);
		nationality.clear();
		log.info("Entering Nationality");
		// type partial text
		nationality.sendKeys(searchNationality);

		By dropdownOptions = By.xpath("//div[contains(@class,'position-relative')]//li");

		// wait for dropdown options to load
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(dropdownOptions, 0));

		List<WebElement> nationalities = driver.findElements(dropdownOptions);

		System.out.println("Nationality List Size: " + nationalities.size());

		for (WebElement nationality : nationalities) {
			System.out.println(nationality.getText());
		}
		DropdownHelper dropdown = new DropdownHelper(driver);
		// dropdown.selectFromList(nationalities, nationalityToSelect);
		dropdown.searchFromDropdownList(nationalities, searchNationality, nationalityToSelect);
		log.info("Nationality selected from dropdown: " + nationalityToSelect);

	}
	
	public void selectOccupation(String occupationToSelect) throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(occupation));
		log.info("Selecting Occupation");

		log.info("Waiting for dropdown options to appear...");

	    By occupationDropDown=By.xpath("//label[contains(text(),'Occupation')]/following-sibling::ng-select//span[contains(@class,'ng-arrow-wrapper')]");
	    helper.selectFromNgSelect(occupationDropDown, occupationToSelect);

	    log.info("Occupations selected from dropdown: " + occupationToSelect);
	    

	}

	public void selectAddressFromDropdown(String pinCode, String addressToSelect) {

		log.info("Scroll To  Pin Code");
		log.info("Selecting Address using Pincode");
		helper.scrollElementInToView(pincode);
		log.info("Entering Pin Code");

		pincode.clear();

		pincode.sendKeys(pinCode);
		By dropdownOptions = By.xpath("//div[contains(@class,'position-relative')]//ul");

		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan((By) dropdownOptions, 0));
		List<WebElement> addressOptions = driver
				.findElements(By.xpath("//div[contains(@class,'position-relative')]//ul"));
		System.out.println("Address List Size: " + addressOptions.size());

		for (WebElement address : addressOptions) {
			System.out.println(address.getText().toString());
		}

		DropdownHelper dropdown = new DropdownHelper(driver);
		dropdown.selectFromList(addressOptions, addressToSelect);

		log.info("Address selected from dropdown: " + addressToSelect);
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
