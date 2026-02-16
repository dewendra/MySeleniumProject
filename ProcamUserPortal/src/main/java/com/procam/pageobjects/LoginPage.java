package com.procam.pageobjects;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.procam.utils.CommonHelper;
import com.procam.utils.DriverFactory;

public class LoginPage {

	private WebDriver driver;
	private static final Logger log = LogManager.getLogger(LoginPage.class);
	WebDriverWait wait;
	CommonHelper helper;
	String parentWindow;

	// WaitHelper wait;

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

	@FindBy(xpath = "//div[@id='navbarNav']//a[normalize-space()='Contact']")
	private WebElement contactBtn;

	@FindBy(xpath = "//div[@id='navbarNav']//a[normalize-space()='Policy']")
	private WebElement policyBtn;

	@FindBy(xpath = "//div[@id='navbarNav']//button[normalize-space()='Data Protection Policy']")
	private WebElement dataProtectionPolicyBtn;

	@FindBy(xpath = "//div[@id='navbarNav']//a[normalize-space()='Logout']")
	private WebElement logoutBtn;

	public LoginPage() {
		this.driver = DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		helper = new CommonHelper(driver);

	}

	public EventDashboardPage loginByEmail(Map<String, String> data) {

		wait.until(ExpectedConditions.elementToBeClickable(emailId));
		log.info("Entering email....");
		emailId.clear();
		String email = data.get("emailId");
		if (email == null || email.isBlank()) {
			throw new IllegalArgumentException("Email is empty in Excel");
		}
		emailId.sendKeys(email);
		// TypingHelper.slowTyping(emailId, email, 100);
		log.info("Email entered -> " + email);

		/*
		 * wait.until(ExpectedConditions.elementToBeClickable(myself18Years)); if
		 * (data.get("userType").equalsIgnoreCase("myself")) {
		 * helper.clickWithRetry(myself18Years); } else {
		 * helper.clickWithRetry(myward18Years); }
		 */

		wait.until(ExpectedConditions.elementToBeClickable(sendOTP));
		log.info("Clicking sendOTP");
		helper.clickWithRetry(sendOTP);

		String otpValue = data.getOrDefault("otp", "000000");
		wait.until(ExpectedConditions.elementToBeClickable(otp));
		otp.sendKeys(otpValue);
		log.info("Clicking login");

		helper.clickWithRetry(loginBtn);
		// wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
		// wait.waitForClickable(loginBtn).click();

		return new EventDashboardPage();

	}

	public void contactDetails() {
		log.info("Clicking on contact details");
		wait.until(ExpectedConditions.elementToBeClickable(contactBtn));
		helper.clickWithRetry(contactBtn);
		String contactPageTitles = driver.getTitle().toString();
		log.info("contactPageTitles: " + contactPageTitles);
		Assert.assertEquals(contactPageTitles, "PROCAM Registration - Portal");
	}

	public void policyDetails() throws InterruptedException {
		parentWindow = driver.getWindowHandle();
		log.info("Clicking on policy details");
		wait.until(ExpectedConditions.elementToBeClickable(policyBtn));
		helper.clickWithRetry(policyBtn);
		Thread.sleep(5000);

		// Capture all policy options

		List<WebElement> policyOptions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
				By.xpath("//ul[contains(@class,'dropdown-menu')]//button[contains(@class,'dropdown-item')]")));

		log.info("Total policy options found: " + policyOptions.size());

		for(WebElement option:policyOptions) {
			log.info("Options->"+option);
		}
		for (int i = 0; i < policyOptions.size(); i++) {

			// Re-fetch elements (VERY IMPORTANT to avoid stale element)
			policyOptions = driver.findElements(
					By.xpath("//ul[contains(@class,'dropdown-menu')]//button[contains(@class,'dropdown-item')]"));

			String policyOptionsName = policyOptions.get(i).getText();
			log.info("Clicking policy option:" + policyOptionsName);
			helper.clickWithRetry(policyOptions.get(i));
			// policyOptions.get(i).click();

			// switch to new tab
			switchToNewTab(parentWindow);
			log.info("Open policy page title:" + driver.getTitle());

			// Close child tab and return
			//driver.close();
			driver.switchTo().window(parentWindow);

			// Re-open dropdown (Angular collapses it)
			helper.clickWithRetry(policyBtn);

		}
	}

	private void switchToNewTab(String parentWindow) {
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			if (!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}

	}

	public void doingLogout() {
		log.info("Clicking logout btn");
		wait.until(ExpectedConditions.elementToBeClickable(logoutBtn));
		helper.clickWithRetry(logoutBtn);
	}

	private void waitThread(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
