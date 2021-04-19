package com.project.auth;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YandexMailPage {

    @FindBy(css = "div[class='composeYabbles']")
    WebElement mailInput;

    @FindBy(xpath = "//*[@id=\"nb-1\"]/body/div[2]/div[9]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/div[1]/div/div[1]/div[1]/div[3]/div/div/input")
    WebElement topicInput;

    @FindBy(xpath = "//*[@id=\"cke_1_contents\"]/div")
    WebElement msgInput;

    @FindBy(xpath = "//*[@id=\"nb-1\"]/body/div[2]/div[9]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/div[2]/div/div[1]/div[1]/button")
    WebElement sendButton;

    public void sengMsg(String mail,String topic,String msg) {
        topicInput.click();
        topicInput.sendKeys(topic);
        msgInput.click();
        msgInput.sendKeys(msg);
        mailInput.click();
        mailInput.sendKeys(mail);
        sendButton.click();

    }

}
