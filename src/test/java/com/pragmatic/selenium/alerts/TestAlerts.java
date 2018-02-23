package com.pragmatic.selenium.alerts;

import com.pragmatic.util.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestAlerts {

    private WebDriver webDriver;


    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.gecko.driver","E:\\Software\\Drivers\\geckodriver.exe");
        webDriver = new FirefoxDriver();
        webDriver.get(Constants.DEMO_BASE_URL);
    }

    @AfterClass
    public void afterClass(){
        webDriver.close();
    }


    @BeforeMethod
    public void beforeMethod(){

        //Refresh the current page
        webDriver.navigate().refresh();
        //Click the Alert button
        webDriver.findElement(By.id("btnAlert")).click();



    }

    @Test
    public void testAlert(){



        // Click OK button
        webDriver.switchTo().alert().accept();

        //Get the message after closing the alert
        String msgResult = webDriver.findElement(By.id("output")).getText();

        //Verify the result message
        Assert.assertEquals(msgResult, "Alert is gone.");
    }



    @Test
    public void testAlertMessage(){


        //Get the message in the alert
        String msgAlert = webDriver.switchTo().alert().getText();


        //Verify the message
        Assert.assertEquals(msgAlert, "I'm blocking!");

        //Close the alert
        webDriver.switchTo().alert().accept();


    }


}
