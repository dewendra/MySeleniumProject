package com.hdor.eventdashboard.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hdor.eventdashboard.actiondriver.Action;
import com.hdor.eventdashboard.base.BaseClass;

public class HomePage extends BaseClass{
	Action action = new Action();
	
	
	
	@FindBy(xpath = "//div[contains(text(),'100 Days Of Running 2024.')]")
	private WebElement HDOR_2024;
	
	@FindBy(xpath="(//button[@type='button'][normalize-space()='Register'])[1]")
	private WebElement registerButton;
	
	@FindBy(xpath="(//button[@type='button'][normalize-space()='Buy Now'])[1]")
	private WebElement BottomBuyNowButton;
	@FindBy(xpath="(//button[@type='button'][normalize-space()='EUR'])[1]")
	private WebElement BottomEURButton;
	@FindBy(xpath="(//button[@type='button'][normalize-space()='GBP'])[1]")
	private WebElement BottomGBPButton;
	@FindBy(xpath="(//button[@type='button'][normalize-space()='INR'])[1]")
	private WebElement BottomINRButton;
	@FindBy(xpath="(//button[@type='button'][normalize-space()='USD'])[1]")
	private WebElement BottomUSDButton;
	
	@FindBy(xpath="(//button[@type='button'][normalize-space()='Buy Now'])[3]")
	private WebElement SideBarBuyNowButton;
	@FindBy(xpath="(//button[@type='button'][normalize-space()='EUR'])[3]")
	private WebElement SideBarEURButton;
	@FindBy(xpath="(//button[@type='button'][normalize-space()='GBP'])[3]")
	private WebElement SideBarGBPButton;
	@FindBy(xpath="(//button[@type='button'][normalize-space()='INR'])[3]")
	private WebElement SideBarINRButton;
	@FindBy(xpath="(//button[@type='button'][normalize-space()='USD'])[3]")
	private WebElement SideBarUSDButton;
	
	
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	/*
	 * public boolean validateRegistrationCardBanner() throws Throwable {
	 * action.scrollByVisibilityOfElement(driver, TDH_Registartion_Card_Banner);
	 * boolean result=action.isDisplayed(driver, TDH_Registartion_Card_Banner);
	 * return result;
	 * 
	 * }
	 */
	
	public EventDescriptionPage clickOnRegisterButton() throws Throwable{
		//action.scrollByVisibilityOfElement(driver, TDH_2024);
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
