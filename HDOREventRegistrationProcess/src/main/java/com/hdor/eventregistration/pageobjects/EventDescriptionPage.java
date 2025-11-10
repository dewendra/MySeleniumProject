package com.hdor.eventregistration.pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.gson.annotations.Until;
import com.hdor.eventregistration.actiondriver.Action;
import com.hdor.eventregistration.base.BaseClass;

public class EventDescriptionPage extends BaseClass {
	Action action = new Action();

	@FindBy(xpath = "//img[@src='https://media.hdor.com/ticketing/uat/organiser/event/graphics/127/ZqI3TLpRzGv0LNAThsHG.jpeg']")
	private WebElement TDH_Registartion_Card_Banner;

	@FindBy(xpath = "(//button[@type='button'])[3]")
	private WebElement SideBarBuyNowButton;

	WebDriverWait wait;

	public EventDescriptionPage() {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	}

	public boolean validateRegistrationCardBanner() throws Throwable {
		action.scrollByVisibilityOfElement(driver, TDH_Registartion_Card_Banner);
		boolean result = action.isDisplayed(driver, TDH_Registartion_Card_Banner);
		return result;

	}

	public EventTicketPage clickOnBuyNowButton() throws Throwable {
		Thread.sleep(5000);
		action.scrollByVisibilityOfElement(driver, SideBarBuyNowButton);
		// Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(SideBarBuyNowButton));
		// action.click(driver, SideBarBuyNowButton);
		System.out.println("Buy Now Button Clicked");
		return new EventTicketPage();
	}

}
