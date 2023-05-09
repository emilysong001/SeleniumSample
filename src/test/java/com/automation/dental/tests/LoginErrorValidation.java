package com.automation.dental.tests;

import com.automation.dental.base.BaseTest;
import com.automation.dental.pageObjects.LandingPage;
import com.automation.dental.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginErrorValidation extends BaseTest {

    @Test
    public void LoginWithEmptyEmailAndPassword() throws IOException {

        LandingPage landingPage = launchApplication();
        LoginPage loginPage = landingPage.goToMemberPortalLoginPage();
        loginPage.loginApplicationWithEmptyUserNamePassword();
        String actual = loginPage.getAlertErrorMessage();
        System.out.println(actual);
        String expected = "This field is required";
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "getData")
    public void LoginWithInvalidEmailAndPassword(String invalidUserName, String invalidPassword) throws IOException {

        LandingPage landingPage = launchApplication();
        LoginPage loginPage = landingPage.goToMemberPortalLoginPage();
        loginPage.loginApplicationWithInvalidUserName(invalidUserName, invalidPassword);
        String actual = loginPage.getErrorMessage();
        System.out.println(actual);
        String expected = "The username or password you entered is incorrect. If you continue to see this message, your account may be locked. Please contact Customer Service for assistance.";
        Assert.assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] getData() {
        String[][] credentials = {
                {"b@gmail.com", "123"},
                {"acbcdf", "a123"}
        };
        return credentials;
    }



}
