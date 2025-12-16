package com.procam.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.procam.base.BaseClass;
import com.procam.utils.DriverFactory;
import com.procam.utils.Logs;
import com.procam.utils.WaitHelper;

public class OrderSummaryPage extends BaseClass {

	WaitHelper wait;

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
		PageFactory.initElements(DriverFactory.getDriver(), this);
		wait = new WaitHelper(DriverFactory.getDriver());
	}

	public  PaymentsOptionPage enterGstDetails() {
		waitThread(5000);
		Logs.info("Going for clicking the GST Yes option....");
		scrollElementInToView(forGstOptions);
		wait.waitForVisible(gstOptionYes);
		wait.waitForClickable(gstOptionYes);
		gstOptionYes.click();
		Logs.info("GST Yes option clickied....");

		Logs.info("Going for entering the GST Number....");
		wait.waitForVisible(gstNumber);
		wait.waitForClickable(gstNumber);
		gstNumber.sendKeys("21PIHUF2222F9Z4");
		Logs.info("GST Number entered....");
		

		Logs.info("Going for entering the GST Name....");
		wait.waitForVisible(gstName);
		wait.waitForClickable(gstName);
		gstName.sendKeys("Pihu Five Traders");
		Logs.info("GST Name entered....");
	
		Logs.info("Going for clicking the Waiver1....");
		waitThread(5000);
		scrollElementInToTop(allWaivers);
		wait.waitForClickable(waiver1);
		waiver1.click();
		Logs.info("Waiver1 clickied....");
		
		Logs.info("Going for clicking the Waiver2....");
		waitThread(5000);
		wait.waitForClickable(waiver2);
		waiver2.click();
		Logs.info("Waiver2 clickied....");
		
		Logs.info("Going for clicking the Waiver4....");
		waitThread(5000);
		scrollElementInToView(waiver4);
		wait.waitForClickable(waiver4);
		waiver4.click();
		Logs.info("Waiver4 clickied....");
		
		Logs.info("Going for clicking the Waiver5....");
		waitThread(5000);
		wait.waitForClickable(waiver5);
		waiver5.click();
		Logs.info("Waiver5 clickied....");
		
		Logs.info("Going for clicking the Waiver3....");
		waitThread(5000);
		wait.waitForClickable(waiver3);
		waiver3.click();
		Logs.info("Waiver3 clickied....");
		
		waitThread(2000);
		scrollElementInToView(proceedBtn);
		Logs.info("Going for clicking the proceed Button....");
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) DriverFactory.getDriver();
		javascriptExecutor.executeScript("arguments[0].click();", proceedBtn);
		Logs.info("Proceed Btn clickied....");
		Logs.info("Going for Order Summary Page....");
		
		
		Logs.info("Going for Payment Page....");
		return new PaymentsOptionPage();
	}
	
	private void waitThread(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void scrollElementInToTop(WebElement element) {
		((JavascriptExecutor) DriverFactory.getDriver()).executeScript("arguments[0].scrollIntoView({block: 'start', inline:'nearest'});",
				element);
	}

	public void scrollElementInToView(WebElement element) {
		((JavascriptExecutor) DriverFactory.getDriver())
				.executeScript("arguments[0].scrollIntoView({block:'center', inline:'nearest'});", element);
	}

	public void scrollElementInToEnd(WebElement element) {
		((JavascriptExecutor) DriverFactory.getDriver()).executeScript("arguments[0].scrollIntoView({block: 'end', inline:'nearest'});",
				element);
	}

}
