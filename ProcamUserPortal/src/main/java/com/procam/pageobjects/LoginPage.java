package com.procam.pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.procam.base.BaseClass;

public class LoginPage extends BaseClass {
	
	WebDriverWait wait;

	@FindBy(xpath = "//input[@id='emailId']")
	private WebElement emailId;
	
	@FindBy(xpath = "//button[normalize-space()='Send OTP']")
	private WebElement sendOTP;
	
	@FindBy(xpath = "//input[@id='otp']")
	private WebElement otp;
	
	@FindBy(xpath = "//button[normalize-space()='Login']")
	private WebElement loginBtn;

	

	public LoginPage() {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void loginByEmail() throws InterruptedException {
		Thread.sleep(12000);
		emailId.clear();
		emailId.sendKeys("pihu8@yopmail.com");
		
		wait.until(ExpectedConditions.elementToBeClickable(sendOTP)).click();
		Thread.sleep(12000);
		//wait.until(ExpectedConditions.visibilityOf(otp)).sendKeys("000000");
		
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();

	}

}
