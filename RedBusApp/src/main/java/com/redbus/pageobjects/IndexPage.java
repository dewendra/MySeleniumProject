package com.redbus.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.redbus.actiondriver.Action;
import com.redbus.base.BaseClass;

public class IndexPage extends BaseClass{
	
	Action action = new Action();
	
	//Locating the web elements
	@FindBy(xpath = "//img[@title='redBus']")
	private WebElement redbus_Logo;
	
	@FindBy(xpath = "//div[normalize-space()='From']")
	private WebElement from;
	@FindBy(xpath = "//div[contains(@class,\"suggestionsWrapper\")]")
	private WebElement searchBox;
	
	@FindBy(xpath = "//img[@title='redBus']")
	private WebElement to;
	
	@FindBy(xpath = "//span[@class='doj___db963b']")
	private WebElement date;

	private WebElement searchTextBox;
	
	
	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	WebDriverWait wait=new WebDriverWait(getDriver(), Duration.ofSeconds(5));
	
	public boolean validateLogo() throws Throwable {
		boolean result = action.isDisplayed(getDriver(), redbus_Logo);
		return result;
	}
	public void enterdetails() throws InterruptedException {
		//Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOf(from)); //using explicit wait here for expected condition like visibility of Element
		action.click(getDriver(), from);
		wait.until(ExpectedConditions.visibilityOf (searchBox));
		searchTextBox = getDriver().switchTo().activeElement();
		searchTextBox.sendKeys("kolkata");
		
	}

	public void clickOnDate() {
		//action.click(getDriver(), date);
		//from.sendKeys("ARA");
	}
}
