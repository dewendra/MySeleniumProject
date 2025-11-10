package com.procam.pageobject;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.procam.base.BaseClass;

public class LoginPage extends BaseClass{
	
	@FindBy(xpath = "//input[@id='emailId']")
	private WebElement emailId;
	
	@FindBy(xpath = "//button[normalize-space()='Send OTP']")
	private WebElement SendOTP;
	
	@FindBy(xpath = "135613")
	private WebElement OTP;
	@FindBy(xpath = "//button[normalize-space()='Login']")
	private WebElement loginBtn;
	
	WebDriverWait wait;
	public LoginPage() {
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		
	}
	
	public VendorDashBaoardPage loginByEmail() {
		emailId.sendKeys("dewendra.singh@gssltd.co.in");
		SendOTP.click();
		return new VendorDashBaoardPage();
		
	}

}
