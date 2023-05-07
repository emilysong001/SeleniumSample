package com.automation.dental.pageObjects;

import com.automation.dental.abstractComponent.AbstractComponent;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponent {
    WebDriver driver;

    public LandingPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css="a[href='#link-4']")
    public WebElement signIn;

    @FindBy(xpath = "//a[text()='Sign in']")
    public WebElement signInPopUp;

    @FindBy(xpath="//a[text()='Create an account']")
    public WebElement createAnAccountPopUp;

    public void goTo(){
        driver.get("https://www.deltadental.com/");
    }
    public LoginPage goToSignInPage(){
        signIn.click();
        signInPopUp.click();
        LoginPage loginPage = new LoginPage(driver);
        return loginPage ;
    }

    public RegisterPage goToCreateAnAccountPage(){
        signIn.click();
        createAnAccountPopUp.click();
        RegisterPage registerPage = new RegisterPage(driver);
        return registerPage;
    }

    @FindBy(xpath = "(//nav[@class='primary loaded']/ul/li/a)[1]")
    public WebElement insuranceProducts;

    public void goToInsuranceProductsPage(){
        insuranceProducts.click();
    }
    @FindBy(xpath = "(//nav[@class='primary loaded']/ul/li/a)[2]")
    public WebElement memberTools;

    public MemberToolsPage goToMemberToolsPage(){
        memberTools.click();
        MemberToolsPage memberToolsPage = new MemberToolsPage(driver);
        return memberToolsPage;
    }

}
