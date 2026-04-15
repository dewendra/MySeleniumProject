package com.procam.pageobjects;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.procam.base.BaseClass;
import com.procam.utils.CommonHelper;
import com.procam.utils.DriverFactory;

public class TransactionSuccessPage extends BaseClass{
	
	private static final Logger log=LogManager.getLogger(TransactionSuccessPage.class);
	private WebDriver driver;
	WebDriverWait wait;
	CommonHelper helper;
	
	@FindBy(xpath = "//h2//span[normalize-space()='Your transaction was successful']")
	WebElement successMsg;
	
	public TransactionSuccessPage() {
		this.driver=DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		helper=new CommonHelper(driver);
	}
	
	public void goingForLogout() throws InterruptedException {
		log.info("In logout method");
		waitForLoaderToDisappear();
		getcurrentUrl();
		getPageTitle();
		log.info("Finding logout button locator through By locator ");
		By logoutLocator = By.xpath("//a[normalize-space()='Logout']");
		log.info("Found logout button locator through By locator " + logoutLocator);
		List<WebElement> logoutList = driver.findElements(logoutLocator);

		if (logoutList.isEmpty()) {
		    log.info("Logout button NOT present on this page. Skipping logout.");
		    return;
		}
		log.info("Logout button present on this page. Going for logout.");
		WebElement logout = new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfElementLocated(logoutLocator));
		log.info("Logout button locator through Web Element " + logout);

		log.info("Waiting for Logout button to be clickable...");
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(logout));

		helper.clickWithRetry(logout);
		log.info("Logout clicked successfully");

	}
	
	public void getcurrentUrl() {
		log.info("Getting the current page Url..");
		String current_page_Url =driver.getCurrentUrl();
		System.out.println("Page page current Url:->"+current_page_Url);
	}
	
	public void getPageTitle() {
		log.info("Getting the page title..");
		String page_title =driver.getTitle();
		System.out.println("Page Title:->"+page_title);
	}
	
	public void getPageSource() {
		
	}
	
	public void waitForLoaderToDisappear() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'position-fixed')]")));
	}
	
	
	

}
