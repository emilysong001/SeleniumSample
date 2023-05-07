package com.automation.dental.tests;

import com.automation.dental.base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class CostEstimator extends BaseTest {

    @Test
    public void costEstimate() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.deltadental.com/");
        //Thread.sleep(5000);

        //driver.findElement(By.xpath("(//nav[@class='primary loaded']/ul/li/a)[text()='Member tools']")).click();
        driver.findElement(By.cssSelector("a[href='#link-3']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@id='treatmentCategory-selectized']")).sendKeys("Crown");

        //dropdown.selectByVisibleText("Checkup-Established Patient - Adult");
        //System.out.println(dropdown.getFirstSelectedOption().getText());
        driver.findElement(By.id("ceZipCode")).sendKeys("48375");
        System.out.println("cost estimate");
        driver.findElement(By.id("ceSubmitBtn")).click();
        String actual = "Please select a treatment type";
        System.out.println(
                driver.findElement(By.xpath("//span[@class='form-error-msg ce-component-treatmenttype-errormsg']")).getText());

    }
}
