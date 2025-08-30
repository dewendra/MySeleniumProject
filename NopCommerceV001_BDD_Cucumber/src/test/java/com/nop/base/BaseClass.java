package com.nop.base;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.nop.pageObjects.AddCustomerPage;
import com.nop.pageObjects.LoginPage;
import com.nop.pageObjects.SearchCustomerPage;
import com.nop.utilities.ReadConfig;

public class BaseClass {
	public static WebDriver driver;
	public LoginPage loginPage;
	public AddCustomerPage addCustomerPage;
	public SearchCustomerPage searchCustomerPage;
	public ReadConfig readConfig;
	
	public static Logger log;
	
	public BaseClass() {
        readConfig = new ReadConfig();  // Initialize here
    }
	
	
	public String generateRandomString() {
		String randomString = RandomStringUtils.randomAlphabetic(4);
		return randomString;
		
	}

}
