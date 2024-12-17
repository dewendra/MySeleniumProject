package com.demo.alert;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthenticationPopup {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		//username and password has been sen in url
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//WebDriverWait mywait=new WebDriverWait(driver, Duration.ofSeconds(10));
	}

}
