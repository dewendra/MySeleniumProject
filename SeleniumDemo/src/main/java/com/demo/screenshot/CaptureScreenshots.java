package com.demo.screenshot;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureScreenshots {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		Thread.sleep(3000);
		//1)capture full page screenshot
		TakesScreenshot screenshot=(TakesScreenshot) driver;
		File file = screenshot.getScreenshotAs(OutputType.FILE);//here we call the getScreenshotsAs method calling from TakeScreenshot interface
		File savedLoaction=new File("D:\\SeleniumWorkspace\\screenShots\\fullPage.png");
		File savedLoaction2=new File(System.getProperty("user.dir")+"\\screenShots\\fullPage.png");//return project location directly
		file.renameTo(savedLoaction);//copy file to location
		file.renameTo(savedLoaction2);//copy file to location
		
		//2)capture a section of a page
		WebElement featuredProduct=driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']//div[@class='item-grid']"));
		File sourceFile=featuredProduct.getScreenshotAs(OutputType.FILE);//here we call the getScreenshotsAs method through webElement
		File targetFile=new File(System.getProperty("user.dir")+"\\screenShots\\featuredProduct.png");//return project location directly
		sourceFile.renameTo(targetFile);//copy file to location
		
		//3) capture screenshot of a specific webElement
		WebElement specificWebElement=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		File sourceFile1=specificWebElement.getScreenshotAs(OutputType.FILE);//here we call the getScreenshotsAs method through webElement
		File targetFile1=new File(System.getProperty("user.dir")+"\\screenShots\\specificWebElement.png");//return project location directly
		sourceFile1.renameTo(targetFile1);//copy file to location
		
		
		
	}

}
