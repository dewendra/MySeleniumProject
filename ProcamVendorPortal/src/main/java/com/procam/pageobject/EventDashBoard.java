package com.procam.pageobject;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.procam.base.BaseClass;

public class EventDashBoard extends BaseClass{
	
	@FindBy(xpath = "//button[normalize-space()='Participants']")
	private WebElement participantsBtn;
	
	@FindBy(xpath = "//button[normalize-space()='Participants']")
	private WebElement corporateBtn;
	
	@FindBy(xpath = "//button[normalize-space()='Participants']")
	private WebElement reportsBtn;
	
	WebDriverWait wait;
	
	public EventDashBoard() {
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		
	}
	public void selectParticipantOption() {
		
	}

}
