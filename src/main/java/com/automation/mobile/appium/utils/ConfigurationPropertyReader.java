package com.automation.mobile.appium.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class ConfigurationPropertyReader {

    private static final String filepath = "src/test/resources/config.properties";
    private static HashMap<String, String> propertyMap;

    public static String getPropValue(String name) {
        if (null == propertyMap) {
            init();
        }
        String value = propertyMap.get(name);
        if (null == value || value.equals("")) {
            throw new IllegalStateException(name + " is not defined in config.properties file.");
        } else
            return value.trim();
    }

    public static String getScreenOutDir() {
        if (getPropValue("screen.outdir").equals("")) {
            StringBuilder sb = new StringBuilder(System.getProperty("user.dir"));
            sb.setLength(sb.indexOf(String.valueOf(File.separatorChar)) + 1);
            sb.append("screens");
            return sb.toString();
        } else {
            return getPropValue("screen.outdir");
        }
    }

    public static String getDataDir() {
        if (getPropValue("datafile.dir").isEmpty()) {
            throw new IllegalStateException("Input Data directory is not set in config.properties.");
        } else {
            return getPropValue("datafile.dir");
        }
    }

    public static String getDeviceName() {
        if (getPropValue("device.name").isEmpty()) {
            throw new IllegalStateException("Emulator Device not set in config.properties.");
        } else {
            return getPropValue("device.name");
        }
    }


    public static String getProductName() {
        if (getPropValue("product.name").isEmpty()) {
            throw new IllegalStateException("Product Name is not set in config.properties.");
        } else {
            return getPropValue("product.name");
        }
    }

    public static String getPlatformName() {
        if (getPropValue("platform.name").isEmpty()) {
            throw new IllegalStateException("PlotForm Name is not set in config.properties.");
        } else {
            return getPropValue("platform.name");
        }
    }

    public static String getProductVersion() {
        if (getPropValue("product.version").isEmpty()) {
            throw new IllegalStateException("Timeout is not set in config.properties.");
        } else {
            return getPropValue("product.version");
        }
    }


    public static String getProductBuild() {
        if (getPropValue("product.build").isEmpty()) {
            throw new IllegalStateException("Product Build is not set in config.properties.");
        } else {
            return getPropValue("product.build");
        }
    }

    public static String getTakeShootsOnFailure() {
        if (getPropValue("take.screenshot.on.failure").isEmpty()) {
            throw new IllegalStateException("Take screenshot on failure is not set in config.properties.");
        } else {
            return getPropValue("take.screenshot.on.failure");
        }
    }

    public static String getApplicationPackageName() {
        if (getPropValue("application.package").isEmpty()) {
            throw new IllegalStateException("Application Package is not set in config.properties.");
        } else {
            return getPropValue("application.package");
        }
    }

    public static String getApplicationPath() {
        if (getPropValue("apk.path").isEmpty()) {
            throw new IllegalStateException("Application Path is not set in config.properties.");
        } else {
            return getPropValue("apk.path");
        }
    }

    public static URL getDriverUrl() throws MalformedURLException {
        if (getPropValue("driver.url").isEmpty()) {
            throw new IllegalStateException("Application Path is not set in config.properties.");
        } else {
            return new URL(getPropValue("driver.url"));
        }
    }

    public static void init() {
        File infile = new File(filepath);
        Properties prop = new Properties();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(infile), "UTF-8"));
            prop.load(br);
        } catch (IOException e) {
        }
        propertyMap = new HashMap<String, String>((Map) prop);
    }

    public static void main(String[] args)  {
        init();
        for (Map.Entry<String, String> entry : ConfigurationPropertyReader.propertyMap.entrySet()) {
            System.out.printf("Key : %s -- Value: %s %n", entry.getKey(), entry.getValue());
        }
    }
}
