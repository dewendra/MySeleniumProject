package com.procam.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

	private static final Logger log = LogManager.getLogger();

	public static String captureScreenshot(String testName) {

		WebDriver driver = DriverFactory.getDriver();

		if (driver == null) {
			log.warn("Driver is NULL. Screenshot not captured.");
			return null;
		}

		String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
		String screenshotDir = System.getProperty("user.dir") + "/screenshots/";
		String screenshotPath = screenshotDir + testName + "_" + timeStamp + ".png";

		try {
			// Create directory if not exists
			File dir = new File(screenshotDir);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File destFile = new File(screenshotPath);
			FileUtils.copyFile(srcFile, destFile);
		} catch (Exception e) {
			log.error("Failed to capture screenshot", e);
		}
		log.info("screenshots dir : " + screenshotDir);
		log.info("screenshots path : " + screenshotPath);

		return screenshotPath;

	}

}
