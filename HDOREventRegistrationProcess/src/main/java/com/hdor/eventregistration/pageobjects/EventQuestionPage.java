package com.hdor.eventregistration.pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hdor.eventregistration.actiondriver.Action;
import com.hdor.eventregistration.base.BaseClass;

public class EventQuestionPage extends BaseClass {
	Action action = new Action();

	@FindBy(xpath = "//p[contains(text(),'Salutation*')]/parent::div/child::div/child::div/child::input[@name='salutation']")
	private WebElement salutaionLocatorWebElement;
	@FindBy(xpath = "//input[@name='firstName']")
	private WebElement firstNameLocatorWebElement;
	@FindBy(xpath = "//input[@name='lastName']")
	private WebElement lastNameLocatorWebElement;
	@FindBy(xpath = "//p[text()='Email Id*']/parent::div/child::div/child::div/child::input[@type='text']")
	private WebElement emailIdLocatorWebElement;

	@FindBy(xpath = "(//button[text()='Skip'])[1]")
	private WebElement skipBtnOne;
	@FindBy(xpath = "//button[text()='Save & Next']")
	private WebElement saveAndNextBtn;
	@FindBy(xpath = "(//button[text()='Skip'])[2]")
	private WebElement skipBtnTwo;

	WebDriverWait wait;

	public EventQuestionPage() {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(4));
	}

	public TicketSummaryPage enterParticipantsDetails() {
		salutaionLocatorWebElement.sendKeys("Mr.");
		firstNameLocatorWebElement.sendKeys("john");
		lastNameLocatorWebElement.sendKeys("One");
		emailIdLocatorWebElement.sendKeys("john1@yopmail.com");
		wait.until(ExpectedConditions.elementToBeClickable(saveAndNextBtn));
		// saveAndNextBtn.click();
		return new TicketSummaryPage();
	}
}
