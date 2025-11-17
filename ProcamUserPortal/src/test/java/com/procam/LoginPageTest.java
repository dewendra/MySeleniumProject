package com.procam;

import java.security.PrivateKey;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.procam.base.BaseClass;
import com.procam.pageobjects.LoginPage;

public class LoginPageTest extends BaseClass{
	private LoginPage loginPage;	
	
	@BeforeMethod
	public void setup() {
		launchApp();
	}
	
	@Test
	public void verifyLogin() throws InterruptedException {
		loginPage=new LoginPage();
		loginPage.loginByEmail();
		
	}

}
