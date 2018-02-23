package com.pragmatic.wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class FluentWaitExample {


    private String BASE_URL= "http://opensource.demo.orangehrmlive.com/";



    @Test
    public void launchingFirefox(){
        System.setProperty("webdriver.gecko.driver","E:\\Software\\Drivers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get( BASE_URL);
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("");
        driver.findElement(By.id("txtPassword")).click();

        //Wait till a message text is appear in the span element
        



    }

}
