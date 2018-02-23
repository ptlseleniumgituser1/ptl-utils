package com.pragmatic.selenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class XPathExample {
    private WebDriver driver;
    private String BASE_URL="http://opensource.demo.orangehrmlive.com/";


    @BeforeTest
    public void beforeTest(){
        System.setProperty("webdriver.gecko.driver","E:\\Software\\Drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get( BASE_URL);
        driver.navigate().forward();
        System.out.println(driver.getTitle());
        driver.manage().window().fullscreen();
    }


    @Test
    public void testLoginXPathExample1(){
        driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name='txtPassword'")).submit();
    }


}
