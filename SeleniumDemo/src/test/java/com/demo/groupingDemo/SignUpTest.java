package com.demo.groupingDemo;

import org.testng.annotations.Test;

public class SignUpTest {

	@Test(priority = 1, groups = { "regression" })
	void signUpByEmail() {
		System.out.println("This is signUp By email.....");
	}

	@Test(priority = 2, groups = { "regression" })
	void signUpByFacebook() {
		System.out.println("This is signUp By Facebook.....");
	}

	@Test(priority = 3, groups = { "regression" })
	void signUpByGmail() {
		System.out.println("This is signUp By Gmail.....");
	}

	@Test(priority = 4, groups = { "regression" })
	void signUpByOTP() {
		System.out.println("This is signUp By OTP.....");
	}

}
