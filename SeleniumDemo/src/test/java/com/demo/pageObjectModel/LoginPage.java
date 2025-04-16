package com.demo.pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	// Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	// Locators

	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement userName;
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement userPassword;
	@FindBy(xpath = "//button[normalize-space()='Login']")
	WebElement loginButton;

	

	public void appLogin(String username, String password) {
		userName.sendKeys(username);
		userPassword.sendKeys(password);
		loginButton.click();
	}

}
