package com.demo.navigations;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleBrowserWindows {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//added implicit wait
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
		//taking the window handles
		Set<String>windowsIds=driver.getWindowHandles();
		System.out.println("Windows id:" +windowsIds);

		
		//Approch one convert set inot list collection
		/*
		 * List<String> windowList=new ArrayList<String>(windowsIds); String
		 * parentId=windowList.get(0);//return parent id String
		 * childId=windowList.get(1);//return child id System.out.println("Parent id:"
		 * +parentId); System.out.println("Child id:" +childId);
		 */
		//switch back to the parent window
		//driver.switchTo().window(parentId);
		//Approch two looping statement
		for(String winid:windowsIds) {
			String title=driver.switchTo().window(winid).getTitle();
			if(title.equals("OrangeHRM")) {
				System.out.println(driver.getCurrentUrl());
			}
		}

	}

}
