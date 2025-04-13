package pages;

import org.openqa.selenium.By;

public class LoginPage {

    public By usernameField(){
        return By.id("username");
    }

    public By passwordField(){
        return By.id("password");
    }

    public By loginButton(){
        return By.xpath("//button[normalize-space() = 'Login']");
    }

    public By flashMessage(String type){
        return By.xpath("//div[contains(@class, 'flash "+type.toLowerCase()+"')]");
    }
}