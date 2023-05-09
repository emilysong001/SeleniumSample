package com.automation.dental.pageObjects;

import com.automation.dental.abstractComponent.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EPODentistResultPage extends AbstractComponent {
    WebDriver driver;

    public EPODentistResultPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="(//div[@class='col-md-12']/h3)[1]")
    public WebElement searchResults;


    public void loadingEPODentistResultPage(){
        waitForElementToAppear(searchResults);
    }

}
