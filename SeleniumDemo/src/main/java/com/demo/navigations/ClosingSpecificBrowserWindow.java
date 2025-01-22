package com.demo.navigations;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClosingSpecificBrowserWindow {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//added implicit wait
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
		//taking the window handles
		Set<String>windowsIds=driver.getWindowHandles();
		System.out.println("Windows id:" +windowsIds);

		
		
		//Approch one looping statement
		for(String winId:windowsIds) {
			String title=driver.switchTo().window(winId).getTitle();
			System.out.println(title);
			if(title.equals("OrangeHRM")) {
				System.out.println(driver.getCurrentUrl());
				driver.close();
				break;
				
			}
		}

	}

}
