package com.project.auth;

import com.project.auth.model.User;
import org.junit.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.DataBinder;

import java.util.HashSet;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class SeleniumTest  {

    @Test
    public void testRegistr() {
        WebDriver driver = new ChromeDriver();
        RegistrationPage registrationPage = new RegistrationPage();
        driver.get("http://localhost:8080/registration");
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.btn")));
        PageFactory.initElements(driver, registrationPage);

        registrationPage.registr("Danil123", "Root1234");

        String url=driver.getCurrentUrl();

        driver.quit();
        Assert.assertEquals("http://localhost:8080/welcome",url);


    }

    @Test
    public  void testWrongPass() {
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:8080/login");
        WebElement login = driver.findElement(By.cssSelector("input[name='username']"));
        WebElement pass = driver.findElement(By.cssSelector("input[name='password']"));
        login.click();
        pass.click();
        login.sendKeys("test");
        pass.sendKeys("test");
        WebElement button =driver.findElement(By.cssSelector("button.btn"));
        button.click();
        String url=driver.getCurrentUrl();

        driver.quit();

        Assert.assertEquals(url, "http://localhost:8080/login?error");


    }



    @Test
    public void testZLogin() {
        WebDriver driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("http://localhost:8080/login");

        PageFactory.initElements(driver, loginPage);
        loginPage.login("Danil123", "Root1234");
        String url=driver.getCurrentUrl();
        driver.quit();
        Assert.assertEquals("http://localhost:8080/",url);


    }

}