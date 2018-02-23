package com.pragmatic.selenium.alerts;

import com.pragmatic.util.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestSwitchWindow {

    WebDriver  webDriver;
    private String demositeURL= "http://demosite.pragmatictestlabs.com";

    @BeforeClass
    public void beforeClass(){
        //Create a browser instance
        System.setProperty("webdriver.gecko.driver","E:\\Software\\Drivers\\geckodriver.exe");
        webDriver = new FirefoxDriver();

    }


    @AfterClass
    public void afterClass(){
        //webDriver.close();
    }


    @BeforeMethod
    public void beforeMethod(){
        //Navigate to demo site and clicking browser window button
        webDriver.get(demositeURL);
        webDriver.findElement(By.id("btnbrowserwindows")).click();

    }

    @Test
    public void testOpenNewBrowserTab() throws Exception{

        //Get the current/parent window handle
        String currentHandle = webDriver.getWindowHandle();
        System.out.printf("Parent window title " + webDriver.getTitle());

        //Click the link "Click Hear to Open New Browser Tab"

        webDriver.findElement(By.linkText("Click Hear to Open New Browser Tab")).click();

        Thread.sleep(10000); //Should not be used

        for (String handle : webDriver.getWindowHandles()){
            System.out.println("Window handle " + handle);
            webDriver.switchTo().window(handle);
        }

        System.out.printf("New window title " + webDriver.getTitle());

        webDriver.switchTo().window(currentHandle);

        System.out.printf("Parent window title " + webDriver.getTitle());

    }

    @Test
    public void testOpenPopupWindow(){
        //Click "Separate new window" link

        //Click "Click Hear to Open New Browser Tab"
    }


}
