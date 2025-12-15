package com.procam.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.procam.base.BaseClass;
import com.procam.utils.DriverFactory;
import com.procam.utils.Logs;
import com.procam.utils.WaitHelper;

public class LoginPage extends BaseClass {
	
	WaitHelper wait;

	@FindBy(xpath = "//img[@class='logo']")
	private WebElement eventLogo;
	
	@FindBy(xpath = "//input[@id='emailId']")
	private WebElement emailId;
	
	@FindBy(xpath = "//input[@id='mat-radio-5-input']")
	private WebElement myself18Years;
	
	@FindBy(xpath = "//input[@id='mat-radio-6-input']")
	private WebElement myward18Years;
	
	@FindBy(xpath = "//button[normalize-space()='Send OTP']")
	private WebElement sendOTP;
	
	@FindBy(xpath = "//input[@id='otp']")
	private WebElement otp;
	
	@FindBy(xpath = "//button[normalize-space()='Login']")
	private WebElement loginBtn;

	

	public LoginPage() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
		wait = new WaitHelper(DriverFactory.getDriver());
	}

	public EventDashboardPage loginByEmail() throws InterruptedException {
		Thread.sleep(12000);
		Logs.info("Entering email");
		emailId.clear();
		emailId.sendKeys("pihu5@yopmail.com");
		Logs.info("Clicking sendOTP");
		wait.waitForClickable(sendOTP).click();
		//wait.until(ExpectedConditions.elementToBeClickable(sendOTP)).click();
		Thread.sleep(2000);
		//wait.until(ExpectedConditions.visibilityOf(otp)).sendKeys("000000");
		wait.waitForVisible(otp);
		wait.waitForClickable(otp);
		otp.sendKeys("0");
		Logs.info("Clicking login");
		wait.waitForClickable(loginBtn).click();
		//wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
		return new EventDashboardPage();

	}

}
