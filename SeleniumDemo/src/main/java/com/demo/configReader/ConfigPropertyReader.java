package com.demo.configReader;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigPropertyReader {

	private Properties properties;
	private FileInputStream fileInputStream;

	
	
	public Properties initLanguageProperty(String language) {
		
		//mvn clean install -Dlang="french"
		//String language=System.getProperty("lang");
		
		System.out.println("Langauge : " + language);
		properties = new Properties();

		try {
			switch (language.toLowerCase()) {
			case "english": {
				fileInputStream = new FileInputStream(
					    System.getProperty("user.dir") + "/src/test/resources/language.english.properties"
						);
				break;
			}
			case "french": {
				fileInputStream = new FileInputStream(
					    System.getProperty("user.dir") + "/src/test/resources/language.french.properties"
						);
				break;
			}
			case "russian": {
				fileInputStream = new FileInputStream(
					    System.getProperty("user.dir") + "/src/test/resources/language.russian.properties"
						);
				break;
			}
			default:
				System.out.println("Unknown Language: " + language.toLowerCase());
				break;
			}
			
			properties.load(fileInputStream);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return properties;
	}
}
