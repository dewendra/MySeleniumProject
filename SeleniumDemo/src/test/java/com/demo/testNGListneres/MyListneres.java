package com.demo.testNGListneres;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListneres implements ITestListener {

	@Override
	public void onStart(ITestContext context) {
		System.out.println("On start...........Test Execution is Started");
		ITestListener.super.onStart(context);
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("On Test Started..............");
		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("On Test Successed..............");
		ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("On Test Skipped................");
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("On Test Faild.........................");
		ITestListener.super.onTestFailure(result);
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test is finished..................");
		ITestListener.super.onFinish(context);
	}
}
