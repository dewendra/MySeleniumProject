package com.demo.headless;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessTesting {

	public static void main(String[] args) {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--headless=new");//headless mode of execution
		WebDriver driver=new ChromeDriver(options);//we have to pass the ChromeOptions object in the ChromeDriver
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		String act_title=driver.getTitle();
		if(act_title.equals("Your store")) {
			System.out.println("Test passed");
		}else {
			System.out.println("Test faild");
			
		}
		driver.quit();
		
	}

}
