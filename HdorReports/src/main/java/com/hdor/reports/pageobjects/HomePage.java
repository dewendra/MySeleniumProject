package com.hdor.reports.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hdor.reports.actiondriver.Action;
import com.hdor.reports.base.BaseClass;

public class HomePage extends BaseClass{
	Action action = new Action();
	
	
	
	@FindBy(xpath = "//img[@class='sc-beyTiQ gDasas']")
	private WebElement hdorLogo;
	
	@FindBy(xpath = "//input[@name='email']")
	private WebElement emailId;
	
	@FindBy(xpath = "//button[text()='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath = "//input[@id=':r0:']")
	private WebElement searchEvent;
	
	@FindBy(xpath = "//button[normalize-space()='View Result']")
	private WebElement viewResult;
	
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateLogo() throws Throwable {
		boolean result=action.isDisplayed(getDriver(), hdorLogo);
		return result;
		
	}
	/*
	 * public LoginPage emailLogin(String username)throws Throwable {
	 * action.type(emailId, username); System.out.println("Email id:"+username);
	 * Thread.sleep(2000); action.click(getDriver(), continueButton);
	 * System.out.println("Continue Button Clicked"); return new LoginPage(); }
	 */
	public ReportsViewPage searchEvent() throws InterruptedException {
		action.type(searchEvent, "100 Days of Steps Challenge - 2025");
		Thread.sleep(2000);
		action.click(getDriver(), viewResult);
		return new ReportsViewPage();
	}
	

}
