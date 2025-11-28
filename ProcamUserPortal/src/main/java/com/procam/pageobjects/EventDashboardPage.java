package com.procam.pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.procam.base.BaseClass;

public class EventDashboardPage extends BaseClass{
	
	WebDriverWait wait;
	
	@FindBy(xpath = "//div[contains(@class,'row')]//div[1]//img")
	private WebElement vdhm_2025;
	
	@FindBy(xpath = "//div[contains(@class,'row')]//div[2]//img")
	private WebElement tmm_2026;
	
	@FindBy(xpath = "//div[contains(@class,'row')]//div[3]//img")
	private WebElement twsk_2025;
	
	
	public EventDashboardPage() {
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void selectEvent() {
		wait.until(ExpectedConditions.visibilityOf(twsk_2025));
		wait.until(ExpectedConditions.elementToBeClickable(twsk_2025));
		twsk_2025.click();
		
	}
}
