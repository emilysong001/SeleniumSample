package com.automation.dental.abstractComponent;

import gherkin.lexer.Th;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class AbstractComponent {

    WebDriver driver;

    public AbstractComponent(WebDriver driver){
        this.driver = driver;
    }

    public void waitForElementToAppear(By findBy){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

    public void waitForElementToAppear(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToDisappear(WebElement element) throws InterruptedException {
        /*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.invisibilityOf(element));*/
        Thread.sleep(5000);
    }

    public void switchToWindow(){
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();

        // check if child window has other child windows
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                /*WebElement text = driver.findElement(By.id("userId"));
                System.out.println("Heading of child window is " + text.getText());*/
            }
        }
    }

    public void selectFromDropdownByText(WebElement element,String option) {
        Select select = new Select(element);
        select.selectByVisibleText(option);
    }
    public void selectFromDropdownByIndex(WebElement element,int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }
    public void selectFromDropdownByValue(WebElement element,String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }
}
