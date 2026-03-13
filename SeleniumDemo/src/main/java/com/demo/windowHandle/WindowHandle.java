package com.demo.windowHandle;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {

	static WebDriver driver = new ChromeDriver();

	public static void main(String[] args) throws InterruptedException {
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		String parentWindow = driver.getWindowHandle();
		Thread.sleep(5000);
		WebElement linkedIn = driver.findElement(By.xpath("//a[contains(@href,'linkedin.com')]"));
		WebElement facebook = driver.findElement(By.xpath("//a[contains(@href,'facebook.com')]"));
		WebElement twitter = driver.findElement(By.xpath("//a[contains(@href,'twitter.com')]"));
		WebElement youtube = driver.findElement(By.xpath("//a[contains(@href,'youtube.com')]"));

		facebook.click();
		linkedIn.click();
		twitter.click();
		youtube.click();

		Set<String> windowHandles = driver.getWindowHandles();
		List<String> handleList = new ArrayList<String>(windowHandles);
		if (switchToRightWindow("LinkedIn", handleList)) {
			System.out.println(driver.getCurrentUrl() + ":" + driver.getTitle());
		}

		driver.switchTo().window(parentWindow);
	}

	public void swithcToParentWindow(String parentWindow) {
		driver.switchTo().window(parentWindow);
	}

	public static boolean switchToRightWindow(String windowTitle, List<String> handleList) throws InterruptedException {
		for (String window : handleList) {
			String currentWindowTitle = driver.switchTo().window(window).getTitle();
			if (currentWindowTitle.contains(windowTitle)) {
				System.out.println("Found the right window....");
				Thread.sleep(3000);
				return true;
			}
		}
		return false;

	}

}
