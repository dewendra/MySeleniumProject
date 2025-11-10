package com.procam.pageobject;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.procam.base.BaseClass;

public class EventsList extends BaseClass{

	@FindBy(xpath = "//h6[normalize-space()='Tata Steel World 25K Kolkata 2025']")
	private WebElement eventName;
	
	WebDriverWait wait;
	
	public EventsList() {
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	
	public EventDashBoard selectEvent() {
		eventName.click();
		return new EventDashBoard();
	}
}
