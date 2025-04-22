package com.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.opencart.base.BaseClass;

public class HomePage extends BaseClass {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement lnkMyAccount;
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement lnkRegister;

	public void clickonMyAccount() {
		lnkMyAccount.click();
	}

	public void clickOnRegister() {
		lnkRegister.click();
	}
}
