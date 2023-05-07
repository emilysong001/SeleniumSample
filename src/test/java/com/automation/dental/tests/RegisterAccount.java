package com.automation.dental.tests;

import com.automation.dental.base.BaseTest;
import com.automation.dental.pageObjects.LandingPage;
import com.automation.dental.pageObjects.RegisterPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class RegisterAccount extends BaseTest{

    @Test
    public void registerNewAccount() throws InterruptedException, IOException {
        LandingPage landingPage = launchApplication();
        RegisterPage registerPage = landingPage.goToCreateAnAccountPage();
        landingPage.waitForElementToDisappear();
        registerPage.step1(); //choose provider
        registerPage.waitForElementToDisappear();
        System.out.println("next page");
    }
}
