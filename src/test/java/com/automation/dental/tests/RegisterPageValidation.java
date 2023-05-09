package com.automation.dental.tests;

import com.automation.dental.base.BaseTest;
import com.automation.dental.pageObjects.LandingPage;
import com.automation.dental.pageObjects.LoginPage;
import com.automation.dental.pageObjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegisterPageValidation extends BaseTest {

    @Test
    public void verifyLoginRegisterPageSuccessfully() throws IOException {

        LandingPage landingPage = launchApplication();
        LoginPage loginPage = landingPage.goToMemberPortalLoginPage();
        RegisterPage registerPage = loginPage.goToMemberPortalRegisterPage();
        registerPage.loadingRegisterPage();
        Assert.assertEquals(registerPage.firstNameLabel.getText(), "First Name");
        Assert.assertEquals(registerPage.lastNameLabel.getText(), "Last Name");
        Assert.assertEquals(registerPage.SSNLabel.getText(), "Social Security Number or Member ID of Subscriber");
        Assert.assertEquals(registerPage.dateOfBirthLabel.getText(), "Date of Birth");
        Assert.assertEquals(registerPage.selectMemberTypeLabel.getText(), "Select Member Type");
    }



}
