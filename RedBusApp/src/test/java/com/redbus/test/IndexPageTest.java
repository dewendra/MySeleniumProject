package com.redbus.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.redbus.actiondriver.Action;
import com.redbus.base.BaseClass;
import com.redbus.pageobjects.IndexPage;

public class IndexPageTest extends BaseClass {
	
	Action action = new Action();
	private IndexPage indexPage;
	
	@BeforeMethod
	public void setup() {
		launchApp();
	}
	//@Test(priority=1)
	public void verifiyLogo() throws Throwable {
		indexPage=new IndexPage();
		boolean result=indexPage.validateLogo();
		Assert.assertTrue(result);
		
	}
	@Test(priority=2)
	public void enterDetails() throws InterruptedException {
		indexPage=new IndexPage();
		indexPage.enterdetails();
		
		//indexPage.clickOnDate();
		
	}
	
	
	
	
	
	
	
	//@AfterMethod
	public void traeDown() {
		getDriver().quit();
	}

}
