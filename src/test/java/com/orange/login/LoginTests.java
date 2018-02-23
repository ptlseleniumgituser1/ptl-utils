package com.orange.login;

import com.pragmatic.util.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class LoginTests {

    private WebDriver driver;


    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver","E:\\Software\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Define implicit wait
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }


    @AfterClass
    public void afterClass(){
        driver.close();
    }


    @BeforeMethod
    public void beforeMethod(){
        driver.get(Constants.ORANGE_BASE_URL);
    }

    @AfterMethod
    public void afterMethod(){

    }



    @Test (enabled = false, groups = {"smoke", "regression"})
    public void testValidUserLogin() throws InterruptedException {

        //Type user name
        driver.findElement(By.id("txtUsername")).sendKeys(Constants.USER_NAME);


        //Type password
        driver.findElement(By.id("txtPassword")).sendKeys(Constants.USER_PASSWORD);

        //Click login button or hit enter key
        driver.findElement(By.id("txtPassword")).submit();



        //Verify the welcome message
        String strWelcomeMessage= driver.findElement(By.id("welcome")).getText();

        Assert.assertEquals(strWelcomeMessage, "Welcome Admin");

    }


    @Test(groups = {"regression"})
    public void testInvalidPassword(){

        //Type user name
        driver.findElement(By.id("txtUsername")).sendKeys(Constants.USER_NAME);


        //Type password
        driver.findElement(By.id("txtPassword")).sendKeys("InvaidPW");

        //Click login button or hit enter key
        driver.findElement(By.id("txtPassword")).submit();


        //Verify the error message

    }


    @Test(groups = {"regression"})
    public void testBlankUsername(){

        //Type user name
        driver.findElement(By.id("txtUsername")).sendKeys("");


        //Type password
        driver.findElement(By.id("txtPassword")).sendKeys(Constants.USER_PASSWORD);

        //Click login button or hit enter key
        driver.findElement(By.id("txtPassword")).submit();


        //Verify the error message

    }


    @Test(groups = {"regression"})
    public void testBlankPassword(){
        //Type user name
        driver.findElement(By.id("txtUsername")).sendKeys(Constants.USER_NAME);


        //Type password
        driver.findElement(By.id("txtPassword")).sendKeys("");

        //Click login button or hit enter key
        driver.findElement(By.id("txtPassword")).submit();


        //Verify the error message
        String errorMessage = driver.findElement(By.id("spanMessage")).getText();
        Assert.assertEquals(errorMessage, "Username cannot be empty");
    }


    @Test(groups = {"regression"})
    public void testBlankUsernameAndPassword(){
               //Type user name
        driver.findElement(By.id("txtUsername")).sendKeys("");


        //Type password
        driver.findElement(By.id("txtPassword")).sendKeys("");

        //Click login button or hit enter key
        driver.findElement(By.id("txtPassword")).submit();


        //Verify the error message
    }


}
