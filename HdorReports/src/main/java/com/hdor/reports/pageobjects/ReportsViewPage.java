package com.hdor.reports.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hdor.reports.actiondriver.Action;
import com.hdor.reports.base.BaseClass;

public class ReportsViewPage extends BaseClass {
	Action action = new Action();
	@FindBy(xpath = "//h6[@class='MuiTypography-root MuiTypography-h6 css-1r81vhm']")
	private WebElement eventName;

	public ReportsViewPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	
	
	public void checkEventName() {
		
	}
	
	
}
