package com.automation.mobile.appium.Constants;

import com.automation.mobile.appium.Pages.HomePage;
import com.automation.mobile.appium.actionHelper.AndroidHelperMethods;
import io.appium.java_client.android.AndroidDriver;

import static com.automation.mobile.appium.setup.DriverManager.driver;

public class DeclarationConstants {
   public static HomePage HOME_PAGE  = new HomePage(driver);

   AndroidHelperMethods ANDROID_HELPER_METHODS = new AndroidHelperMethods(driver);
}
