package com.demo.table;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicPaginationWebTable {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo-opencart.com/admin/index.php?route=common/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// enter username and password
		driver.findElement(By.xpath("//input[@id='input-username']")).sendKeys("demo");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("demo");
		driver.findElement(By.xpath("//button[contains(.,'Login')]")).click();
		// closed the pop up
		if (driver.findElement(By.xpath("//button[@class='btn-close']")).isDisplayed()) {
			driver.findElement(By.xpath("//button[@class='btn-close']")).click();
		}
		// click on Customer menu
		driver.findElement(By.xpath("//a[@href='#collapse-5']")).click();
		// click on Customer sub menu
		driver.findElement(By.xpath("//ul//li/a[text()='Customers']")).click();

		// capture the number of pages
		// Showing 1 to 10 of 2147 (215 Pages)
		String text = driver.findElement(By.xpath("//div[contains(text(),'Pages')]")).getText();
		int numberOfPages = Integer.parseInt(text.substring(text.indexOf("(") + 1, text.indexOf("Pages") - 1));
		System.out.println(numberOfPages);
//		Thread.sleep(5000);
//		WebElement activePage1=driver.findElement(By.xpath("//ul[@class='pagination']//*[text()='3']"));
//		activePage1.click();
		// repeating pages

		//For edit a record
		//driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr[1]/td[6]//a/i[@class='fa-solid fa-pencil']")).click();
		//For dropdown a record
		driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr[1]/td[6]//button/span[contains(@class,'fa-solid fa-caret-down')]")).click();
				
		
		
		/*
		 * for (int p = 1; p <= 5; p++) { if (p > 1) { Thread.sleep(3000); WebElement
		 * activePage =
		 * driver.findElement(By.xpath("//ul[@class='pagination']//*[text()="+p+"]"));
		 * System.out.println(activePage.getText()); activePage.click(); } // reading
		 * data from the active page Thread.sleep(3000); int
		 * rows=driver.findElements(By.
		 * xpath("//table[@class='table table-bordered table-hover']//tbody//tr")).size(
		 * ); for(int r=1;r<=rows; r++) { String customerName=driver.findElement(By.
		 * xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+
		 * "]/td[2]")).getText(); String customerEmail=driver.findElement(By.
		 * xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+
		 * "]/td[3]")).getText(); System.out.println(customerName+"\t"+customerEmail);
		 * Thread.sleep(1000); } }
		 */

	}

}
