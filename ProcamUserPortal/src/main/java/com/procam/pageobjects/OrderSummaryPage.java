package com.procam.pageobjects;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.procam.base.BaseClass;
import com.procam.utils.CommonHelper;
import com.procam.utils.DriverFactory;
import com.procam.utils.Logs;
import com.procam.utils.WaitHelper;

public class OrderSummaryPage extends BaseClass {

	private WebDriver driver;
	WebDriverWait wait;
	String parentWindow;
	CommonHelper helper;

	@FindBy(xpath = "//h6[normalize-space()='Do you have a GST number?']")
	private WebElement forGstOptions;

	@FindBy(xpath = "//input[@type='radio' and @id='gstbox1']")
	private WebElement gstOptionYes;

	@FindBy(xpath = "//input[@id='gstbox2']")
	private WebElement gstOptionNo;

	@FindBy(xpath = "//input[@name='gstNum']")
	private WebElement gstNumber;

	@FindBy(xpath = "//input[@formcontrolname='gstName']")
	private WebElement gstName;

	@FindBy(xpath = "//div[contains(@class,'mt-3')]//label[@for='pp']")
	private WebElement allWaivers;

	@FindBy(css = "div.mb-2 a[href*='waiver']")
	private WebElement waiver1Link;

	@FindBy(css = "div.mb-2 a[href*='entry-rules']")
	private WebElement entryRulesLink;

	@FindBy(css = "div.mb-2 a[href*='consent']")
	private WebElement consentLink;

	@FindBy(css = "div.mb-2 a[href*='event-medical-advisory']")
	private WebElement event_medical_advisoryLink;

	@FindBy(xpath = "//input[@formcontrolname='waiver']")
	private WebElement waiver1;

	@FindBy(xpath = "//input[@formcontrolname='waiver2']")
	private WebElement waiver2;

	@FindBy(xpath = "//input[@formcontrolname='waiver4']")
	private WebElement waiver4;

	@FindBy(xpath = "//input[@formcontrolname='waiver5']")
	private WebElement waiver5;

	@FindBy(xpath = "//input[@formcontrolname='waiver3']")
	private WebElement waiver3;

	@FindBy(xpath = "//button[@type='submit' and normalize-space()='Back']")
	private WebElement downBackBtn;

	@FindBy(xpath = "//button[ normalize-space()='Proceed']")
	private WebElement proceedBtn;

	public OrderSummaryPage() {
		this.driver = DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		helper=new CommonHelper(driver);
	}

	public PaymentsOptionPage enterGstDetails(Map<String, String> data) {
		
		parentWindow = driver.getWindowHandle();

		String gst_Option = data.get("GST_Option");
		String gst_Number = data.get("GST_Number");
		String gst_Name = data.get("GST_Name");
		String w1 = data.get("Waiver1");
		String w2 = data.get("Waiver2");
		String w3 = data.get("Waiver3");
		String w4 = data.get("Waiver4");
		String w5 = data.get("Waiver5");

		if (gst_Option.equalsIgnoreCase("Yes")) {
			waitThread(3000);
			Logs.info("Going for clicking the GST Yes option....");
			scrollElementInToView(forGstOptions);
			helper.clickWithRetry(gstOptionYes);
			Logs.info("GST Yes option clickied....");
			userGSTDetails();

		} else {
			helper.clickWithRetry(gstOptionNo);
			Logs.info("GST option No selected....");
		}

		Logs.info("Going for entering the GST Number....");
		wait.until(ExpectedConditions.elementToBeClickable(gstNumber));
		gstNumber.sendKeys(gst_Number);
		Logs.info("GST Number entered-> " + gst_Number);

		Logs.info("Going for entering the GST Name....");
		wait.until(ExpectedConditions.elementToBeClickable(gstName));
		gstName.sendKeys(gst_Name);
		Logs.info("GST Name entered-> " + gst_Name);

		scrollElementInToTop(allWaivers);
		//waiverLinkPage();
		if (w1.equalsIgnoreCase("Y")) {
			Logs.info("Going for clicking the Waiver1....");
			//waitThread(1000);
			// wait.waitForClickable(waiver1);
			helper.clickWithRetry(waiver1);
			//waiver1.click();
			Logs.info("Waiver1 clickied....");
		}

		//entryRulesLinkPage();
		if (w2.equalsIgnoreCase("Y")) {
			Logs.info("Going for clicking the Waiver2....");
			helper.clickWithRetry(waiver2);
			//waitThread(1000);
			// wait.waitForClickable(waiver2);
			//waiver2.click();
			Logs.info("Waiver2 clickied....");
		}

		//consentLinkPage();
		if (w4.equalsIgnoreCase("Y")) {
			Logs.info("Going for clicking the Waiver4....");
			helper.clickWithRetry(waiver4);
			//waitThread(1000);
			// scrollElementInToView(waiver4);
			// wait.waitForClickable(waiver4);
			//waiver4.click();
			Logs.info("Waiver4 clickied....");
		}

		//event_medical_advisory_LinkPage();
		if (w5.equalsIgnoreCase("Y")) {
			Logs.info("Going for clicking the Waiver5....");
			helper.clickWithRetry(waiver5);
			//waitThread(1000);
			// wait.waitForClickable(waiver5);
			//waiver5.click();
			Logs.info("Waiver5 clickied....");
		}

		if (w3.equalsIgnoreCase("Y")) {
			Logs.info("Going for clicking the Waiver3....");
			helper.clickWithRetry(waiver3);
			//waitThread(1000);
			//wait.waitForClickable(waiver3);
			//waiver3.click();
			Logs.info("Waiver3 clickied....");
		}

		waitThread(2000);
		// scrollElementInToView(proceedBtn);
		Logs.info("Going for clicking the proceed Button....");
		helper.clickWithRetry(proceedBtn);
		//JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		//javascriptExecutor.executeScript("arguments[0].click();", proceedBtn);
		Logs.info("Proceed Btn clickied....");

		Logs.info("Going for Payment Page....");
		return new PaymentsOptionPage();
	}
	// -----------------------All link page methods-------------------------------//

	public void waiverLinkPage() {
		helper.clickWithRetry(waiver1Link);
		//waiver1Link.click();
		Logs.info("Clicked on Waiver Link");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		for (String window : driver.getWindowHandles()) {
			if (!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}
		verifyWaiverLinkPageAndReturn();
	}

	private void verifyWaiverLinkPageAndReturn() {
		try {
			String waiverPage_actualTitle = driver.getTitle();
			Assert.assertTrue(waiverPage_actualTitle.contains("Waiver"),
					"Expected title to contain 'Waiver' but found: " + waiverPage_actualTitle);
		} finally {
			driver.close();
			driver.switchTo().window(parentWindow);
			Logs.info("Switched back to parent window");
		}

	}

	public void entryRulesLinkPage() {
		helper.clickWithRetry(entryRulesLink);
		//entryRulesLink.click();
		Logs.info("Clicked on Entry Rules Link");
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		for(String window:driver.getWindowHandles()) {
			if(!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}
		verifyEntryRuleLinkPageAndReturn();
	}

	private void verifyEntryRuleLinkPageAndReturn() {
		try {
			String entryRulePage_actualTitle=driver.getTitle();
			Assert.assertTrue(entryRulePage_actualTitle.contains("Entry Rules & Regulations"), "Expected title to contain 'Entry Rules & Regulations' but found: "+entryRulePage_actualTitle);
		} finally {
			driver.close();
			driver.switchTo().window(parentWindow);
			Logs.info("Switched back to parent window");
		}
		
	}

	public void consentLinkPage() {
		helper.clickWithRetry(consentLink);
		//consentLink.click();
		Logs.info("Clicked on Entry Rules Link");
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		for(String window:driver.getWindowHandles()) {
			if(!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}
		verifyConsentLinkLinkPageAndReturn();

	}

	private void verifyConsentLinkLinkPageAndReturn() {
		try {
			String consentPage_actualTitle=driver.getTitle();
			Assert.assertTrue(consentPage_actualTitle.contains("Consent"), "Expected title to contain 'Consent' but found: "+consentPage_actualTitle);
		} finally {
			driver.close();
			driver.switchTo().window(parentWindow);
			Logs.info("Switched back to parent window");
		}
		
	}

	public void event_medical_advisory_LinkPage() {
		helper.clickWithRetry(event_medical_advisoryLink);
		//event_medical_advisoryLink.click();
		Logs.info("Clicked on Entry Rules Link");
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		for(String window:driver.getWindowHandles()) {
			if(!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}
		verifyevent_medical_advisoryLinkPageAndReturn();
	}

	private void verifyevent_medical_advisoryLinkPageAndReturn() {
		try {
			String medicalAdvisoryPage_actualTitle=driver.getTitle();
			Assert.assertTrue(medicalAdvisoryPage_actualTitle.contains("Event Medical Advisory"), "Expected title to contain 'Event Medical Advisory' but found: "+medicalAdvisoryPage_actualTitle);
		} finally {
			driver.close();
			driver.switchTo().window(parentWindow);
			Logs.info("Switched back to parent window");
		}
		
	}

	// --------------user gst details NOT IN USE-------------------------------//
	private void userGSTDetails() {

	}

	// --------------------class level
	// methods-----------------------//
	private void waitThread(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void scrollElementInToTop(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'start', inline:'nearest'});",
				element);
	}

	public void scrollElementInToView(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center', inline:'nearest'});",
				element);
	}

	public void scrollElementInToEnd(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'end', inline:'nearest'});",
				element);
	}

}
