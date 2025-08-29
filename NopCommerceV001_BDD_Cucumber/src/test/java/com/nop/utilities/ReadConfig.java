package com.nop.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties properties;

	
	public  ReadConfig() {
		try {
			properties = new Properties();
			FileInputStream file = new FileInputStream("config.properties");
			properties.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getBrowser() {

		String value = properties.getProperty("browser");
		if (value != null)

			return value;
		else
			throw new RuntimeException("Browser not specified in config file.");

	}

}
