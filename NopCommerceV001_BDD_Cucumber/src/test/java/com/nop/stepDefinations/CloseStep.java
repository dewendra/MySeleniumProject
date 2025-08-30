package com.nop.stepDefinations;

import com.nop.base.BaseClass;

import io.cucumber.java.en.Then;

public class CloseStep extends BaseClass {

	@Then("close browser")
	public void close_browser() {

		driver.quit(); // closes all browser windows & ends session
		log.info("Browser closed successfully.");
	}

}
