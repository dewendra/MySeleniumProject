package com.hdor.eventdashboard.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.hdor.eventdashboard.actiondriver.Action;
import com.hdor.eventdashboard.base.BaseClass;



public class HomePage extends BaseClass{
	Action action = new Action();
	
	
	
	@FindBy(xpath = "//img[@class='sc-beyTiQ gDasas']")
	private WebElement hdorLogo;
	
	@FindBy(xpath = "//input[@name='email']")
	private WebElement emailId;
	
	@FindBy(xpath = "//button[text()='Continue']")
	private WebElement continueButton;
	
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateLogo() throws Throwable {
		boolean result=action.isDisplayed(driver, hdorLogo);
		return result;
		
	}
	public LoginPage emailLogin(String username)throws Throwable {
		action.type(emailId, username);
		System.out.println("Email id:"+username);
		Thread.sleep(2000);
		action.click(driver, continueButton);
		System.out.println("Continue Button Clicked");
		return new LoginPage();
	}
	
	

}
