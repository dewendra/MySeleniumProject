package com.hdor.eventregistration.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hdor.eventregistration.actiondriver.Action;
import com.hdor.eventregistration.base.BaseClass;

public class HomePage extends BaseClass{
	Action action = new Action();
	
	
	
	@FindBy(xpath = "//div[contains(text(),'100 Days Of Running 2024.')]")
	private WebElement HDOR_2024;
	
	@FindBy(xpath = "//div[contains(text(),'Tour De 100 2024')]")
	private WebElement TDH_2024;
	
	@FindBy(xpath = "//img[@src='https://media.hdor.com/ticketing/uat/organiser/event/graphics/117/pQFfXo6Rjc6lbq60zTdP.jpeg']")
	private WebElement TDH_Registartion_Card_Banner;
	
	@FindBy(xpath = "//img[@src='https://media.hdor.com/ticketing/uat/organiser/event/graphics/117/pQFfXo6Rjc6lbq60zTdP.jpeg']")
	private WebElement HDOR_Registartion_Card_Banner;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[4]/div[1]/div[3]/div[4]/div[2]/button[1]")
	private WebElement registerButton;
	
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateRegistrationCardBanner() throws Throwable {
		action.scrollByVisibilityOfElement(driver, TDH_Registartion_Card_Banner);
		boolean result=action.isDisplayed(driver, TDH_Registartion_Card_Banner);
		return result;
		
	}
	
	public EventDescriptionPage clickOnRegisterButton() throws Throwable{
		action.scrollByVisibilityOfElement(driver, TDH_2024);
		Thread.sleep(2000);
		action.click(driver, registerButton);
		System.out.println("Register Button Clicked");
		return new EventDescriptionPage();
	}
	
	
	/*
	 * public LoginPage emailLogin(String username)throws Throwable {
	 * action.type(emailId, username); System.out.println("Email id:"+username);
	 * Thread.sleep(2000); action.click(driver, continueButton);
	 * System.out.println("Continue Button Clicked"); return new LoginPage(); }
	 */
	
	

}
