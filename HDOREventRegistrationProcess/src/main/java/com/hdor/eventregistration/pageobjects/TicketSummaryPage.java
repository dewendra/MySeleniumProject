package com.hdor.eventregistration.pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.hdor.eventregistration.base.BaseClass;

public class TicketSummaryPage extends BaseClass {

	@FindBy(xpath = "//button[contains(normalize-space(.),'Proceed To Register') and @type='button']")
	private WebElement proceedToRegisterBtn;

	WebDriverWait wait;

	public TicketSummaryPage() {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(4));
	}

	public void proceedToRegister() {
		wait.until(ExpectedConditions.elementToBeClickable(proceedToRegisterBtn));
		// proceedToRegisterBtn.click();
	}

}
