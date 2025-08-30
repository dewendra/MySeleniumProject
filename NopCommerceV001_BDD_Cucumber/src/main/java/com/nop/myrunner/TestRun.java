package com.nop.myrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = ".//Features/Login.feature",//for run a single feature file
		//features = ".//Features/",//for run all features file
		glue = "com.nop.stepDefinations",
		//plugin = {"pretty","html:target/customer-reports"},
		plugin= {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		monochrome = true,
		dryRun = false,
		publish = true,
		tags = "@sanity"//scenario only execute which comes under sanity tag, we can use or and and and not operator for run more than one tags
		)
// "json:target/cucumber-reports.json" for json report
public class TestRun extends AbstractTestNGCucumberTests {
}
