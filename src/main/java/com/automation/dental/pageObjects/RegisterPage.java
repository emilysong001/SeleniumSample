package com.automation.dental.pageObjects;

import com.automation.dental.abstractComponent.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RegisterPage extends AbstractComponent {

    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@type='radio']")
    public List<WebElement> elementList;

    @FindBy(xpath = "//input[@value='Proceed to step 2']")
    public WebElement proceedButton;

    public void step1() {
        for (WebElement e : elementList) {
            if (e.getAttribute("value").startsWith("provider_registration")) {
                e.click();
                //System.out.println(e.isSelected());
            }
        }
        proceedButton.click();
    }
}
