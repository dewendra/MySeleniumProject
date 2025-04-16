package com.demo.testNGListneres;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsManager implements ITestListener{
	
	public ExtentSparkReporter sparkReporter;//UI of the report
	public ExtentReports extentReports;//populate common info on the report
	public ExtentTest test;//create test case entries in the report and update status of the test methods
	
	@Override
	public void onStart(ITestContext context) {
		sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/myReport.html");//specify the path of the report
		sparkReporter.config().setDocumentTitle("Automation Report");//Title of the report
		sparkReporter.config().setReportName("Functional testing");//Name of the report
		sparkReporter.config().setTheme(Theme.DARK);//Theme of the report
		
		extentReports=new ExtentReports();
		extentReports.attachReporter(sparkReporter);
		extentReports.setSystemInfo("Computer Name", "localhost");
		extentReports.setSystemInfo("Enviornment", "OA");
		extentReports.setSystemInfo("Tester Name", "Dewendra Singh");
		extentReports.setSystemInfo("OS", "Window 10");
		extentReports.setSystemInfo("Browser Name", "Chrome");
		
		ITestListener.super.onStart(context);
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		test=extentReports.createTest(result.getName());//create a new entry in the report
		test.log(Status.PASS, "Test Case passed is"+result.getName());//update status of p/f/s
		ITestListener.super.onTestSuccess(result);
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		test=extentReports.createTest(result.getName());//create a new entry in the report
		test.log(Status.FAIL, "Test Case Faild is"+result.getName());//update status of p/f/s
		test.log(Status.FAIL, "Test Case Faild the cause is"+result.getThrowable());//update status of p/f/s
		ITestListener.super.onTestFailure(result);
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		test=extentReports.createTest(result.getName());//create a new entry in the report
		test.log(Status.SKIP, "Test Case Skipped is"+result.getName());//update status of p/f/s
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReports.flush();
		ITestListener.super.onFinish(context);
	}
}
