package com.demo.groupingDemo;

import org.testng.annotations.Test;

public class PaymentTest {
	@Test(priority = 1, groups = { "sanity", "regression", "functional" })
	void paymentByNetbanking() {
		System.out.println("Paymnet By Net Banking....");
	}

	@Test(priority = 2, groups = { "sanity", "regression", "functional" })
	void paymentBycard() {
		System.out.println("Paymnet By Card....");
	}

	@Test(priority = 3, groups = { "sanity", "regression", "functional" })
	void paymentByWallet() {
		System.out.println("Paymnet By Wallet....");
	}

	@Test(priority = 4, groups = { "sanity", "regression", "functional" })
	void paymentByUPI() {
		System.out.println("Paymnet By UPI....");
	}

}
