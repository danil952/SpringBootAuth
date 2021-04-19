package com.project.auth;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage {

    @FindBy(css = "input[name='username']")
    WebElement loginTextbox;

    @FindBy(css = "input[name='password']")
    WebElement passwordTextBox;

    @FindBy(css = "input[name='passwordConfirm']")
    WebElement passwordConfirmTextBox;

    @FindBy(css = "button.btn")
    WebElement button;

    public void registr(String name,String pass)
    {
        loginTextbox.sendKeys(name);
        passwordTextBox.sendKeys(pass);
        passwordConfirmTextBox.sendKeys(pass);
        button.click();
    }

}
