package com.demo.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logs {
	
    private static final Logger logger = LogManager.getLogger();

	//private static final DateTimeFormatter FORMATTER =
            //DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	public static void info(String message) {
		//String time = LocalDateTime.now().format(FORMATTER);
        //System.out.println(time + "  INFO: " + message);
        logger.info(message);
	}
	
	public static void debug(String message) {
		//String time = LocalDateTime.now().format(FORMATTER);
        //System.out.println(time + "  DEBUG: " + message);
        logger.debug(message);
	}
	
	public static void warn(String message) {
		//String time = LocalDateTime.now().format(FORMATTER);
        //System.out.println(time + "  WARN: " + message);
        logger.warn(message);
	}

	public static void error(String message, Throwable t) {
		//String time = LocalDateTime.now().format(FORMATTER);
        //System.out.println(time + "  ERROR: " + message);
        logger.error(message,t);
	}
	
	public static void fatal(String message) {
		//String time = LocalDateTime.now().format(FORMATTER);
        //System.out.println(time + "  FATAL: " + message);
        logger.fatal(message);
	}

	

}
