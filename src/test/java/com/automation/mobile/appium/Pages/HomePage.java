package com.automation.mobile.appium.Pages;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static com.automation.mobile.appium.actionHelper.AndroidHelperMethods.*;


public class HomePage extends BasePage {

    public HomePage(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Username']")
    // @iOSXCUITFindBy(id = "test-Username")
    private static AndroidElement UserNameTextField;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Password']")
    // @iOSXCUITFindBy(id = "test-Username")
    private static AndroidElement PasswordTextField;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-LOGIN']")
    // @iOSXCUITFindBy(id = "test-Username")
    private static AndroidElement ClickLoginButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Error message']/android.widget.TextView")
    // @iOSXCUITFindBy(id = "test-Username")
    private static AndroidElement ErrorMessage;


    public static void enterUserName(String userName) throws InterruptedException {
        clear(UserNameTextField);
        sendKeys(UserNameTextField , userName);
    }

    public static void enterPassword(String password) throws InterruptedException {
        clear(PasswordTextField);
        sendKeys(PasswordTextField , password );
    }
    public  MobileElement isUserNameTextBoxDisplayed(){
        return UserNameTextField;
    }

    public static void  clickLoginButton(){
        click(ClickLoginButton);
    }

    public String getErrorMessage() throws InterruptedException {
        return getText(ErrorMessage);
    }
}
