package com.project.auth;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LoginPage {


    @FindBy(css="input[name='username']")
    WebElement loginTextbox;

    @FindBy(id="passwordField")
    WebElement passwordTextBox;

    @FindBy(id="loginButton")
    WebElement loginButton;

    public void login(String username, String password){
        loginTextbox.click();
        loginTextbox.sendKeys(username);
        passwordTextBox.click();
        passwordTextBox.sendKeys(password);
        loginButton.click();

    }







}
