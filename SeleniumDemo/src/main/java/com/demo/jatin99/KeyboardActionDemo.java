package com.demo.jatin99;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class KeyboardActionDemo {

	public static void main(String[] args) {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		chromeOptions.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		chromeOptions.setExperimentalOption("useAutomationExtension", false);
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.get("https://automationteststore.com/");

	}

}
