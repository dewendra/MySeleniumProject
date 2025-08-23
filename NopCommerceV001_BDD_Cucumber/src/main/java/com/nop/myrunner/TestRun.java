package com.nop.myrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/features",
		glue = "com.nop.stepDefinations",
		plugin = {"pretty","html:target/cucumber-reports"},
		monochrome = true,
		dryRun = false,
		publish = true
		
		
		
		)



public class TestRun extends AbstractTestNGCucumberTests {
}
