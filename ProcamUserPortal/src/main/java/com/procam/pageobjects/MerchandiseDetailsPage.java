package com.procam.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.procam.actiondriver.Action;
import com.procam.base.BaseClass;
import com.procam.utils.DriverFactory;
import com.procam.utils.WaitHelper;

public class MerchandiseDetailsPage extends BaseClass{
	
	Action action;
	WaitHelper wait;
	
	@FindBy(xpath = "")
	private WebElement element;
	
	public MerchandiseDetailsPage() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
		wait=new WaitHelper(DriverFactory.getDriver());
	}
	
	public void enterMerchandiseDetails() {
		
	}

}
