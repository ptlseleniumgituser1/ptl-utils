package com.orange.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    //Define the WebElements

    //User name element
    @FindBy(xpath = "//input[@id='txtUsername']")
    WebElement txtUsername;



    //Password element
    @FindBy(xpath = "//*[@id='txtPassword']")
    WebElement txtPassword;



    //Login button
    @FindBy(xpath = "//input[@id='btnLogin']")
    WebElement btnLogin;

    //Error message element
    @FindBy(xpath = "//*[@id='spanMessage']")
    WebElement msgError;


    //Methods
    //Type user name
    public void typeUsername(String userName){
        txtUsername.sendKeys(userName);
    }


    //Type password
    public void typePassword(String password){
        txtPassword.sendKeys(password);
    }


    //click login button
    public void clickLogin(){
        btnLogin.click();
    }


    //Get error message
    public String getError(){
        String error = msgError.getText();
        return error;
    }





}
