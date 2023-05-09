package com.automation.dental.pageObjects;

import com.automation.dental.abstractComponent.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractComponent {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        //initialization
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Page Factory
    @FindBy(id = "userId")
    public WebElement userName;

    @FindBy(id = "password")
    public WebElement passWord;

    //@FindBy(xpath = "//button[@type='submit']")
    @FindBy(id="landingBtn2")
    public WebElement login;

    @FindBy(xpath = "//div[@class='alert alert-danger']")
    public WebElement alertErrorMessage;

    @FindBy(xpath = "//div[@class='api-error-mesg']")
    public WebElement errorMessage;

    By errorMessageBy = By.xpath("//div[@class='api-error-mesg']");

    @FindBy(id = "landingLink2")
    public WebElement MemberPortalRegister;

    public void loginApplicationWithEmptyUserNamePassword() {
        waitForElementToAppear(login);
        login.click();
    }

    public void loginApplicationWithInvalidUserName(String userName, String passWord) {
        waitForElementToAppear(this.userName);
        this.userName.sendKeys(userName);
        this.passWord.sendKeys(passWord);
        login.click();
    }

    public String getAlertErrorMessage() {
        waitForElementToAppear(alertErrorMessage);
        return alertErrorMessage.getText();
    }

    public String getErrorMessage() {
        waitForElementToAppear(errorMessage);
        return errorMessage.getText();
    }

    public RegisterPage goToMemberPortalRegisterPage(){
        MemberPortalRegister.click();
        RegisterPage registerPage = new RegisterPage(driver);
        return registerPage;
    }


}
