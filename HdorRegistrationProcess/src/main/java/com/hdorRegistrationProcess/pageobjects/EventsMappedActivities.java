package com.hdorRegistrationProcess.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hdorRegistrationProcess.actiondriver.Action;
import com.hdorRegistrationProcess.base.BaseClass;

public class EventsMappedActivities extends BaseClass {
	Action action=new Action();
	@FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-container css-v3z1wi']//div//h6")
	private WebElement findingTotalPointsDiv;
	
	@SuppressWarnings("static-access")
	List<WebElement>allPoints=action.getDriver().findElements(By.xpath("//div[@class='MuiGrid-root MuiGrid-container css-v3z1wi']//div//h6"));
	
	public EventsMappedActivities() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void printWebElementList() throws InterruptedException {
		Thread.sleep(5000);
		System.out.println("In printWebElementList");
		for(int i=0;i<allPoints.size();i++) {
			System.out.println("Value : "+allPoints.get(i).getText());
		}
	}

}
