package com.demo.testCase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/*
1) login @BeforeClass
2) Search --@Test
3) Logout @AfterClass
4) Adv. Search --@Test
 
*/

public class AnnotationDemo5 {

	
	@BeforeSuite
	public void login() {
		System.out.println("Login into  Application");
	}
	
	@Test(priority=1)
	public void search() {
		System.out.println("Searching the actual text");
	}
	@AfterSuite
	public void logout() {
		System.out.println("Logout from Application");
	}
	@Test(priority=2)
	public void advSearch() {
		System.out.println("Advance Searching the actual text");
	}


}
