package com.automation.mobile.appium.utils;

import java.time.LocalDate;

import org.apache.commons.lang3.StringUtils;

public class DateAndTimeUtils {

    public static LocalDate getDate(){
        return java.time.LocalDate.now();
    }

    public static String getCurrentTime(){
        String time = java.time.LocalTime.now().toString();
        String getCurrentTime = StringUtils.substringBefore(time, ".").replace(":","-");
        return getCurrentTime;
    }
}
