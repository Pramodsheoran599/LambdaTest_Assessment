package pages;

import org.openqa.selenium.By;

public class JSAlertPage {

    public By jsButton(String text){
        return By.xpath("//button[@onclick][text() = '"+text+"']");
    }

    public By resultText(){
        return By.id("result");
    }
}