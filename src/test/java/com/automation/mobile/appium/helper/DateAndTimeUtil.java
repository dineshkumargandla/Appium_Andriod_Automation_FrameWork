package com.automation.mobile.appium.helper;

public class DateAndTimeUtil {
    protected static ThreadLocal <String> dateTime = new ThreadLocal<String>();
    public static String getDateTime() {
        return dateTime.get();
    }
}
