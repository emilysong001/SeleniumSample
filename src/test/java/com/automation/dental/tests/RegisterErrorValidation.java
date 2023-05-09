package com.automation.dental.tests;

import com.automation.dental.base.BaseTest;
import com.automation.dental.pageObjects.LandingPage;
import com.automation.dental.pageObjects.LoginPage;
import com.automation.dental.pageObjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegisterErrorValidation extends BaseTest {

    @Test
    public void verifyRegisterWithEmptyInformation() throws IOException {

        LandingPage landingPage = launchApplication();
        LoginPage loginPage = landingPage.goToMemberPortalLoginPage();
        RegisterPage registerPage = loginPage.goToMemberPortalRegisterPage();
        registerPage.loadingRegisterPage();
        registerPage.registerNewAccountWithEmptyInformation();
        String actual = registerPage.getErrorMessage();
        System.out.println(actual);
        String expected = "Please fill in all required details";
        Assert.assertEquals(actual, expected);

        String actualAlertMessage = registerPage.getAlertErrorMessage();
        System.out.println(actualAlertMessage);
        String expectedAlertMessage = "This field is required";
        Assert.assertEquals(actualAlertMessage, expectedAlertMessage);
    }

    @Test(dataProvider = "getRegisterData")
    public void verifyRegisterWithInvalidInformation(String fName,String lName, String SSN, String dob ) throws IOException {

        LandingPage landingPage = launchApplication();
        LoginPage loginPage = landingPage.goToMemberPortalLoginPage();
        RegisterPage registerPage = loginPage.goToMemberPortalRegisterPage();
        registerPage.loadingRegisterPage();
        registerPage.registerNewAccountWithInvalidInformation(fName, lName,SSN,dob);
        /*String actual = registerPage.getNotMatchMessage();
        System.out.println(actual);
        String expected = "Information provided did not match any records in our system";
        Assert.assertEquals(actual, expected);*/

        String actual = registerPage.getErrorMessage();
        System.out.println(actual);
        String expected = "Please fill in all required details";
        Assert.assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] getRegisterData() {
        String[][] credentials = {
                {"Emily", "Song","123","10/20/2000"},
        };
        return credentials;
    }



}
