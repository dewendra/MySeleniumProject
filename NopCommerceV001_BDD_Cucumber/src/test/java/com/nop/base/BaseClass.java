package com.nop.base;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import com.nop.pageObjects.AddCustomerPage;
import com.nop.pageObjects.LoginPage;
import com.nop.pageObjects.SearchCustomerPage;

public class BaseClass {
	public WebDriver driver;
	public LoginPage loginPage;
	public AddCustomerPage addCustomerPage;
	public SearchCustomerPage searchCustomerPage;
	
	public String generateRandomString() {
		String randomString = RandomStringUtils.randomAlphabetic(4);
		return randomString;
		
	}

}
