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

	public void takeScreenshots(String scenarioName) {
		try {
			TakesScreenshot screenshot = (TakesScreenshot) driver;

			// getScreenshotsAs method calling from TakeScreenshot interface
			File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

			// Create folder if not exists
			String folderPath = System.getProperty("user.dir") + "/screenshots/";
			new File(folderPath).mkdirs();
			File savedLoaction = new File("D:\\SeleniumWorkspace\\screenShots\\fullPage.png");

			// Unique filename with timestamp
			String timestamp = new SimpleDateFormat("HHmmss_ddMMyyyy").format(new Date());
			File destFile = new File(folderPath + scenarioName + "_" + timestamp + ".png");

			FileUtils.copyFile(srcFile, destFile);
			System.out.println("Screenshot saved at: " + destFile.getAbsolutePath());
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
