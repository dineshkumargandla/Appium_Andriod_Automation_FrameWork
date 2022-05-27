package com.automation.mobile.appium.tests;



import com.automation.mobile.appium.Pages.HomePage;
import com.automation.mobile.appium.setup.DriverManager;
import com.automation.mobile.appium.setup.DriverManagerType;
import com.automation.mobile.appium.utils.Logs;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {


    static WebDriver driver;
    HomePage homePage;

    @BeforeSuite
    public void setUp() {
        try {
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
}