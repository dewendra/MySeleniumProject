package com.demo.testCase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
 1) login @BeforeMethod
 2) Search --@Test
 3) Logout @AfterMethod
 4) Login-- @BeforeMethod
 5) Adv. Search --@Test
 6) Logout @AfterMethod
 */
 
public class AnnotationDemo {
	
	@BeforeMethod
	public void login() {
		System.out.println("Login into  Application");
	}
	
	@Test(priority=1)
	public void search() {
		System.out.println("Searching the actual text");
	}
	@AfterMethod
	public void logout() {
		System.out.println("Logout from Application");
	}
	@Test(priority=2)
	public void advSearch() {
		System.out.println("Advance Searching the actual text");
	}
}
