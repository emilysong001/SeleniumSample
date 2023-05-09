package com.automation.dental.pageObjects;

import com.automation.dental.abstractComponent.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EPODentistPage extends AbstractComponent {
    WebDriver driver;

    public EPODentistPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "UserZip")
    public WebElement zipCode;

    @FindBy(id = "UserAddress")
    public WebElement address;
    @FindBy(id = "UserCity")
    public WebElement city;

    @FindBy(id = "UserState")
    public WebElement state;
    @FindBy(id = "MaxMile")
    public WebElement maximumDistance;

    @FindBy(id = "MaxQuantity")
    public WebElement numberOfResults;

    @FindBy(id = "DentistLastName")
    public WebElement dentistLastName;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement searchButton;

    @FindBy(xpath = "//div[@class='validation-summary-errors alert alert-danger']/ul/li[1]")
    public WebElement errorMessage1;
    @FindBy(xpath = "//div[@class='validation-summary-errors alert alert-danger']/ul/li[2]")
    public WebElement errorMessage2;
    @FindBy(xpath = "//div[@class='validation-summary-errors alert alert-danger']/ul/li[3]")
    public WebElement errorMessage3;

    public void loadingEPODentistPage() {
        waitForElementToAppear(zipCode);
    }

    public void searchWithBasicCredentials(String zipCode, String city, String state, int maximumDistance, String numberOfResults) {
        this.zipCode.sendKeys(zipCode);
        this.city.sendKeys(city);
        selectFromDropdownByText(this.state, state);
        selectFromDropdownByIndex(this.maximumDistance, maximumDistance);
        selectFromDropdownByValue(this.numberOfResults, numberOfResults);
    }

    public void search(){
        searchButton.click();
    }

    public void searchWithOnlyAdditionalCredentials(String dentistLastName) {
        this.dentistLastName.sendKeys(dentistLastName);
    }

    public void searchWithEmptyCredentials() {
        searchButton.click();
    }

    public EPODentistResultPage searchWithAllCredentials(String zipCode, String city, String state, int maximumDistance, String numberOfResults, String dentistLastName) {
        searchWithBasicCredentials(zipCode, city, state, maximumDistance, numberOfResults);
        searchWithOnlyAdditionalCredentials(dentistLastName);
        search();
        EPODentistResultPage ePODentistResultPage = new EPODentistResultPage(driver);
        return ePODentistResultPage;
    }

    public String getErrorMessage1() {
        waitForElementToAppear(errorMessage1);
        return errorMessage1.getText();
    }

    public String getErrorMessage2() {
        waitForElementToAppear(errorMessage2);
        return errorMessage2.getText();
    }

    public String getErrorMessage3() {
        waitForElementToAppear(errorMessage3);
        return errorMessage3.getText();
    }


}
