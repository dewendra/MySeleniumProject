package com.procam.pageobject;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.procam.base.BaseClass;

public class LoginPage extends BaseClass{
	
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
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
	
	public VendorDashBaoardPage loginByEmail() throws InterruptedException {
		//wait.until(ExpectedConditions.visibilityOf(emailId));
		Thread.sleep(12000);
		emailId.clear();
		emailId.sendKeys("dewendra.singh@gssltd.co.in");
		
		wait.until(ExpectedConditions.elementToBeClickable(sendOTP)).click();
		
		wait.until(ExpectedConditions.visibilityOf(otp)).sendKeys("000000");
		
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
		
		return new VendorDashBaoardPage();
		
	}

}
