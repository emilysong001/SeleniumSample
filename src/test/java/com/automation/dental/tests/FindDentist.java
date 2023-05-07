package com.automation.dental.tests;

import com.automation.dental.base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class FindDentist extends BaseTest {
    @Test
    public void findDentist() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.deltadental.com/");
        //Thread.sleep(5000);

        //driver.findElement(By.xpath("(//nav[@class='primary loaded']/ul/li/a)[text()='Member tools']")).click();
        driver.findElement(By.cssSelector("a[href='#link-2']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[text()='Endodontist']")).click();
        WebElement option = driver.findElement(By.xpath("//div[@class='item' and @data-value='PPO']"));
        option.click();

        driver.findElement(By.id("findDentistSubmitBtn")).click();

    }
}
