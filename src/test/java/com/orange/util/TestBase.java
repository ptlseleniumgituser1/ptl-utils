package com.orange.util;

import com.pragmatic.util.Constants;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver webDriver;

    @BeforeSuite
    public void beforeSuite(){

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        webDriver = new ChromeDriver();



        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //Implicit wait

    }




    @AfterSuite
    public void afterSuite(){
       // webDriver.quit();
    }


    public void check(WebElement chkBox){
        //If not selected click the checkbox
        if(!chkBox.isSelected()){
            chkBox.click();
        }
        //Else do nothing
    }



    public void unCheck(WebElement chkBox){

        //If selected clik the checkbox
        if(chkBox.isSelected()){
            chkBox.click();
        }//Else do nothing
    }

    public void selectByVisibleText(WebElement webElement, String visibleText){

        //Casting the webElement into a Select element
        Select select = (Select) webElement;
        select.selectByVisibleText(visibleText);
    }


    public void selectByIndex(WebElement webElement, int index){
        Select select = (Select) webElement;
        select.selectByIndex(index);
    }

    public void selectByValue(WebElement webElement, String value){
        Select select = (Select) webElement;
        select.selectByValue(value);
    }


    public void waitUntilTextPresent(WebElement webElement, String partialText){
        WebDriverWait wait = new WebDriverWait(webDriver, 30);
        wait.until(ExpectedConditions.textToBePresentInElement(webElement, partialText));

    }



    public void scrollDownForElement (WebElement element){
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", element);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }



}
