package com.hdor.eventregistration.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hdor.eventregistration.actiondriver.Action;
import com.hdor.eventregistration.base.BaseClass;

public class ExploreEventPage extends BaseClass {
	Action action = new Action();

	String eventName = "Walkathon 2025";

	@FindBy(xpath = "//div[text()='Walkathon 2025']/ancestor::div/following-sibling::div[3]/child::div[2]/button[text()='Register']")
	private WebElement eventWebElement;

	@FindBy(xpath = "")
	private WebElement element;

	WebDriverWait wait;

	public ExploreEventPage() {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	}

	public EventDescriptionPage clickOnRegisterButton() throws Throwable {
		Thread.sleep(5000);
		WebElement eventElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[text()='Walkathon 2025']/ancestor::div/following-sibling::div[3]/child::div[2]/button[text()='Register']")));
		action.scrollByVisibilityOfElement(driver, eventElement);
		wait.until(ExpectedConditions.elementToBeClickable(eventElement)).click();
		System.out.println("Register Button Clicked");
		return new EventDescriptionPage();
	}

}
