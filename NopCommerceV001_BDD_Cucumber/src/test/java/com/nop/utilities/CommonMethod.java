package com.nop.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CommonMethod {
	WebDriver driver;

	public CommonMethod(WebDriver driver) {
		this.driver = driver;
	}

	public String takeScreenshots(String scenarioName) {
		try {
			String dateTime = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
			String fileName = scenarioName + "_" + dateTime + ".png";

			// Absolute path for saving
			String screenshotPath = System.getProperty("user.dir") + "/screenshots/" + fileName;
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			// byte[] screenshots = screenshot.getScreenshotAs(OutputType.BYTES);
			// String screenshotAs = screenshot.getScreenshotAs(OutputType.BASE64);

			File destFile = new File(screenshotPath);
			FileUtils.copyFile(srcFile, destFile);

			// Relative path for report linking
			return "screenshots/" + fileName;

		} catch (Exception e) {
		}
		return null;

	}

}
