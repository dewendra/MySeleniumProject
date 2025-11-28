package com.procam.pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.procam.actiondriver.Action;
import com.procam.base.BaseClass;

public class DiscountApply extends BaseClass {
	private Action action;
	WebDriverWait wait;

	@FindBy(xpath = "//div[contains(@class,'fs-3')]//span[contains(@class,'btn-fa-color')]")
	private WebElement backBtn;

	@FindBy(xpath = "//a[contains(text(),'Read More')]")
	private WebElement read_More;

	@FindBy(xpath = "//input[@id='flexRadioDefault1']")
	private WebElement yesRadioBtn;

	@FindBy(xpath = "//input[@id='flexRadioDefault2']")
	private WebElement noRadioBtn;

	@FindBy(xpath = "//button[normalize-space()='Proceed']")
	private WebElement proceedBtn;

	@FindBy(xpath = "//input[@id='discountCode']")
	private WebElement discountCode;

	@FindBy(xpath = "//button[normalize-space()='Apply']")
	private WebElement applyBtn;

	public DiscountApply() {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void readMore() {
		wait.until(ExpectedConditions.visibilityOf(read_More));
		action.click(driver, read_More);
	}

	public void withDisCode() {
		wait.until(ExpectedConditions.visibilityOf(yesRadioBtn)).click();
		wait.until(ExpectedConditions.visibilityOf(discountCode));
		discountCode.clear();
		discountCode.sendKeys("123456");
		wait.until(ExpectedConditions.elementToBeClickable(applyBtn));
		wait.until(ExpectedConditions.elementToBeClickable(proceedBtn));
		proceedBtn.click();
	}
}
