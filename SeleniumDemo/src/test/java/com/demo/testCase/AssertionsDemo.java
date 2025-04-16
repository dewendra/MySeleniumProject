package com.demo.testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionsDemo {
	@Test
	void test_title() {
		String exp_title="opencart";
		String act_title="openshop";
		/*
		 * if (exp_title.equals(act_title)) { System.out.println("Test pass"); }else {
		 * System.out.println("Test fail"); }
		 */
			Assert.assertEquals(exp_title, act_title);	
	}

}
