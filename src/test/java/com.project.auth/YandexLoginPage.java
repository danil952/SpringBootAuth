package com.project.auth;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class YandexLoginPage {


    @FindBy(id="passp-field-login")
    WebElement loginTextbox;


    @FindBy(css="button[data-t='button:action']")
    WebElement loginButton;

    public void login(String username){
        loginTextbox.click();
        loginTextbox.sendKeys(username);
        loginButton.click();

    }







}
