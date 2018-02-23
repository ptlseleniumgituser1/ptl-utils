package com.orange.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage {

    //Define the elements
    @FindBy(xpath = "//*[@id=\"welcome\"]")
    WebElement  lnkWelcome;



    //Define the methods
    public String getWelcomeMessage() {
        return lnkWelcome.getText();
    }
}
