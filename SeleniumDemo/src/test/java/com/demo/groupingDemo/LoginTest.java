package com.demo.groupingDemo;

import org.testng.annotations.Test;

public class LoginTest {
	@Test(priority = 1, groups = { "sanity" })
	void LoginByEmail() {
		System.out.println("This is login By email.....");
	}

	@Test(priority = 2, groups = { "sanity" })
	void LoginByFacebook() {
		System.out.println("This is login By Facebook.....");
	}

	@Test(priority = 3, groups = { "sanity" })
	void LoginByGmail() {
		System.out.println("This is login By Gmail.....");
	}

	@Test(priority = 4, groups = { "sanity" })
	void LoginByOTP() {
		System.out.println("This is login By OTP.....");
	}

}
