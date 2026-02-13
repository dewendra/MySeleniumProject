package com.procam.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsManager implements ITestListener {

	private static final Logger log=LogManager.getLogger();
	public ExtentSparkReporter sparkReporter;// UI of the report
	public ExtentReports extentReports;// populate common info on the report
	public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();// create test case entries in the report
																				// and update status of the test methods

	@Override
	public void onStart(ITestContext context) {
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
		sparkReporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "/reports/ExtentReport_" + timeStamp + ".html");

		log.info("Extent report path: "+sparkReporter);
		
		sparkReporter.config().setDocumentTitle("Automation Report");// Title of the report
		sparkReporter.config().setReportName("Functional testing");// Name of the report
		sparkReporter.config().setTheme(Theme.DARK);// Theme of the report

		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter);
		extentReports.setSystemInfo("Computer Name", "UAT Test");
		extentReports.setSystemInfo("Enviornment", "QA");
		extentReports.setSystemInfo("Tester Name", "Dewendra Singh");
		extentReports.setSystemInfo("OS", "Window 10");
		extentReports.setSystemInfo("Browser Name", "Chrome");

		ITestListener.super.onStart(context);

	}

	@Override
	public void onTestStart(ITestResult result) {

		String testName = result.getMethod().getMethodName();

		if (result.getParameters().length > 0) {
			testName += " :: " + result.getParameters()[0];
		}

		ExtentTest extentTest = extentReports.createTest(testName);
		test.set(extentTest);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.get().log(Status.PASS, "Test case is passed is " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.get().log(Status.FAIL, "Test case is failed " + result.getName());
		test.get().log(Status.FAIL, result.getThrowable());
		String screenshotPath=ScreenshotUtils.captureScreenshot(result.getMethod().getMethodName());
		log.info("onTestFailure screent shot path: "+screenshotPath);
		if(screenshotPath!=null) {
			try {
				test.get().addScreenCaptureFromPath(screenshotPath);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.get().log(Status.SKIP, "Test case is skiped " + result.getName());
		String screenshotPath=ScreenshotUtils.captureScreenshot(result.getMethod().getMethodName());
		log.info("onTestSkipped screent shot path: "+screenshotPath);
		if(screenshotPath!=null) {
			try {
				test.get().addScreenCaptureFromPath(screenshotPath);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReports.flush();
		ITestListener.super.onFinish(context);
	}

	public static ExtentTest getTest() {
		return test.get();
	}

}
