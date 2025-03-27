package com.demo.testCase;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class AnnotationDemo4 {
	@AfterTest
	public void closeApplaction() {
		System.out.println("Closing  Application");

	}
	@Test(priority=2)
	public void logoutApplaction() {
		System.out.println("Logout from Application");
	}

}
