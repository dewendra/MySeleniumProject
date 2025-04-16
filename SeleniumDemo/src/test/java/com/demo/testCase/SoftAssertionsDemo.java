package com.demo.testCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionsDemo {

	
	void hardAssertions() {
		System.out.println("Testing...........");
		System.out.println("Testing...........");
		//Assert.assertEquals(123, 456);//faild
		
		
		System.out.println("Testing...........");
	}
	@Test
	void softAssertions() {
		System.out.println("Testing...........");
		System.out.println("Testing...........");
		
		//Soft Assertion
		
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertEquals(123, 456);
		
		System.out.println("Testing...........");
		
		softAssert.assertAll();//this method is mandatory when you use soft assertion
	}
}
