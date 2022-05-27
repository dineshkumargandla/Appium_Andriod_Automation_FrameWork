package com.automation.mobile.appium.utils;

import org.apache.log4j.Logger;

public class Logs {

    private static final Logger LOGGER = Logger.getLogger(Logs.class.getName());

    public static void startTestcase(String testcaseName) {
        LOGGER.info("-----------------------------------------");
        LOGGER.info("**********  Starting Test Case of \"" + testcaseName + "\"  ************\n");
    }

    public static void endTestcase(String testcaseName) {
        LOGGER.info("**********  End of Test Case: \"" + testcaseName + "\"  ************\n");
        LOGGER.info("-----------------------------------------\n");
    }

    public static void info(String message) {
        LOGGER.info(message+"\n");
    }

    public static void warn(String message) {
        LOGGER.warn(message + "\n");
    }

    public static void error(String message) {
        LOGGER.error(message+"\n");
    }

    public static void debug(String message) {
        LOGGER.debug(message+"\n");
    }
}
