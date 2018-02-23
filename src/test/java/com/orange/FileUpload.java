package com.orange;

import com.pragmatic.util.Constants;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FileUpload {
    WebDriver webDriver;


    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "E:\\Software\\Drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //Implicit wait
        webDriver.get(Constants.ORANGE_BASE_URL);

    }

    @AfterClass
    public void afterClass(){
        //webDriver.close();
    }



    @Test
    public void testFileUpload() throws Exception {

        webDriver.findElement(By.id("txtUsername")).sendKeys("Admin");
        webDriver.findElement(By.id("txtPassword")).sendKeys("admin");
        webDriver.findElement(By.id("txtPassword")).submit();
        webDriver.findElement(By.id("menu_pim_viewPimModule")).click();
        //webDriver.findElement(By.id("menu_pim_addEmployee")).click();
        webDriver.get("http://opensource.demo.orangehrmlive.com/index.php/pim/addEmployee");


        //Click browse button
        webDriver.findElement(By.id("photofile")).click();

        Screen screen = new Screen();
        screen.type("D:\\training\\jmeterTraining\\oct2017\\java\\util\\pics\\FileUploadInputField.PNG", "D:\\training\\jmeterTraining\\oct2017\\java\\util\\pics\\FileUploadInputField.PNG");



        screen.click("D:\\training\\jmeterTraining\\oct2017\\java\\util\\pics\\FileUploadOpenButton.PNG");








    }

}
