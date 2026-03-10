package com.demo.challenge.day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorldPopulation {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		int count = 1;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.worldometers.info/world-population/");

		String current_population = "//div//span[@rel='current_population']";
		String today_population = "//div[normalize-space()='Today'] /following-sibling::div //span[contains(@class,'rts-counter')]";
		String thisYear_population = "//div[normalize-space()='This Year'] /following-sibling::div //span[contains(@class,'rts-counter')]";
		String population = "//div[normalize-space()='Today' or normalize-space()='This Year'] /following-sibling::div //span[contains(@class,'rts-counter')]";
		WebElement population_current = driver.findElement(By.xpath("//div//span[@rel='current_population']"));
		WebElement birth_today = driver.findElement(
				By.xpath("//div[normalize-space()='Today']/following-sibling::div//span[@rel='births_today']"));
		WebElement dath_today = driver.findElement(
				By.xpath("//div[normalize-space()='Today']/following-sibling::div//span[@rel='dth1s_today']"));
		WebElement growth_today = driver.findElement(
				By.xpath("//div[normalize-space()='Today']/following-sibling::div//span[@rel='absolute_growth']"));
		WebElement birth_thisyear = driver.findElement(
				By.xpath("//div[normalize-space()='This Year']/following-sibling::div//span[@rel='births_this_year']"));
		WebElement dath_thisyear = driver.findElement(
				By.xpath("//div[normalize-space()='This Year']/following-sibling::div//span[@rel='dth1s_this_year']"));
		WebElement growth_thisyear = driver.findElement(By.xpath(
				"//div[normalize-space()='This Year']/following-sibling::div//span[@rel='absolute_growth_year']"));

		while (count <= 10) {
			System.out.println(count + "sec");
			System.out.println("Current World Population: " + population_current.getText());
			System.out.println("Birth Today: " + birth_today.getText());
			System.out.println("Dath Today: " + dath_today.getText());
			System.out.println("Growth Today: " + growth_today.getText());
			System.out.println("Birth this year: " + birth_thisyear.getText());
			System.out.println("Dath this year: " + dath_thisyear.getText());
			System.out.println("Growth this year: " + growth_thisyear.getText());
			System.out.println("------------------------------------------------------");

			if (count == 11)
				break;
			System.out.println("Current World Population: ");
			displayPopulation(current_population);
			System.out.println("Today and This year World Population");
			displayPopulation(population);
			System.out.println("------------------------------------------------------");
			Thread.sleep(1000);
			count++;
		}

	}

	public static void displayPopulation(String locator) {

		List<WebElement> populationList = driver.findElements(By.xpath(locator));
		for (WebElement e : populationList) {
			System.out.println(e.getText());
		}
	}

}
