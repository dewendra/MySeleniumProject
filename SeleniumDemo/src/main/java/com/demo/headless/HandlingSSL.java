package com.demo.headless;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandlingSSL {

	public static void main(String[] args) {
		ChromeOptions options=new ChromeOptions();
		options.setAcceptInsecureCerts(true);//accept ssl certificate
		WebDriver driver=new ChromeDriver(options);//we have to pass the ChromeOptions object in the ChromeDriver
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://expired.badssl.com/");
		String act_title=driver.getTitle();
		System.out.println("Title of the webPage : "+act_title);//privacy error

	}

}
