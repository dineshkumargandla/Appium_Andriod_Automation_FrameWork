package com.automation.mobile.appium.utils;

import com.automation.mobile.appium.setup.AndroidDriverManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Waits extends AndroidDriverManager {

    public Waits(AndroidDriver driver) {
        this.driver = driver;
    }

    private static void waitUntilCondition(ExpectedCondition condition, String timeoutMessage, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout, 5000);
        wait.withMessage(timeoutMessage);
        wait.until(condition);
    }

    public static void forElementToBeDisplayed(int timeout, MobileElement webElement, String webElementName) {
        ExpectedCondition<WebElement> condition = ExpectedConditions.visibilityOf(webElement);
        String timeoutMessage = webElementName + " wasn't displayed after " + Integer.toString(timeout) + " seconds.";
        waitUntilCondition(condition, timeoutMessage, timeout);
    }

    public static void forPresenceOfElements(int timeout, By elementLocator, String elementName) {
        ExpectedCondition<List<WebElement>> condition = ExpectedConditions.presenceOfAllElementsLocatedBy(elementLocator);
        String timeoutMessage = elementName + " elements were not displayed after " + Integer.toString(timeout) + " seconds.";
        waitUntilCondition(condition, timeoutMessage, timeout);
    }

    public static void sleep(long timeout) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(timeout);
    }

}