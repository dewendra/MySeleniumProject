package com.demo.testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertionsDemo {
	@Test
	void testAssertions() {

		//Assert.assertEquals(123, 123);//passed
		//Assert.assertEquals("123", 123);//failed
		//Assert.assertEquals("Rahul", "Rahul");//passed
		//Assert.assertEquals("Rahul", "Rohit");//failed
		//Assert.assertEquals("Rahul", 123);//failed
		
		
		//Assert.assertNotEquals(123,123);//failed
		//Assert.assertNotEquals(123,456);//passed
		
		
		//Assert.assertTrue(true);//passed
		//Assert.assertTrue(false);//failed
		//Assert.assertTrue(1==2);//failed
		
		//Assert.assertFalse(false);//passed
		//Assert.assertFalse(true);//failed
		
		Assert.fail();//directly fail the method no need any validation
		
	}

}
