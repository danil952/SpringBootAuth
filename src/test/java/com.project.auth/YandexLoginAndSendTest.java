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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class YandexLoginAndSendTest {
    @Test
    public  void testSendMsg() throws FileNotFoundException {
        ArrayList<String> arr=new ArrayList<>();
        Scanner in = new Scanner(new File("/Users/danil/springboot-registration-login/src/test/java/com.project.auth/info.txt"));
        while (in.hasNextLine())
        {
            arr.add(in.nextLine());
        }

        WebDriver driver = new ChromeDriver();

        driver.get("https://mail.yandex.ru");
        WebElement loginButton = driver.findElement(By.cssSelector(".button2_theme_mail-white"));
        loginButton.click();
        YandexLoginPage loginPage = new YandexLoginPage();
        PageFactory.initElements(driver, loginPage);
        loginPage.login(arr.get(0));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        YandexPassPage passPage = new YandexPassPage();
        PageFactory.initElements(driver, passPage);
        passPage.login(arr.get(1));
        WebElement createButton = driver.findElement(By.cssSelector(".mail-ComposeButton"));
        createButton.click();
        YandexMailPage mailPage = new YandexMailPage();
        PageFactory.initElements(driver, mailPage);
        mailPage.sengMsg("4danik2000@gmail.com", "test", "test");

    }
}
