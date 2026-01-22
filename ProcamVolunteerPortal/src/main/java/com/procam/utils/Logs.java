package com.procam.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logs {
	
	private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	public static void info(String message) {
		String time = LocalDateTime.now().format(FORMATTER);
        System.out.println(time + "  INFO: " + message);

	}

	public static void error(String message) {
		String time = LocalDateTime.now().format(FORMATTER);
        System.out.println(time + "  ERROR: " + message);
	}

}
