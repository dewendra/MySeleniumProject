package com.nop.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCustomerPage {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(xpath = "//a[@href='#']//p[contains(text(),'Customers')]")
	private WebElement customerMenu;

	@FindBy(xpath = "//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
	private WebElement customerSubMenu;

	@FindBy(xpath = "//a[@class='btn btn-primary']")
	private WebElement btnAddnew;

	@FindBy(xpath = "//input[@id='Email']")
	private WebElement txtEmail;

	@FindBy(xpath = "//input[@id='Password']")
	private WebElement txtPassword;

	@FindBy(xpath = "//input[@id='FirstName']")
	private WebElement txtFirstName;

	@FindBy(xpath = "//input[@id='LastName']")
	private WebElement txtLastName;

	@FindBy(xpath = "//input[@id='Gender_Male']")
	private WebElement MaleGender;

	@FindBy(xpath = "//input[@id='Gender_Female']")
	private WebElement FemleGender;

	@FindBy(xpath = "//input[@id='Company']")
	private WebElement txtCompany;

	@FindBy(xpath = "//input[@id='IsTaxExempt']")
	private WebElement isTaxExempt;

	@FindBy(xpath = "//div[@class='input-group-append']//input[@role='searchbox']")
	private WebElement txtNewsLetter;

	@FindBy(xpath = "//span[@aria-expanded='true']//input[@role='searchbox']")
	private WebElement txtCustomerRoles;

	@FindBy(xpath = "//li[contains(text(),'Administrators')]")
	private WebElement listItemAdministrators;

	@FindBy(xpath = "//li[contains(text(),'Forum Moderators')]")
	private WebElement listItemForumModerators;

	@FindBy(xpath = "//li[contains(text(),'Registered')]")
	private WebElement listItemRegistered;

	@FindBy(xpath = "//li[contains(text(),'Guests')]")
	private WebElement listItemGuests;

	@FindBy(xpath = "//li[contains(text(),'Vendors')]")
	private WebElement listItemVendors;

	@FindBy(xpath = "//select[@id='VendorId']")
	private WebElement dropdownVendorMgr;

	@FindBy(xpath = "//input[@id='Email']")
	private WebElement txtManagerOfVendor;

	@FindBy(xpath = "//input[@id='Active']")
	private WebElement isActive;

	@FindBy(xpath = "//input[@id='MustChangePassword']")
	private WebElement txtCustomerMustChangePassword;

	@FindBy(xpath = "//textarea[@id='AdminComment']")
	private WebElement txtAdminComment;

	@FindBy(xpath = "//button[@name='save']")
	private WebElement btnSave;

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnCustomerMenu() {
		customerMenu.click();
	}

	public void clickOnCustomerSubMenu() {
		customerSubMenu.click();
	}

	public void clickOnAddNewButton() {
		btnAddnew.click();
	}

	public void setEmail(String email) {
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}

	public void setPassword(String password) {
		txtPassword.clear();
		txtPassword.sendKeys(password);
	}

	public void setFirstName(String firstName) {
		txtFirstName.clear();
		txtFirstName.sendKeys(firstName);
	}

	public void setLastName(String lastName) {
		txtLastName.clear();
		txtLastName.sendKeys(lastName);
	}

	public void selectGender(String gender) {
		if (gender == "Male") {
			MaleGender.click();
		} else if (gender == "Female") {
			FemleGender.click();
		} else {
			MaleGender.click();
		}
	}

	public void setCompanyName(String comp_name) {
		txtCompany.clear();
		txtCompany.sendKeys(comp_name);
	}

	public void enterAdminContent(String content) {
		txtAdminComment.sendKeys(content);
	}

	public void enterManagerOfVendor(String value) {
		Select dropdown = new Select(dropdownVendorMgr);
		dropdown.selectByVisibleText(value);
	}

	public void selectTaxExempt() {
		isTaxExempt.click();
	}

	public void selectActive() {
		isActive.click();
	}
	
	public void selectCustomerMustChangePassword() {
		txtCustomerMustChangePassword.click();
	}

	public void setNewsLetter(String news_letter) {
		txtNewsLetter.clear();
		txtNewsLetter.sendKeys(news_letter);
	}

	public void clickOnSaveBtn() {
		btnSave.click();
	}

	public String pageTitle() {
		return driver.getTitle();
	}
}
