package com.hdor.reports;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hdor.reports.base.BaseClass;
import com.hdor.reports.pageobjects.HomePage;

public class HomePageTest extends BaseClass{
	private HomePage homePage;
	
	@BeforeMethod()
	public void setup() {
		launchApp();
	}
	@Test
	public void searchEvent() throws Throwable {
		homePage=new HomePage();
		homePage.searchEvent();
	}

}
