package com.demo.dependencyDemo;

import org.testng.annotations.Test;

import junit.framework.Assert;

/*
1) Open application
2) Login application
3) Search Text
4) Advance Search Text
5) Logout application

*/
public class DependencyDemo {

	@Test(priority = 1)
	void openApplication() {
		Assert.assertTrue(true);
		System.out.println("Opening  Application");

	}

	@Test(priority = 2, dependsOnMethods = {"openApplication"})
	void loginApplication() {
		Assert.assertTrue(true);

		System.out.println("Login to Application");

	}

	@Test(priority = 3, dependsOnMethods = {"loginApplication"})
	void search() {
		Assert.assertTrue(false);

		System.out.println("Searching the actual text");

	}

	@Test(priority = 4, dependsOnMethods = {"loginApplication","search"})
	void advSearch() {
		Assert.assertTrue(true);

		System.out.println("Advance Searching the actual text");

	}

	@Test(priority = 5, dependsOnMethods = {"loginApplication"})
	void logout() {
		Assert.assertTrue(true);

		System.out.println("Logout from Application");

	}
}
