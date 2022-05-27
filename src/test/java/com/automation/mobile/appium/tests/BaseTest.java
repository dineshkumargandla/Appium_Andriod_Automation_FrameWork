package com.automation.mobile.appium.tests;



import com.automation.mobile.appium.Pages.HomePage;
import com.automation.mobile.appium.setup.DriverManager;
import com.automation.mobile.appium.setup.DriverManagerType;
import com.automation.mobile.appium.utils.Logs;
import org.openqa.selenium.WebDriver;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.*;


import java.lang.reflect.Method;

import static com.automation.mobile.appium.utils.GenerateLogFileLocation.updateLogFilepath;

public class BaseTest {


    static WebDriver driver;

    @BeforeSuite
    public void setUp() {
        try {
            updateLogFilepath();
            Logs.info("Setting up Driver..!!");
            driver = DriverManager.getDriver(DriverManagerType.ANDROID);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @AfterSuite
    public void destroyDriver() {
        //driver.quit();
    }

    @BeforeMethod
    public void beforeMethod(Method method){
        Logs.startTestcase(method.getAnnotation(Test.class).description());
    }

    @AfterMethod
    public void afterMethod(Method method){
        Logs.endTestcase(method.getAnnotation(Test.class).description());
    }

}