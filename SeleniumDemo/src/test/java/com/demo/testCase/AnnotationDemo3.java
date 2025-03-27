package com.demo.testCase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationDemo3 {
	@BeforeTest
	public void openApplaction() {
		System.out.println("Opening  Application");

	}
	@Test(priority=1)
	public void loginApplaction() {
		System.out.println("Login to Application");
	}
	

}
