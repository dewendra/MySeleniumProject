package com.nop.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver; 

	@FindBy(xpath = "input[@id='Email']")
	private WebElement txtEmail;

	@FindBy(xpath = "//input[@id='Password']")
	private WebElement txtpassword;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginBtn;

	@FindBy(xpath = "//a[@id='nav-logo-sprites']")
	private WebElement logoutBtn;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	/*
	 * public LoginPage(WebDriver remoteDriver) { localDriver=remoteDriver;
	 * PageFactory.initElements(remoteDriver, this); }
	 */

	public void setEmail(String email) {
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}

	public void setPassword(String password) {
		txtpassword.clear();
		txtpassword.sendKeys(password);
	}

	public void clickLoginBtn() {
		loginBtn.click();
	}

	public void clickLogoutBtn() {
		logoutBtn.click();
	}

	public void getPageTitle() {
		driver.getTitle();
	}






}
