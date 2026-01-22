package com.procam.pageobjects;

import java.time.Duration;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.procam.utils.DriverFactory;
import com.procam.utils.Logs;
import com.procam.utils.TypingHelper;
import com.procam.utils.WaitHelper;

public class LoginPage {

	private WebDriver driver;

	//WaitHelper wait;

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

	WebDriverWait wait;
	public LoginPage() {
		this.driver = DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, Duration.ofSeconds(7));
		//wait = new WaitHelper(driver);
		
	}

	public EventDashboardPage loginByEmail(Map<String, String> data) throws InterruptedException {
		
		//WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(emailId));
		Logs.info("Entering email....");
		emailId.clear();
		String email = data.get("emailId");
		if (email == null || email.isBlank()) {
			throw new IllegalArgumentException("Email is empty in Excel");
		}
		emailId.sendKeys(email);
		//TypingHelper.slowTyping(emailId, email, 100);
		Logs.info("Email entered -> " + email);

		/*
		 * waitThread(5000); if (data.get("userType").equalsIgnoreCase("myself")) {
		 * myself18Years.click(); } else { myward18Years.click(); }
		 */

		wait.until(ExpectedConditions.elementToBeClickable(sendOTP));
		Logs.info("Clicking sendOTP");
		sendOTP.click();
		// wait.until(ExpectedConditions.visibilityOf(otp)).sendKeys("000000");

		String otpValue = data.getOrDefault("otp", "000000");
		wait.until(ExpectedConditions.elementToBeClickable(otp));
		otp.sendKeys(otpValue);
		Logs.info("Clicking login");
		
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
		//wait.waitForClickable(loginBtn).click();

		return new EventDashboardPage();

	}

	private void waitThread(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
