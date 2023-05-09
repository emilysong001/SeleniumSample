package com.automation.dental.pageObjects;

import com.automation.dental.abstractComponent.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RegisterPage extends AbstractComponent {

    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "firstName")
    public WebElement firstName;

    @FindBy(xpath = "//div[@class='col-xs-12 form-group']/*[text()='First Name']")
    public WebElement firstNameLabel;
    @FindBy(id = "lastName")
    public WebElement lastName;
    @FindBy(xpath = "//div[@class='col-xs-12 form-group']/*[text()='Last Name']")
    public WebElement lastNameLabel;
    @FindBy(id = "memberIdentifier")
    public WebElement SSN;

    @FindBy(xpath = "//div[@class='col-xs-12 form-group']/*[text()='Social Security Number or Member ID of Subscriber']")
    public WebElement SSNLabel;
    @FindBy(id = "dateOfBirth")
    public WebElement dateOfBirth;

    @FindBy(xpath = "//div[@class='col-xs-12 form-group']/*[text()='Date of Birth']")
    public WebElement dateOfBirthLabel;

    @FindBy(xpath = "//div[@id='abde3102fb52-1']")
    public WebElement selectMemberTypeDropdown;

    @FindBy(xpath = "//div[@id='abde3102fb52-1']/span[text()='Spouse ']")
    public WebElement selectMemberTypeOptionSpouse;

    @FindBy(xpath = "//div[@class='col-xs-12 form-group']/*[text()='Select Member Type']")
    public WebElement selectMemberTypeLabel;

    @FindBy(id = "memvalidationBtn1")
    //@FindBy(xpath = "//button[@type='submit']")
    public WebElement proceedToRegisterButton;

    @FindBy(xpath = "//ul[@class='api-error-mesg']")
    public WebElement errorMessage;

    @FindBy(xpath = "(//div[@class='alert alert-danger'])[1]")
    public WebElement alrtErrorMessage;

    @FindBy(xpath = "//ul[@class='api-error-mesg']/li")
    public WebElement notMatchMessage;

    public void registerNewAccountWithInvalidInformation(String fName,String lName, String SSN, String dob) {
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        this.SSN.sendKeys(SSN);
        dateOfBirth.sendKeys(dob);
        //selectMemberTypeDropdown.click();
        //selectMemberTypeOptionSpouse.click();
        proceedToRegisterButton.click();
    }

    public void registerNewAccountWithEmptyInformation() {
        proceedToRegisterButton.click();
    }

    public String getAlertErrorMessage() {
        waitForElementToAppear(alrtErrorMessage);
        return alrtErrorMessage.getText();
    }

    public String getErrorMessage() {
        waitForElementToAppear(errorMessage);
        return errorMessage.getText();
    }

    public String getNotMatchMessage() {
        waitForElementToAppear(notMatchMessage);
        return notMatchMessage.getText();
    }

    public void loadingRegisterPage(){
        waitForElementToAppear(firstName);
    }
}
