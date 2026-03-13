package com.demo.challenge.day5;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MaxPriceTest {

	public static void main(String[] args) {
		double largest = 0;
		double smallest = Double.MAX_VALUE;
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		WebElement loginBtn = driver.findElement(By.xpath("//input[@id='login-button']"));

		userName.sendKeys("standard_user");
		password.sendKeys("secret_sauce");
		loginBtn.click();

		// ----------
		List<WebElement> priceList = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
		System.out.println("Total priceList :" + priceList.size());
		List<Double> priceDoubleList = new ArrayList<Double>();
		for (WebElement price : priceList) {
			String itemprice = price.getText().trim().replace("$", "");
			System.out.println("Price : " + itemprice);
			double actualPrice = Double.parseDouble(itemprice);
			priceDoubleList.add(actualPrice);
			if (largest < actualPrice) {
				largest = actualPrice;
			}
			if (smallest > actualPrice) {
				smallest = actualPrice;
			}
		}
		System.out.println("Price List" + priceDoubleList);
		System.out.println("Largest Price :" + largest);
		System.out.println("Smallest Price :" + smallest);
		String addToCartBtnLargest = "//div[normalize-space()='$" + largest
				+ "']/following-sibling::button[text()='Add to cart']";
		String addToCartBtnSmallest = "//div[normalize-space()='$" + smallest
				+ "']/following-sibling::button[text()='Add to cart']";
		driver.findElement(By.xpath(addToCartBtnLargest)).click();
		driver.findElement(By.xpath(addToCartBtnSmallest)).click();
	}

}
