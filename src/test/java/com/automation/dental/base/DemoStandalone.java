package com.automation.dental.base;

import com.automation.dental.pageObjects.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DemoStandalone {
    public static void main(String[] args) {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(option);
        driver.get("https://www.deltadental.com/");
        System.out.println("login successfully");

    }

    @Test
    public void Login() throws InterruptedException {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(option);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.deltadental.com/");
        //Thread.sleep(5000);
        //driver.findElement(By.xpath("(//nav[@class='primary loaded']/ul/li/a)[text()='Member tools']")).click();
        driver.findElement(By.cssSelector("a[href='#link-4']")).click();
        driver.findElement(By.xpath("//a[text()='Sign in']")).click();
        System.out.println("Member page");
        driver.findElement(By.id("usernameInput")).sendKeys("a");
        driver.findElement(By.id("passwordInput")).sendKeys("a");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(5000);
        String actual = driver.findElement(By.id("error-message")).getText();
        System.out.println(actual);
        String expected = "Wrong username or password.";
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void createNew() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.deltadental.com/");
        //Thread.sleep(5000);

        //driver.findElement(By.xpath("(//nav[@class='primary loaded']/ul/li/a)[text()='Member tools']")).click();
        driver.findElement(By.cssSelector("a[href='#link-4']")).click();
        driver.findElement(By.xpath("//a[text()='Create an account']")).click();
        Thread.sleep(5000);

        List<WebElement> elementList = driver.findElements(By.xpath("//input[@type='radio']"));
        for (WebElement e:elementList){
            //System.out.println(e.getAttribute("value"));
            if(e.getAttribute("value").startsWith("provider_registration")) {
                 e.click();
                System.out.println(e.isSelected());
            }
        }

        driver.findElement(By.xpath("//input[@value='Proceed to step 2']")).click();
        Thread.sleep(5000);
        System.out.println("sc");
    }

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

    @Test
    public void member() throws InterruptedException {
                WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.deltadental.com/");
        Thread.sleep(3000);
        //driver.findElement(By.xpath("(//nav[@class='primary loaded']/ul/li/a)[1]")).click();
        driver.findElement(By.xpath("(//nav[@class='primary loaded']/ul/li/a)[2]")).click();
        //driver.findElement(By.xpath("(//nav[@class='primary loaded']/ul/li/a)[3]")).click();
        //driver.findElement(By.xpath("(//nav[@class='primary loaded']/ul/li/a)[4]")).click();
        Thread.sleep(3000);
        //driver.findElement(By.xpath("(//div[@class='inner']/ul/li/a)[2]")).click();
        driver.findElement(By.xpath("(//div[@class='inner']/ul/li/a)[2]")).click();

    }
}
