package com.automation.mobile.appium.tests;


import com.automation.mobile.appium.Constants.CredentialsConstants;
import com.automation.mobile.appium.listeners.TestListener;
import com.automation.mobile.appium.utils.Waits;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.automation.mobile.appium.Constants.DeclarationConstants.HOME_PAGE;
import static com.automation.mobile.appium.Constants.ErrorMessages.USER_NAME_REQUIRED;

@Listeners(TestListener.class)
public class HomePageTest extends BaseTest{

    @BeforeClass
    public void isElementDisplayed(){
        Waits.forElementToBeDisplayed(15,HOME_PAGE.isUserNameTextBoxDisplayed(), "Text Box is not displayed" );
    }


    @Test
    @Description("Testing by passing empty values to the text field and click login")
    private void test_Login_With_Empty_Field() throws InterruptedException {
        HOME_PAGE.clickLoginButton();
        Assert.assertEquals(HOME_PAGE.getErrorMessage()+"54", USER_NAME_REQUIRED);
    }

    @Test
    @Description("Testing with Valid UserName and password")
    private void testing_with_Valid_UserName_and_password() throws InterruptedException {
        Waits.forElementToBeDisplayed(15,HOME_PAGE.isUserNameTextBoxDisplayed(), "Text Box is not displayed" );
        HOME_PAGE.enterUserName(CredentialsConstants.getValidUsername());
        HOME_PAGE.enterPassword(CredentialsConstants.getValidPassword());
        HOME_PAGE.clickLoginButton();
    }
}
