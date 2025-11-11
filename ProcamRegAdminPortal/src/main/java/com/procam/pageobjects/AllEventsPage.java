package com.procam.pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.procam.base.BaseClass;

public class AllEventsPage extends BaseClass{

	@FindBy(xpath = "")
	private WebElement event;
	
	WebDriverWait wait;
	public AllEventsPage() {
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	
	
}
