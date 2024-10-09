package com.hdorRegistrationProcess.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hdorRegistrationProcess.actiondriver.Action;
import com.hdorRegistrationProcess.base.BaseClass;

public class LoginPage extends BaseClass{
	Action action = new Action();
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passWord;
	
	@FindBy(xpath = "//button[text()='login']")
	private WebElement loginButton;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	public DashboardPage passwordlogin(String password)throws Throwable {
		action.type(passWord, password);
		System.out.println("Password entered:"+password);
		Thread.sleep(2000);
		action.click(driver, loginButton);
		System.out.println("Login Button Clicked");
		return new DashboardPage();
	}

}
