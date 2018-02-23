package com.moolahsense;

import com.orange.util.TestBase;
import com.paulhammant.ngwebdriver.NgWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest  extends TestBase{



    @Test
    public void testValidUserLogin(){

        String welcomeMessage = "Kunwar Bir Singh,";
        webDriver.get(MSData.BASE_URL);
        webDriver.findElement(By.id("username")).sendKeys(MSData.user);
        webDriver.findElement(By.id("password")).sendKeys(MSData.password);
        webDriver.findElement(By.id("btn-Login")).click();

        waitUntilTextPresent(webDriver.findElement(By.id("investorName")),welcomeMessage);
        Assert.assertEquals(webDriver.findElement(By.id("investorName")).getText(),welcomeMessage);


    }



    @Test
    public void scrollToSubscribe(){

        webDriver.get(MSData.BASE_URL);
        webDriver.findElement(By.id("username")).sendKeys(MSData.user);
        webDriver.findElement(By.id("password")).sendKeys(MSData.password);
        webDriver.findElement(By.id("btn-Login")).click();

        WebElement subscribeButton= webDriver.findElement(By.name("subscribeAutoAllocation"));
        scrollDownForElement(subscribeButton);
        //subscribeButton.click();

        Actions actions = new Actions(webDriver);
        actions.moveToElement(subscribeButton).click(subscribeButton).click().perform();
        webDriver.get("http://qa.moolahsense.com/AutoAllocation/AAInvestor");


        new NgWebDriver((JavascriptExecutor) webDriver).waitForAngularRequestsToFinish();
        webDriver.findElement(By.id("nofcampaign")).clear();
        webDriver.findElement(By.id("nofcampaign")).sendKeys("12");





    }




}
