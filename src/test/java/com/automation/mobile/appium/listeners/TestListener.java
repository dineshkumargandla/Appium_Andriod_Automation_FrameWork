package com.automation.mobile.appium.listeners;

import com.automation.mobile.appium.reporting.ExtentReport;
import com.automation.mobile.appium.utils.ConfigurationPropertyReader;
import com.automation.mobile.appium.utils.DateAndTimeUtils;
import com.automation.mobile.appium.utils.Logs;
import com.automation.mobile.appium.utils.utility;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import lombok.extern.java.Log;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static com.automation.mobile.appium.setup.DriverManager.driver;
import static com.automation.mobile.appium.utils.ConfigurationPropertyReader.getScreenOutDir;

public class TestListener implements ITestListener {

    public void onTestFailure(ITestResult result) {
        if(ConfigurationPropertyReader.getTakeShootsOnFailure().equalsIgnoreCase("true")) {
            attachScreenShotToExtentReport(result);
        }
    }


    private void attachScreenShotToExtentReport(ITestResult result) {
        String propertyPath = System.getProperty("user.dir") + "//src//main//resources//android.properties";
        Properties properties = utility.loadProperties(propertyPath);
        if (result.getThrowable() != null) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            result.getThrowable().printStackTrace(pw);
            Logs.error(sw.toString());
        }

        File file = driver.getScreenshotAs(OutputType.FILE);

        byte[] encoded = null;
        try {
            encoded = Base64.encodeBase64(FileUtils.readFileToByteArray(file));
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        String imagePath = getScreenOutDir() + File.separator + "Screenshots" + File.separator + ConfigurationPropertyReader.getProductVersion() + "." + ConfigurationPropertyReader.getProductBuild() + File.separator + properties.getProperty("platformName")
                + "_" + properties.getProperty("deviceName") + File.separator + DateAndTimeUtils.getDate() + File.separator + DateAndTimeUtils.getCurrentTimeModified() + File.separator
                + result.getTestClass().getRealClass().getSimpleName() + File.separator + result.getName() + ".png";

        String completeImagePath = System.getProperty("user.dir") + File.separator + imagePath;

        try {
            FileUtils.copyFile(file, new File(imagePath));
            Reporter.log("This is the sample screenshot");
            Reporter.log("<a href='" + completeImagePath + "'> <img src='" + completeImagePath + "' height='400' width='400'/> </a>");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ExtentReport.getTest().fail("Test Failed",
                MediaEntityBuilder.createScreenCaptureFromPath(completeImagePath).build());
        ExtentReport.getTest().fail("Test Failed",
                MediaEntityBuilder.createScreenCaptureFromBase64String(new String(encoded, StandardCharsets.US_ASCII)).build());
        ExtentReport.getTest().fail(result.getThrowable());
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.startTest(result.getName(), result.getMethod().getDescription())
                .assignCategory("XYZ" + "_" + "123")
                .assignAuthor("Dinesh");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentReport.getTest().log(Status.PASS, "Test Passed");

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentReport.getTest().log(Status.SKIP, "Test Skipped");

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReport.getReporter().flush();
    }

}