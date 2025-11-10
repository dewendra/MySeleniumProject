package com.hdor.eventregistration.pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hdor.eventregistration.base.BaseClass;

public class DashBoardPage extends BaseClass {

	@FindBy(xpath = "//h6[normalize-space()='Explore Events']")
	private WebElement exploreEvents;

	WebDriverWait wait;

	public DashBoardPage() {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	}

	public ExploreEventPage exploreEvents() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(exploreEvents)).click();
		return new ExploreEventPage();
	}
}
