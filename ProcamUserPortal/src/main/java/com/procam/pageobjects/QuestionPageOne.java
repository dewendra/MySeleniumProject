package com.procam.pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.procam.base.BaseClass;

public class QuestionPageOne extends BaseClass {
	WebDriverWait wait;

	@FindBy(xpath = "//input[@id='flexRadioDefault1']")
	private WebElement yesRadioButton;

	@FindBy(xpath = "//input[@id='flexRadioDefault2']")
	private WebElement noRadioButton;

	@FindBy(xpath = "//button[normalize-space()='Proceed']")
	private WebElement proceedButton;

	@FindBy(xpath = "//input[@id='discountCode']")
	private WebElement discountCode;

	@FindBy(xpath = "//button[normalize-space()='Apply']")
	private WebElement applyBtn;

	public QuestionPageOne() {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

}
