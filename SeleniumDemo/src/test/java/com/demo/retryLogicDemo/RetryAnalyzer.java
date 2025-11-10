package com.demo.retryLogicDemo;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	private int retryCount = 0;
	private static final int maxRetryCount = 2; // retry up to 2 times

	@Override
	public boolean retry(ITestResult result) {
		if (retryCount < maxRetryCount) {
			retryCount++;
			System.out.println("Retrying Test "+result.getName() +" again | Retry count"+retryCount);
			return true;// re-run test

		}
		return false;// stop retrying
	}

}
