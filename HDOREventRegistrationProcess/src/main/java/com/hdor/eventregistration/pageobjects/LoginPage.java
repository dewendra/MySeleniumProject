package com.hdor.eventregistration.pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hdor.eventregistration.base.BaseClass;

public class LoginPage extends BaseClass {
	
	@FindBy(xpath = "//input[@name='email' and @type='text']")
    private WebElement emailId;
    
    @FindBy(xpath = "//button[normalize-space(text())='Continue' and @type='submit']")
    private WebElement continueBtn;
    
    @FindBy(xpath = "//input[@name='password' and @type='password']")
    private WebElement password;
    
    @FindBy(xpath = "//button[normalize-space(text())='login' and @type='submit']")
    private WebElement loginBtn;
    
    WebDriverWait wait;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public DashBoardPage loginUser() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(emailId)).sendKeys("john6@yopmail.com");
		wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();;
		
		wait.until(ExpectedConditions.visibilityOf(password)).sendKeys("password");
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
		return new DashBoardPage();
	}

}
