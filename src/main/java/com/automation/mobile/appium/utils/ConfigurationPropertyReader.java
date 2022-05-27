package com.automation.mobile.appium.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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


    public static String getProductBuild() {
        if (getPropValue("product.build").isEmpty()) {
            throw new IllegalStateException("Product Build is not set in config.properties.");
        } else {
            return getPropValue("product.build");
        }
    }

    public static String getProductVersion() {
        if (getPropValue("product.version").isEmpty()) {
            throw new IllegalStateException("Product Version is not set in config.properties.");
        } else {
            return getPropValue("product.version");
        }
    }
    public static String getProjectName() {
        if (getPropValue("project.name").isEmpty()) {
            throw new IllegalStateException("Project Name is not set in config.properties.");
        } else {
            return getPropValue("project.name");
        }
    }

    public static String getTakeShootsOnFailure() {
        if (getPropValue("take.screenshot.on.failure").isEmpty()) {
            throw new IllegalStateException("Take screenshot on failure is not set in config.properties.");
        } else {
            return getPropValue("take.screenshot.on.failure");
        }
    }

    public static File getLoggingDirectory() {
        if (getPropValue("log.directory").isEmpty()) {
            throw new IllegalStateException("Log Directory is not set in config.properties.");
        } else {
                File logDirectory = new File(getPropValue("log.directory"));
                if (!logDirectory.isDirectory()){
                    Logs.error("Log Directory path should be directory, Not a file, Please change Log Directory path to Dir..!");
                    throw new IllegalStateException("Log Directory path should be directory, Not a file, Please change Log Directory path to Dir..!");
                }
            return new File(getPropValue("log.directory"));
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
