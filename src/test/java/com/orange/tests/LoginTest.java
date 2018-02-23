package com.orange.tests;

import com.orange.pages.LandingPage;
import com.orange.pages.LoginPage;
import com.orange.util.TestBase;
import com.pragmatic.util.Constants;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {





    @Test
    public void testBlankUsername(){
        //MAGIC CODE
        webDriver.get(Constants.ORANGE_BASE_URL);
        LoginPage loginPage = PageFactory.initElements(webDriver, LoginPage.class);
        loginPage.typeUsername("");
        loginPage.typePassword("admin");
        loginPage.clickLogin();
        Assert.assertEquals(loginPage.getError(),"Username cannot be empty");
    }


    @Test
    public void testBlankPassword(){
        webDriver.get(Constants.ORANGE_BASE_URL);
        LoginPage loginPage = PageFactory.initElements(webDriver, LoginPage.class);
        loginPage.typeUsername("Admin");
        loginPage.typePassword("");
        loginPage.clickLogin();
        Assert.assertEquals(loginPage.getError(),"Password cannot be empty");
    }


    @Test
    public void testBlankUsernameAndPassword(){
        //MAGIC CODE
        webDriver.get(Constants.ORANGE_BASE_URL);
        LoginPage loginPage = PageFactory.initElements(webDriver, LoginPage.class);
        loginPage.typeUsername("");
        loginPage.typePassword("");
        loginPage.clickLogin();
        Assert.assertEquals(loginPage.getError(),"Username cannot be empty");
    }



    @Test
    public void testValidUserLogin(){
        webDriver.get(Constants.ORANGE_BASE_URL);
        LoginPage loginPage = PageFactory.initElements(webDriver, LoginPage.class);
        loginPage.typeUsername("Admin");
        loginPage.typePassword("admin");
        loginPage.clickLogin();
        //Initialize the landing page
        LandingPage landingPage= PageFactory.initElements(webDriver, LandingPage.class);
        String welcomeMessage= landingPage.getWelcomeMessage();
        Assert.assertEquals(welcomeMessage, "Welcome Admin");

    }

















}
