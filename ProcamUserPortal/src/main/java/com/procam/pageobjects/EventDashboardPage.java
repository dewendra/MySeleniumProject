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
	
	@FindBy(xpath = "")
	private WebElement element;
	
	@FindBy(xpath = "//div[contains(@class,'row')]//div[2]//img")
	private WebElement event2;
	
	
	public EventDashboardPage() {
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void selectEvent() {
		wait.until(ExpectedConditions.visibilityOf(event2));
		wait.until(ExpectedConditions.elementToBeClickable(event2));
		event2.click();
	}
}
