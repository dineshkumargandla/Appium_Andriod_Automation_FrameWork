package com.automation.mobile.appium.actionHelper;

import com.automation.mobile.appium.utils.Logs;
import com.automation.mobile.appium.utils.Waits;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AndroidHelperMethods {
    private AndroidDriver driver;

    public AndroidHelperMethods(AndroidDriver driver) {
        this.driver = driver;
    }

    public static void click(MobileElement element) {
        element.click();
        Logs.info(element + "Element is getting clicked");
    }
    public void inputValuesSlowly(MobileElement element, String value) {
        try {
            String val = value;
            for (int i = 0; i < val.length(); i++) {
                char c = val.charAt(i);
                String s = new StringBuilder().append(c).toString();
                System.out.println(s);
                element.setValue(s);
                Thread.sleep(100);
            }
        } catch (Exception e) {
            Logs.error();
            System.out.println("Not able to enter" + e.getMessage());
        }
    }

    public static void clear(MobileElement e)  {
        e.clear();
    }

    public static void sendKeys(MobileElement element, String input) {
        element.sendKeys(input);
        System.out.println("Sending " + input + " to element " +element);
    }

    public static String getText(MobileElement e) throws InterruptedException {

        Waits.sleep(5000);
        return e.getText();
    }
}
