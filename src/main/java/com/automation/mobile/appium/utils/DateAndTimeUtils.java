package com.automation.mobile.appium.utils;

import java.time.LocalDate;
import java.time.LocalTime;

import org.apache.commons.lang3.StringUtils;

public class DateAndTimeUtils {

    public static LocalDate getDate(){
        return java.time.LocalDate.now();
    }

    public static String getCurrentTimeModified(){
        String time = java.time.LocalTime.now().toString();
        String getCurrentTime = StringUtils.substringBefore(time, ".").replace(":","-");
        return getCurrentTime;
    }

    public static LocalTime getCurrentTime(){
        return java.time.LocalTime.now();
    }
}
