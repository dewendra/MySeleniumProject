package com.yatra.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.yatra.baseClass.BaseClass;
import com.yatra.pageObjects.IndexPage;

public class IndexPageTest extends BaseClass{
	
	private IndexPage indexPage;
	
	@BeforeMethod
	public void setUp() {
		launchApp();
	}
	@Test
	public void verifiyLogo() throws InterruptedException {
		indexPage=new IndexPage();
		indexPage.closeThePopUp();
		boolean result = indexPage.validateLogo();
		Assert.assertTrue(result, "Logo verified.......");
		indexPage.clickOnDepartureDate();
	}

}
