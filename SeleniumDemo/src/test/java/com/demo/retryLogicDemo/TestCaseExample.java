package com.demo.retryLogicDemo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCaseExample {

	@Test
	public void TestCase01() {
		Assert.assertTrue(false);
	}
	
	@Test
	public void TestCase02() {
		Assert.assertTrue(true);
	}
	
	@Test
	public void TestCase03() {
		Assert.assertTrue(false);
	}
	
	@Test
	public void TestCase04() {
		Assert.assertTrue(true);
	}

}
