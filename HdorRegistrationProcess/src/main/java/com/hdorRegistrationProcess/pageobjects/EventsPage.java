package com.hdorRegistrationProcess.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hdorRegistrationProcess.actiondriver.Action;
import com.hdorRegistrationProcess.base.BaseClass;

public class EventsPage extends BaseClass {

	Action action = new Action();

	@FindBy(xpath = "//span[text()='Running']")
	private WebElement running;

	@FindBy(xpath = "///span[text()='Cycling']")
	private WebElement cycling;

	@FindBy(xpath = "//span[text()='Steps']")
	private WebElement steps;

	@FindBy(xpath = "//input[@id=':r1:']")
	private WebElement searchByEventName;

	@FindBy(xpath = "//div[contains(text(),'Tour De 100 2024')]")
	private WebElement tourDe1002024;

	@FindBy(xpath = "//button[text()='Referral Rewards']")
	private WebElement referralRewards;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[4]/div[1]/div[3]/div[4]/div[2]/button[1]")
	private WebElement register;

	public EventsPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public String getMyPageTitle() {
		String myPageTitel = getDriver().getTitle();
		return myPageTitel;
	}

	public SelectedEventPage clickOnEventRegistrationButton() {
		action.scrollByVisibilityOfElement(getDriver(), tourDe1002024);
		action.fluentWait(getDriver(), register, 5);
		action.click(getDriver(), register);
		return new SelectedEventPage();
	}

}
