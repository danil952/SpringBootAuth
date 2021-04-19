package com.project.auth;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YandexPassPage {
    @FindBy(css="input[data-t='field:input-passwd']")
    WebElement passTextbox;


    @FindBy(css="button[data-t='button:action']")
    WebElement loginButton;

    public void login(String pass){
        passTextbox.sendKeys(pass);
        loginButton.click();

    }

}
