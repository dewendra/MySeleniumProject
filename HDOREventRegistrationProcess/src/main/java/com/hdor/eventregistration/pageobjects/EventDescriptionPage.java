package com.hdor.eventregistration.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hdor.eventregistration.actiondriver.Action;
import com.hdor.eventregistration.base.BaseClass;

public class EventDescriptionPage extends BaseClass{
	Action action = new Action();
	
	@FindBy(xpath = "//img[@src='https://media.hdor.com/ticketing/uat/organiser/event/graphics/127/ZqI3TLpRzGv0LNAThsHG.jpeg']")
	private WebElement TDH_Registartion_Card_Banner;
	
	@FindBy(xpath = "//*[@id=\"ticketingRoot\"]/div/div[2]/div/div[1]/div[2]/div[3]/div/div/div/div[2]/button")
	private WebElement buyNowButton;
	
	
	
	public EventDescriptionPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateRegistrationCardBanner() throws Throwable {
		action.scrollByVisibilityOfElement(driver, TDH_Registartion_Card_Banner);
		boolean result=action.isDisplayed(driver, TDH_Registartion_Card_Banner);
		return result;
		
	}
	
	public EventTicketPage clickOnBuyNowButton() throws Throwable{
		action.scrollByVisibilityOfElement(driver, buyNowButton);
		Thread.sleep(2000);
		action.click(driver, buyNowButton);
		System.out.println("Buy Now Button Clicked");
		return new EventTicketPage();
	}
	
}
