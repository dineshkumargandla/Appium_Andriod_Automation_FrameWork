package com.automation.mobile.appium.setup;

import com.automation.mobile.appium.utils.utility;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.Properties;

public class AndroidDriverManager {
    Properties properties;
    static DesiredCapabilities capabilities;

    protected static AndroidDriver driver;

    public AndroidDriver getAndroidDriver(String propertyPath) {
        try {
            properties = utility.loadProperties(propertyPath);
            String platformVersion = properties.getProperty("platformVersion");
            String deviceName = properties.getProperty("deviceName");
            String nodeURL = properties.getProperty("nodeURL");
            String appPackage = properties.getProperty("appPackage");
            String appActivity = properties.getProperty("appActivity");
            String platformName = properties.getProperty("platformName");
            String app = properties.getProperty("apkPath");
            String avd = properties.getProperty("avd");
            capabilities = new DesiredCapabilities();
            //capabilities.setCapability("platformVersion", platformVersion);
            capabilities.setCapability("deviceName", deviceName);
            capabilities.setCapability("appPackage", appPackage);
            capabilities.setCapability("appActivity", appActivity);
           // capabilities.setCapability("platformName", platformName);
            //capabilities.setCapability("avd", avd);
            capabilities.setCapability("autoGrantPermissions", "true");
            capabilities.setCapability("app",  app);
            return driver = new AndroidDriver(new URL(nodeURL), capabilities);
//                capabilities.setCapability("unicodeKeyboard", true);
//                capabilities.setCapability("resetKeyboard", true);

        } catch (Exception e) {
            System.out.println("Not able to create Android Driver " + e.getMessage());
        }
        return driver;
    }
}
