package com.demo.testng;

import org.testng.annotations.Test;

/*
 1) Open application
 2) Login application
 3) Logout application

 */
public class FirstTestCase {

	@Test(priority = 1)
	public void openApplaction() {
		System.out.println("Opening  Application");

	}
	
	
	@Test(priority = 2)
	public void loginApplaction() {
		System.out.println("Login to Application");
	}
	
	
	@Test(priority = 3)
	public void logoutApplaction() {
		System.out.println("Logout from Application");
	}

}
