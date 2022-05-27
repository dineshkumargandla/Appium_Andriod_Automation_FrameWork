package com.automation.mobile.appium.Pages;

import com.automation.mobile.appium.actionHelper.AndroidHelperMethods;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class BasePage {
    protected AndroidDriver androidDriver;
    AndroidHelperMethods androidHelperMethods;

    public BasePage(AndroidDriver driver) {
        this.androidDriver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
        androidHelperMethods= new AndroidHelperMethods(androidDriver);
    }
}
