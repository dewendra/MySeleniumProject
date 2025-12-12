package com.procam.utils;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DropdownHelper {
	WebDriver driver;

	public DropdownHelper(WebDriver driver) {
		this.driver = driver;
	}

	public void selectFromList(List<WebElement> options, String partialText) {
		//partialText = partialText.toLowerCase().trim();
		for (WebElement option : options) {
			if (!option.isEnabled()) {
	            continue;   // skip disabled items
	        }
			String actualText = option.getText().trim();
			if (actualText.contains(partialText)) {
				option.click();
				return;
			}
		}
		throw new RuntimeException("Option not found: " + partialText);

	}
	
	

}
