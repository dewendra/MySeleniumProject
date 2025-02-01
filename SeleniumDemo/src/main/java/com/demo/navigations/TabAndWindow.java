package com.demo.navigations;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class TabAndWindow {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		driver.switchTo().newWindow(WindowType.TAB);//opens new tab
		driver.get("https://www.orangehrm.com/");
		driver.switchTo().newWindow(WindowType.WINDOW);//open new window
		driver.get("http://www.automationpractice.pl/index.php");

	}

}
