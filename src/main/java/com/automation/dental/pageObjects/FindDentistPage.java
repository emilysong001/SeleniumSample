package com.automation.dental.pageObjects;

import com.automation.dental.abstractComponent.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FindDentistPage extends AbstractComponent {
    WebDriver driver;

    public FindDentistPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css="a[href='#sub-nav']")
    public WebElement findADentistArrow;

    @FindBy(xpath="//div[@class='col-md-6']/ul/li/a[text()='Delta Dental PPO and Delta Dental Premier']")
    public WebElement PPO;

    @FindBy(xpath="//div[@class='col-md-6']/ul/li/a[text()='DeltaCare USA']")
    public WebElement deltaCareUSA;

    @FindBy(xpath="//div[@class='col-md-6']/ul/li/a[text()='Delta Dental EPO']")
    public WebElement EPO;

    @FindBy(xpath="//div[@class='col-md-6']/ul/li/a[text()='Healthy Kids Dental']")
    public WebElement healthyKidsDental;

    @FindBy(xpath="//div[@class='col-md-6']/ul/li/a[text()='MI Health Link']")
    public WebElement MIHealthLink;

    public void goToPPOPage(){
        findADentistArrow.click();
        waitForElementToAppear(PPO);
        PPO.click();
        switchToWindow();
    }

    public void goToDeltaCareUSAPage(){
        findADentistArrow.click();
        waitForElementToAppear(deltaCareUSA);
        deltaCareUSA.click();
        switchToWindow();
    }

    public EPODentistPage goToEPOPage(){
        findADentistArrow.click();
        waitForElementToAppear(EPO);
        EPO.click();
        switchToWindow();
        EPODentistPage ePODentistPage = new EPODentistPage(driver);
        return ePODentistPage;
    }

    public void goToHealthyKidsDentalPage(){
        findADentistArrow.click();
        waitForElementToAppear(healthyKidsDental);
        healthyKidsDental.click();
        switchToWindow();
    }

    public void goToMIHealthLinkPage(){
        findADentistArrow.click();
        waitForElementToAppear(MIHealthLink);
        MIHealthLink.click();
        switchToWindow();
    }


}
