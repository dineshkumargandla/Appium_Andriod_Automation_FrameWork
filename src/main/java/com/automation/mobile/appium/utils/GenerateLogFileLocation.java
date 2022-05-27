package com.automation.mobile.appium.utils;

import java.io.*;
import java.util.Properties;

import static com.automation.mobile.appium.utils.ConfigurationPropertyReader.getLoggingDirectory;
import static com.automation.mobile.appium.utils.ConfigurationPropertyReader.getProjectName;

public class GenerateLogFileLocation {
    static String propertyPath = System.getProperty("user.dir") + "//src//main//resources//android.properties";
    static Properties properties = utility.loadProperties(propertyPath);
    static File filePath = new File(getLoggingDirectory()+File.separator+ ConfigurationPropertyReader.getProductVersion()+"."+ConfigurationPropertyReader.getProductBuild()+ File.separator + properties.getProperty("platformName")
           + "_" +properties.getProperty("deviceName") + File.separator + DateAndTimeUtils.getDate() +File.separator + DateAndTimeUtils.getCurrentTimeModified() + File.separator
           + getProjectName()+ "_LogFile.log");


        public static void updateLogFilepath() throws IOException {

            FileInputStream in = new FileInputStream("src/main/resources/log4j.properties");
            Properties props = new Properties();
            props.load(in);
            in.close();

            FileOutputStream out = new FileOutputStream("src/main/resources/log4j.properties");
            props.setProperty("log4j.appender.file.File", filePath.toString().replace("\\","/"));
            props.store(out, null);
            out.close();
        }
}
