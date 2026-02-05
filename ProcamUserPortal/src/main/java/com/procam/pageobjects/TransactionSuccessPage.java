package com.procam.pageobjects;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.procam.base.BaseClass;
import com.procam.utils.CommonHelper;
import com.procam.utils.DriverFactory;

public class TransactionSuccessPage extends BaseClass{
	
	private static final Logger log=LogManager.getLogger(TransactionSuccessPage.class);
	private WebDriver driver;
	WebDriverWait wait;
	CommonHelper helper;
	
	@FindBy(xpath = "")
	private WebElement element;
	
	public TransactionSuccessPage() {
		this.driver=DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		helper=new CommonHelper(driver);
	}
	
	public void getPageTitle() {
		log.info("Getting the page title..");
	}
	
	public void getPageSource() {
		
	}
	
	
	
	

}
