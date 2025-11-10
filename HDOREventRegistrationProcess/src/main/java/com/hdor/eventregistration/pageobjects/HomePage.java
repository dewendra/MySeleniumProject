package com.hdor.eventregistration.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.hdor.eventregistration.actiondriver.Action;
import com.hdor.eventregistration.base.BaseClass;

public class HomePage extends BaseClass{
	Action action = new Action();
	String eventName="Walkathon 2025";	
	
	@FindBy(xpath = "//div[text()='Walkathon 2025']/ancestor::div/following-sibling::div[3]/child::div[2]/button[text()='Register']")
	private WebElement eventWebElement;
	
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
	
	@FindBy(xpath="(//button[@type='button'])[3]")
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
		Thread.sleep(5000);
		WebElement eventElement=driver.findElement(By.xpath("//div[text()='Walkathon 2025']/ancestor::div/following-sibling::div[3]/child::div[2]/button[text()='Register']"));
		action.scrollByVisibilityOfElement(driver, eventElement);
		Thread.sleep(2000);
		action.click(driver, eventElement);
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
