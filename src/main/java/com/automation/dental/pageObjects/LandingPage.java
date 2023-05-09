package com.automation.dental.pageObjects;

import com.automation.dental.abstractComponent.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponent {
    WebDriver driver;

    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "login-box-button")
    public WebElement LoginOrRegister;

    @FindBy(linkText = "Log in or Register")
    public WebElement MemberPortalLogin;

    @FindBy(xpath = "//a[text()=' Find a Dentist']")
    public WebElement findADentist;

    public void goTo() {
        driver.get("https://www.deltadentalmi.com/");

    }

    public LoginPage goToMemberPortalLoginPage() {
        LoginOrRegister.click();
        MemberPortalLogin.click();
        switchToWindow();
        LoginPage loginPage = new LoginPage(driver);
        return loginPage ;
    }


    public FindDentistPage goToFindADentistPage() {
        findADentist.click();
        FindDentistPage findDentistPage = new FindDentistPage(driver);
        return findDentistPage;
    }

}
