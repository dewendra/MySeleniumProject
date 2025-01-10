package com.hdorRegistrationProcess.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hdorRegistrationProcess.actiondriver.Action;
import com.hdorRegistrationProcess.base.BaseClass;

public class UserSettingPage extends BaseClass {
	Action action = new Action();
	
	@FindBy(xpath = "//h6[normalize-space()='Banner & Certificates']")
	private WebElement bannerAndCertificates;

	
	public UserSettingPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public DownloadCertificatePage clickOnBannerAndCertificate() {
		action.click(getDriver(), bannerAndCertificates);
		System.out.println("Banner And Certificates clicked");
		return new DownloadCertificatePage();
		
	}
	
}
