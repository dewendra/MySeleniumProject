package com.dynamic.moneycontrol;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TableSortTest {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		List<String> uiNames = UiUtilsExample.getNamesFromWebTable(driver);
		List<String> apiNames = ApiUtilsDataExample.getSortedListFromAPI();

		Assert.assertEquals(uiNames, apiNames, "UI and API sorted data do not match!");

	}

}
