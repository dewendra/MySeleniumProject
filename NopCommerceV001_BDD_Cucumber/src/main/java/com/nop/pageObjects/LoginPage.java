package com.nop.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(xpath = "//input[@id='Email']")
	private WebElement txtEmail;

	@FindBy(xpath = "//input[@id='Password']")
	private WebElement txtPassword;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginBtn;

	@FindBy(xpath = "//a[normalize-space()='Logout']")
	private WebElement logoutBtn;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));

	public void setEmail(String email) {
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}

	public void setPassword(String password) {
		txtPassword.clear();
		txtPassword.sendKeys(password);
	}

	public void clickLoginBtn() {
		loginBtn.click();
	}

	public void clickLogoutBtn() {
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.visibilityOf(logoutBtn)).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("ajaxBusy")));
		wait.until(ExpectedConditions.elementToBeClickable(logoutBtn)).click();
		//logoutBtn.click();
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	
}
