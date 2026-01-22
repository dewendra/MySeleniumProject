package com.procam.pageObjects;

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

import com.procam.base.BaseClass;
import com.procam.utils.CommonHelper;
import com.procam.utils.DatePickerHelper;
import com.procam.utils.DriverFactory;
import com.procam.utils.DropdownHelper;
import com.procam.utils.Logs;
import com.procam.utils.TypingHelper;
import com.procam.utils.WaitHelper;

public class VolunteerDetailsPage extends BaseClass {

	private WebDriver driver;
	//WaitHelper wait;
	private CommonHelper helper=new CommonHelper(driver);

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

	@FindBy(xpath = "//ng-select[@formcontrolname='occupation']")
	private WebElement occupation;

	@FindBy(xpath = "//button[@type='submit' and normalize-space()='Back']")
	private WebElement downBackBtn;

	@FindBy(xpath = "//button[@type='submit' and normalize-space()='Proceed']")
	private WebElement proceedBtn;

	public VolunteerDetailsPage() {
		this.driver=DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}

	public void enterDetails(Map<String, String> data) throws InterruptedException {
		String first_Name=data.get("firstName");
		String middle_Name=data.get("middleName");
		String last_Name=data.get("lastName");
		String mobile_Number=data.get("mobile");
		String user_gender=data.get("gender");
		String date_Of_Birth=data.get("dob");
		
		wait.until(ExpectedConditions.visibilityOf(firstName));
		wait.until(ExpectedConditions.elementToBeClickable(firstName));
		firstName.clear();
		Logs.info("Entering First Name");
		helper.setInputValue(driver, firstName, first_Name);
		//firstName.sendKeys(data.get("firstName"));
		//TypingHelper.slowTyping(firstName, first_Name, 100);
		Logs.info("Entered First Name -> "+first_Name);

		wait.until(ExpectedConditions.visibilityOf(middleName));
		middleName.clear();
		//Logs.info("Entering Middle Name");
		helper.setInputValue(driver, middleName, middle_Name);
		//middleName.sendKeys(data.get("middleName"));
		//TypingHelper.slowTyping(middleName, middle_Name, 100);
		//Logs.info("Entered Middle Name -> "+middle_Name);

		wait.until(ExpectedConditions.visibilityOf(lastName));
		lastName.clear();
		Logs.info("Entering Last Name");
		helper.setInputValue(driver, lastName, last_Name);
		//lastName.sendKeys(data.get("lastName"));
		//TypingHelper.slowTyping(lastName, last_Name, 100);
		Logs.info("Entered Last Name -> "+last_Name);

		/*
		 * wait.waitForVisible(mobileCode); wait.waitForClickable(mobileCode);
		 * mobileCode.clear(); Logs.info("Entering Mobile Code");
		 * mobileCode.sendKeys(data.get("mobileCode"));
		 */

		scrollElementInToTop(personalInformation);
		wait.until(ExpectedConditions.visibilityOf(mobile));
		wait.until(ExpectedConditions.elementToBeClickable(mobile));
		mobile.clear();
		Logs.info("Entering Mobile Number");
		helper.setInputValue(driver, mobile, mobile_Number);
		//mobile.sendKeys(mobile_Number);
		//TypingHelper.slowTyping(mobile, mobile_Number, 100);
		Logs.info("Entered mobile Number -> "+mobile_Number);
		
		Logs.info("Selecting gender");
		wait.until(ExpectedConditions.visibilityOf(genderOption));
		if (user_gender.equalsIgnoreCase("Female")) {
			wait.until(ExpectedConditions.elementToBeClickable(genderFemale)).click();
			Logs.info("Gender selected -> " + user_gender);
		} else {
			wait.until(ExpectedConditions.elementToBeClickable(genderMale)).click();
			Logs.info("Gender selected -> " + user_gender);
		}
		
		Logs.info("Entering Date of Birth.....");
		//scrollElementInToTop(personalInformation);
		//By dobBy=By.xpath("//input[contains(@class,'calendar-input')]");
		//WebElement dobWebElement = wait.until(ExpectedConditions.visibilityOfElementLocated(dobBy));
		wait.until(ExpectedConditions.elementToBeClickable(dateOfBirth)).click();
		DatePickerHelper.selectDate(driver, dateOfBirth, date_Of_Birth);
		Logs.info("Date of Birth entered -> "+date_Of_Birth);
		
		selectAddressFromDropdown(data.get("pincode"), data.get("addressDropdown"));
		
		wait.until(ExpectedConditions.elementToBeClickable(address)).click();
		Logs.info("Entering Address");
		address.sendKeys(data.get("address"));

		selectNationality(data.get("nationality"));

		if (data.get("runningClub").equalsIgnoreCase("Yes")) {
	        runningClubYes.click();
	    } else {
	        runningClubNo.click();
	    }
		
		selectOccupation(data.get("occupation"));

		Logs.info("Clicking proceed btn");
		wait.until(ExpectedConditions.elementToBeClickable(proceedBtn)).click();
		Logs.info("Going for Event Criteria Page....");
		//return new EventCriteriaPage();

	}

	public void selectOccupation(String occupationToSelect) {
		
		Logs.info("Clicking Occupation");
		By occupationBy=By.xpath("//ng-select[@formcontrolname='occupation']");
		wait.until(ExpectedConditions.elementToBeClickable(occupationBy)).click();
		Logs.info("Clicked Occupation");
		
		Logs.info("Entering Occupation");
		helper=new CommonHelper(driver);
		//By occupationBy=By.xpath("//ng-select[@formcontrolname='occupation']");
		helper.selectFromNgSelect(occupationBy, occupationToSelect);
		
		/*
		 * List<WebElement> occupationsList = driver
		 * .findElements(By.xpath("//ng-dropdown-panel//span[@class='ng-option-label']")
		 * ); waitThread(5000); System.out.println("Occupation List Size: " +
		 * occupationsList.size()); for (WebElement occupation : occupationsList) {
		 * System.out.println(occupation.getText().toString()); } DropdownHelper
		 * dropdown = new DropdownHelper(driver);
		 * dropdown.selectFromList(occupationsList, occupationToSelect);
		 */
		Logs.info("Occupations selected from dropdown: " + occupationToSelect);
	}

	public void selectNationality(String nationalityToSelect) {
		By nationalityBy=By.xpath("//app-select[@id='nationality']//input[@placeholder='Enter text to search']");
		scrollElementInToView(nationality);
		wait.until(ExpectedConditions.elementToBeClickable(nationalityBy)).click();
		
		Logs.info("Entering Nationality");
		//nationality.sendKeys(nationalityToSelect);
		System.out.println("Nationality is : "+nationalityToSelect);
		helper=new CommonHelper(driver);
		//By nationalityBy=By.xpath("//app-select[@id='nationality']//input[@placeholder='Enter text to search']");
		helper.selectFromNgSelect(nationalityBy, nationalityToSelect);

		/*
		 * List<WebElement> nationalities = driver
		 * .findElements(By.xpath("//div[contains(@class,'position-relative')]//ul"));
		 * waitThread(5000); System.out.println("Nationality List Size: " +
		 * nationalities.size()); for (WebElement nationality : nationalities) {
		 * System.out.println(nationality.getText().toString()); } DropdownHelper
		 * dropdown = new DropdownHelper(driver); dropdown.selectFromList(nationalities,
		 * nationalityToSelect);
		 */
		Logs.info("Nationality selected from dropdown: " + nationalityToSelect);

	}

	public void selectAddressFromDropdown(String pinCode, String addressToSelect) {
		
		Logs.info("Selecting Address using Pincode");
		
		By pincodeInputBy=By.xpath("//input[@id='search-text' and @placeholder='Enter pinocde to search']");
		
		Logs.info("Scroll To  Pin Code");
		scrollElementInToView(pincode);
		Logs.info("Entering Pin Code");
		wait.until(ExpectedConditions.elementToBeClickable(pincodeInputBy)).click();
		
		pincode.clear();
		helper = new CommonHelper(driver);
		helper.selectFromNgSelect(pincodeInputBy, pinCode);
		helper.selectFromNgSelect(pincodeInputBy, addressToSelect);
		
		
		//pincode.sendKeys(pinCode);
		
		/*
		 * List<WebElement> addressOptions = driver
		 * .findElements(By.xpath("//div[contains(@class,'position-relative')]//ul"));
		 * wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(addressOptionsBy,
		 * 0)); System.out.println("Address List Size: " + addressOptions.size()); for
		 * (WebElement address : addressOptions) {
		 * System.out.println(address.getText().toString()); }
		 * 
		 * DropdownHelper dropdown = new DropdownHelper(driver);
		 * dropdown.selectFromList(addressOptions, addressToSelect);
		 */
		Logs.info("Address selected from dropdown: " + addressToSelect);
	}

	// -----------------------------class level methods-------------------------//
	public void scrollElementInToTop(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'start'});", element);
	}
	
	public void scrollElementInToView(WebElement element) {
		((JavascriptExecutor) driver)
				.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
	}

	private void waitThread(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
