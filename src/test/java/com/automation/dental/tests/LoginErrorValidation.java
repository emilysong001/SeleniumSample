package com.automation.dental.tests;

import com.automation.dental.base.BaseTest;
import com.automation.dental.pageObjects.LandingPage;
import com.automation.dental.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginErrorValidation extends BaseTest {

    @Test(dataProvider = "getData")
    public void LoginWithValidEmail(String invalidUserName,String invalidPassword) throws IOException {

        LandingPage landingPage = launchApplication();
        LoginPage loginPage = landingPage.goToSignInPage();
        loginPage.loginApplicationWithInvalidUserName(invalidUserName, invalidPassword);
        String actual = loginPage.getErrorMessage();
        System.out.println(actual);
        String expected = "Wrong username or password.";
        Assert.assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][]{{"abc", "a"}, {"a@gmail.com", "123"}};
    }

}
