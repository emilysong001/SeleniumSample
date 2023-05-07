package com.automation.dental.tests;

import com.automation.dental.base.BaseTest;
import com.automation.dental.pageObjects.LandingPage;
import com.automation.dental.pageObjects.LoginPage;
import com.automation.dental.pageObjects.MemberToolsPage;
import com.automation.dental.pageObjects.RegisterPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static com.sun.javafx.application.LauncherImpl.launchApplication;

public class Demo extends BaseTest {
    public static void main(String[] args) {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(option);
        driver.get("https://www.deltadental.com/");
        System.out.println("login successfully");

    }

    @Test
    public void Login() throws IOException {
       /* ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(option);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();*/

        /*LandingPage landingPage = new LandingPage(driver);
        landingPage.goTo();*/
        LandingPage landingPage= launchApplication();
        //driver.get("https://www.deltadental.com/");

        //Thread.sleep(5000);

        //driver.findElement(By.cssSelector("a[href='#link-4']")).click();
        //driver.findElement(By.xpath("//a[text()='Sign in']")).click();
        landingPage.goToSignInPage();

        LoginPage loginPage = new LoginPage(driver);
        //driver.findElement(By.id("usernameInput")).sendKeys("a");
        //driver.findElement(By.id("passwordInput")).sendKeys("a");
        //driver.findElement(By.xpath("//button[@type='submit']")).click();
        String invalidUserName = "a";
        String invalidPassword = "a";
        loginPage.loginApplicationWithInvalidUserName(invalidUserName, invalidPassword);
        //Thread.sleep(5000);
        //String actual = driver.findElement(By.id("error-message")).getText();
        String actual = loginPage.getErrorMessage();

        System.out.println(actual);
        String expected = "Wrong username or password.";
        Assert.assertEquals(actual, expected);

    }

    @Test
    public void createNew() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.deltadental.com/");
        //Thread.sleep(5000);

        //driver.findElement(By.cssSelector("a[href='#link-4']")).click();
        //driver.findElement(By.xpath("//a[text()='Create an account']")).click();
        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToCreateAnAccountPage();

        //Thread.sleep(5000);
        landingPage.waitForElementToDisappear();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.step1(); //choose provider

        /*List<WebElement> elementList = driver.findElements(By.xpath("//input[@type='radio']"));
        for (WebElement e : elementList) {
            //System.out.println(e.getAttribute("value"));
            if (e.getAttribute("value").startsWith("provider_registration")) {
                e.click();
                System.out.println(e.isSelected());
            }
        }*/

        //driver.findElement(By.xpath("//input[@value='Proceed to step 2']")).click();
        //Thread.sleep(5000);
        registerPage.waitForElementToDisappear();
        System.out.println("next page");
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
       // driver.get("https://www.deltadental.com/");
        LandingPage landingPage = new LandingPage(driver);
        landingPage.goTo();
        landingPage.waitForElementToDisappear();
        //Thread.sleep(3000);

        //driver.findElement(By.xpath("(//nav[@class='primary loaded']/ul/li/a)[1]")).click();

        //driver.findElement(By.xpath("(//nav[@class='primary loaded']/ul/li/a)[2]")).click();
        landingPage.goToMemberToolsPage();

        //driver.findElement(By.xpath("(//nav[@class='primary loaded']/ul/li/a)[3]")).click();
        //driver.findElement(By.xpath("(//nav[@class='primary loaded']/ul/li/a)[4]")).click();
        //Thread.sleep(3000);
        landingPage.waitForElementToDisappear();
        //driver.findElement(By.xpath("(//div[@class='inner']/ul/li/a)[2]")).click();

        //driver.findElement(By.xpath("(//div[@class='inner']/ul/li/a)[2]")).click();
        MemberToolsPage memberToolsPage = new MemberToolsPage(driver);
        memberToolsPage.goToDentistFinder();


    }
}
