package com.demo.challenge.day4;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.demo.configReader.ConfigPropertyReader;

public class HomePageTest {

	DriverFactory driverFactory;
	ConfigPropertyReader configPropertyReader;
	Properties properties;
	WebDriver driver;
	HomePage homePage;
	
	@BeforeTest
	public void setup() {
		configPropertyReader=new ConfigPropertyReader();
		properties = configPropertyReader.initLanguageProperty("english");
		//System.out.println("Property name is :"+properties);
		driverFactory=new DriverFactory();
		driver=driverFactory.initDriver("chrome", properties);
		homePage=new HomePage(driver);
	}
	
	@Test
	public void headerTest() {
		homePage.getHeaderValue(properties.getProperty("header"));
	}
	
	@Test
	public void contaceTest() {
		homePage.getContactValue(properties.getProperty("contact"));
	}
	
	
	
}
