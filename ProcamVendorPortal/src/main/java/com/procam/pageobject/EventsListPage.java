package com.procam.pageobject;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.procam.actiondriver.Action;
import com.procam.base.BaseClass;

public class EventsListPage extends BaseClass {
	Action action = new Action();

	@FindBy(xpath = "//h6[normalize-space()='Tata Mumbai Marathon 2026']")
	private WebElement eventName;

	WebDriverWait wait;

	public EventsListPage() {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public EventDashBoard selectEvent() {
		try {
			action.scrollByVisibilityOfElement(driver, eventName);
			wait.until(ExpectedConditions.visibilityOf(eventName));
			wait.until(ExpectedConditions.elementToBeClickable(eventName));
			eventName.click();
		} catch (Exception e) {
			System.out.println("Normal click failed, trying JavaScript click. Reason: " + e.getMessage());
			// Fallback to JS click if regular click fails
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", eventName);
			js.executeScript("arguments[0].click();", eventName);
		}

		return new EventDashBoard();
	}
}
