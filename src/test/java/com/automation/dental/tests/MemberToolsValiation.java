package com.automation.dental.tests;

import com.automation.dental.base.BaseTest;
import com.automation.dental.pageObjects.LandingPage;
import com.automation.dental.pageObjects.MemberToolsPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class MemberToolsValiation extends BaseTest {

    @Test
    public void member() throws InterruptedException, IOException {
        LandingPage landingPage = launchApplication();
        landingPage.goTo();
        landingPage.waitForElementToDisappear();
        MemberToolsPage memberToolsPage = landingPage.goToMemberToolsPage();
        landingPage.waitForElementToDisappear();
        memberToolsPage.goToDentistFinder();
        memberToolsPage.waitForElementToDisappear();
    }

}
