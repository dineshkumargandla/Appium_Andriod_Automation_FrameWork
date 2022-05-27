package com.automation.mobile.appium.utils;

import org.apache.log4j.Logger;

public class Logs {
    private static final Logger LOGGER = Logger.getLogger(Logs.class.getName());
    static String dateAndTime = "[ "+ DateAndTimeUtils.getDate() + " , " +DateAndTimeUtils.getCurrentTime() + "]  ";
    public static void startTestcase(String testcaseName) {
        LOGGER.info("---------------------------------------------------------------------------------------\n");
        LOGGER.info("**********  Starting Test Case of \"" + testcaseName + "\"  ************\n");
    }

    public static void endTestcase(String testcaseName) {
        LOGGER.info("---------------------------------------------------------------------------------------\n");
        LOGGER.info("**********  End of Test Case: \"" + testcaseName + "\"  ************\n");
        LOGGER.info("---------------------------------------------------------------------------------------\n");
    }

    public static void info(String message) {
        LOGGER.info( dateAndTime + ": " +message+"\n");
    }

    public static void warn(String message) {
        LOGGER.warn(dateAndTime + ": " +message + "\n");
    }

    public static void error(String message) {
        LOGGER.error(dateAndTime + ": "+message+"\n");
    }

    public static void debug(String message) {
        LOGGER.debug(dateAndTime + ": " +message+"\n");
    }
}
