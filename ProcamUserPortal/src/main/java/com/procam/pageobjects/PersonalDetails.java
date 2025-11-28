package com.procam.pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.procam.actiondriver.Action;
import com.procam.base.BaseClass;

public class PersonalDetails extends BaseClass{
	
	private Action action;

	WebDriverWait wait;
	
	@FindBy(xpath = "//div[contains(@class,'fs-3')]//span[contains(@class,'btn-fa-color')]")
	private WebElement backBtn;
	
	@FindBy(xpath = "//input[@name='firstName']")
	private WebElement firstName;
	@FindBy(xpath = "//input[@name='middleName']")
	private WebElement middleName;
	@FindBy(xpath = "//input[@name='lastName']")
	private WebElement lastName;
	@FindBy(xpath = "//input[@name='emailId']")
	private WebElement emailId;
	@FindBy(xpath = "//input[@name='mobile']")
	private WebElement mobile;
	@FindBy(xpath = "//input[@id='genderMale']")
	private WebElement genderMale;
	@FindBy(xpath = "//input[@id='genderFemale']")
	private WebElement genderFemale;
	@FindBy(xpath = "//input[contains(@class,'calendar-input')]")
	private WebElement dateOfBirth;
	@FindBy(xpath = "//div/select[contains(@class,'yearpicker')]")
	private WebElement yearpicker;
	@FindBy(xpath = "//div/select[contains(@class,'monthpicker')]")
	private WebElement monthpicker;
	@FindBy(xpath = "//input[@name='address']")
	private WebElement address;
	
	
	
	public PersonalDetails() {
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	}
}
