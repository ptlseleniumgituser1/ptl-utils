package com.pragmatic.selenium.timeouts;

import com.pragmatic.util.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExplicitWait {




    @Test
    public void testWaitForTimingAlert(){
        //Create a browser instance
        System.setProperty("webdriver.gecko.driver","E:\\Software\\Drivers\\geckodriver.exe");
        WebDriver webDriver = new FirefoxDriver();
        //Navigate to the demo site
        webDriver.get("http://demosite.pragmatictestlabs.com");

        //Click on Alerts button
        webDriver.findElement(By.id("btnalert")).click();

        //Click on Timing Alert button
        webDriver.findElement(By.id("timingalert")).click();



        //Wait till the alert is present [EXPLICIT WAIT]
       WebDriverWait wait = new WebDriverWait(webDriver, 10000);
       wait.until(ExpectedConditions.alertIsPresent());


        //Switch to the alert and get the message
        String alertMessage = webDriver.switchTo().alert().getText();


        //Verify the message
        Assert.assertEquals(alertMessage, "This is Timing Alert");

        //Close the alert
        webDriver.switchTo().alert().accept();



    }
}
