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
    @FindBy(id = "usernameInput")
    public WebElement userName;

    @FindBy(id = "passwordInput")
    public WebElement passWord;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submit;

    @FindBy(id = "error-message")
    public WebElement errorMessage;

    By errorMessageBy = By.id("error-message");

    public void loginApplicationWithInvalidUserName(String userName, String passWord) {
        this.userName.sendKeys(userName);
        this.passWord.sendKeys(passWord);
        submit.click();
    }

    public String getErrorMessage() {
        waitForElementToAppear(errorMessage);
        //waitForElementToAppear(errorMessageBy);
        return errorMessage.getText();
    }


}
