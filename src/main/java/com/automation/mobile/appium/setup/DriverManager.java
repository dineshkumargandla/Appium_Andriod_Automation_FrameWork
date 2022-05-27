package com.automation.mobile.appium.setup;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.Properties;

public class DriverManager {
    static Properties properties;
    public static AndroidDriver driver;
    static DesiredCapabilities capabilities;

    public static WebDriver getDriver(DriverManagerType browserName) throws Exception {
        switch (browserName.getDriver()) {
            case "AndroidDriver":
                String propertyPath = System.getProperty("user.dir") + "//src//main//resources//android.properties";
                return driver = new AndroidDriverManager().getAndroidDriver(propertyPath);

        }
        return null;
    }

    public static void main(String arr[]) throws Exception {
        getDriver(DriverManagerType.ANDROID);
    }


}
