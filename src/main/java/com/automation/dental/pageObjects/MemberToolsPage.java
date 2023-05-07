package com.automation.dental.pageObjects;

import com.automation.dental.abstractComponent.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MemberToolsPage extends AbstractComponent {
    WebDriver driver;

    public MemberToolsPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="(//div[@class='inner']/ul/li/a)[2]")
    public WebElement dentistFinder;

    public void goToDentistFinder(){
        dentistFinder.click();
    }

    //Dentist finder

}
