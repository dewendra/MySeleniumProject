package com.procam.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.procam.base.BaseClass;
import com.procam.utils.DriverFactory;
import com.procam.utils.DropdownHelper;
import com.procam.utils.Logs;
import com.procam.utils.WaitHelper;

public class PersonalDetailsPage extends BaseClass {

	WaitHelper wait;

	@FindBy(xpath = "//div[contains(@class,'fs-3')]//span[contains(@class,'btn-fa-color')]")
	private WebElement upBackBtn;

	@FindBy(xpath = "//input[@name='firstName']")
	private WebElement firstName;

	@FindBy(xpath = "//input[@name='middleName']")
	private WebElement middleName;

	@FindBy(xpath = "//input[@name='lastName']")
	private WebElement lastName;

	@FindBy(xpath = "//input[@name='emailId']")
	private WebElement emailId;

	@FindBy(xpath = "//div[@role='combobox']")
	private WebElement mobileCode;

	@FindBy(xpath = "//input[@name='mobile']")
	private WebElement mobile;

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

	public PersonalDetailsPage() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
		wait = new WaitHelper(DriverFactory.getDriver());
	}

	public EventCriteriaPage enterDetails() {
		wait.waitForVisible(firstName);
		wait.waitForClickable(firstName);
		firstName.clear();
		Logs.info("Entering First Name");
		firstName.sendKeys("Pihu");

		wait.waitForVisible(middleName);
		wait.waitForClickable(middleName);
		middleName.clear();
		Logs.info("Entering Middle Name");
		middleName.sendKeys("");

		wait.waitForVisible(lastName);
		wait.waitForClickable(lastName);
		lastName.clear();
		Logs.info("Entering Last Name");
		lastName.sendKeys("Five");

		wait.waitForVisible(mobileCode);
		wait.waitForClickable(mobileCode);
		mobile.clear();
		Logs.info("Entering Mobile Code");
		mobile.sendKeys("91");

		wait.waitForVisible(mobile);
		wait.waitForClickable(mobile);
		mobile.clear();
		Logs.info("Entering Mobile Number");
		mobile.sendKeys("9876543210");

		wait.waitForVisible(genderFemale);
		wait.waitForClickable(genderFemale);
		Logs.info("Selecting gender");
		genderFemale.click();

		/*
		 * wait.until(ExpectedConditions.visibilityOf(dateOfBirth));
		 * wait.until(ExpectedConditions.elementToBeClickable(dateOfBirth));
		 * dateOfBirth.clear(); dateOfBirth.click();
		 */
		selectAddressFromDropdown("110024", "Defence Colony");
		
		wait.waitForVisible(address);
		wait.waitForClickable(address);
		address.clear();
		Logs.info("Entering Address");
		address.sendKeys("A262, Defence Colony, Lajpat Nagar");

		selectNationality("Indian");


		wait.waitForVisible(runningClubNo);
		wait.waitForClickable(runningClubNo);
		Logs.info("Entering Running Club");
		runningClubNo.click();

		selectOccupation("Housewife");

		wait.waitForVisible(proceedBtn);
		wait.waitForClickable(proceedBtn);
		Logs.info("Clicking proceed btn");
		proceedBtn.click();
		return new EventCriteriaPage();

	}

	public void selectOccupation(String occupationToSelect) {
		
		wait.waitForVisible(occupation);
		wait.waitForClickable(occupation);
		Logs.info("Clicking Occupation");
		occupation.click();
		Logs.info("Clicked Occupation");
		Logs.info("Entering Occupation");
		waitThread(5000);
		List<WebElement> occupationsList = DriverFactory.getDriver()
				.findElements(By.xpath("//ng-dropdown-panel//span[@class='ng-option-label']"));
		waitThread(5000);
		System.out.println("Occupation List Size: " + occupationsList.size());
		for (WebElement occupation : occupationsList) {
			System.out.println(occupation.getText().toString());
		}
		DropdownHelper dropdown = new DropdownHelper(DriverFactory.getDriver());
		dropdown.selectFromList(occupationsList, occupationToSelect);
		Logs.info("Occupations selected from dropdown: " + occupationToSelect);
	}

	public void selectNationality(String nationalityToSelect) {
		scrollElementInToView(nationality);
		wait.waitForVisible(nationality);
		wait.waitForClickable(nationality);
		nationality.clear();
		Logs.info("Entering Nationality");
		nationality.sendKeys(nationalityToSelect);
		System.out.println("Nationality is : "+nationalityToSelect);
		waitThread(5000);

		List<WebElement> nationalities = DriverFactory.getDriver()
				.findElements(By.xpath("//div[contains(@class,'position-relative')]//ul"));
		waitThread(5000);
		System.out.println("Nationality List Size: " + nationalities.size());
		for (WebElement nationality : nationalities) {
			System.out.println(nationality.getText().toString());
		}
		DropdownHelper dropdown = new DropdownHelper(DriverFactory.getDriver());
		dropdown.selectFromList(nationalities, nationalityToSelect);
		Logs.info("Nationality selected from dropdown: " + nationalityToSelect);

	}

	public void selectAddressFromDropdown(String pinCode, String addressToSelect) {
		scrollElementInToView(pincode);
		wait.waitForVisible(pincode);
		wait.waitForClickable(pincode);
		pincode.clear();
		Logs.info("Entering Pin Code");
		pincode.sendKeys(pinCode);
		waitThread(5000);

		List<WebElement> addressOptions = DriverFactory.getDriver()
				.findElements(By.xpath("//div[contains(@class,'position-relative')]//ul"));
		waitThread(10000);
		System.out.println("Address List Size: " + addressOptions.size());
		for (WebElement address : addressOptions) {
			System.out.println(address.getText().toString());
		}

		DropdownHelper dropdown = new DropdownHelper(DriverFactory.getDriver());
		dropdown.selectFromList(addressOptions, addressToSelect);
		Logs.info("Address selected from dropdown: " + addressToSelect);
	}

	public void scrollElementInToView(WebElement element) {
		((JavascriptExecutor) DriverFactory.getDriver())
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
