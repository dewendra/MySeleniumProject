package com.hdorRegistrationProcess.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hdorRegistrationProcess.actiondriver.Action;
import com.hdorRegistrationProcess.base.BaseClass;

public class HomePage extends BaseClass{
	Action action = new Action();
	HomePage homePage;
	
	
	@FindBy(xpath = "//img[@class='sc-beyTiQ gDasas']")
	private WebElement hdorLogo;
	
	@FindBy(xpath = "//input[@name='email']")
	private WebElement emailId;
	
	@FindBy(xpath = "//button[text()='Continue']")
	private WebElement continueButton;
	
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean getCompanyLogo() {
		boolean result=action.isDisplayed(driver, hdorLogo);
		return result;
		
	}
	
	public HomePage login(String userName) {
		homePage=new HomePage();
		action.type(emailId, userName);
		System.out.println("Email Id/User name:"+userName);
		action.click(driver, continueButton);
		System.out.println("Continue Button Clicked");
		return homePage;
	}

}
