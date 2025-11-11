package com.procam;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.procam.base.BaseClass;
import com.procam.pageobjects.AllEventsPage;
import com.procam.pageobjects.LoginPage;

public class LoginTest extends BaseClass{
	LoginPage loginPage;
	AllEventsPage allEventsPage;
	
	@BeforeMethod()
	public void setup() {
		launchApp();
	}
	
	@Test
	public void verifyLogin() {
		loginPage=new LoginPage();
		allEventsPage=loginPage.loginByEmail();
		
		
	}

}
