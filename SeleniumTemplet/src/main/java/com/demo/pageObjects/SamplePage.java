package com.demo.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SamplePage {
	
	@FindBy(xpath = "")
	WebElement element;
	
	
	public SamplePage() {
		//you can define your constructor here
	}

	public void enterLoginDetails() {
		//you can write here login page logic for entering the details.
	}
}
