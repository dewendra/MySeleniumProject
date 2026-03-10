package com.demo.challenge.day4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.demo.utils.ElementUtil;

public class HomePage {

	private WebDriver driver;
	
	private ElementUtil elementUtil;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	private WebElement getHeaderElement(String headerValue) {
		String headerXpath = "//a[contains(text(),'"+headerValue+"')]";
		return elementUtil.getElement("xpath", headerXpath);
	}

	private WebElement getContactElement(String contactValue) {
		String contactXpath = "//a[contains(text(),'"+contactValue+"')]";
		return elementUtil.getElement("xpath", contactXpath);
	}
	
	
	public void getHeaderValue(String header) {
		String headerValue =getHeaderElement(header).getText();
		System.out.println("Header Value :"+headerValue);
	}
	
	public void getContactValue(String contact) {
		String contactValue= getContactElement(contact).getText();
		System.out.println("Contact Value : "+contactValue);
	}
	
}
