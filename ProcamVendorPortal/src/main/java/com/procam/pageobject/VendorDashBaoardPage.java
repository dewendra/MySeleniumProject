package com.procam.pageobject;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.procam.base.BaseClass;

public class VendorDashBaoardPage extends BaseClass{

	@FindBy(xpath = "//h5[normalize-space()='Account Team']")
	private WebElement accountsTeam;
	
	WebDriverWait wait;
	public VendorDashBaoardPage() {
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	
	public EventsListPage selectOptions() {
		accountsTeam.click();
		return new EventsListPage();
	}
}
