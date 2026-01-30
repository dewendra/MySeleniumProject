package com.demo.utils;

import org.openqa.selenium.WebElement;

public class TypingHelper {

	public static void slowTyping(WebElement element, String text, int delayMs) {

		element.clear();
		for (char ch : text.toCharArray()) {
			element.sendKeys(Character.toString(ch));
			try {
				Thread.sleep(delayMs);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
