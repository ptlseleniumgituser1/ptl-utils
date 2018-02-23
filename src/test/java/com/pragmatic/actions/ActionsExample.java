package com.pragmatic.actions;

import com.pragmatic.util.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsExample {



    @Test
    public void testActionsExample(){
        System.setProperty("webdriver.chrome.driver","E:\\Software\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(Constants.ORANGE_BASE_URL);
        WebElement  txtUsername = driver.findElement(By.id("txtUsername"));


        //Create actions instance
        Actions actions = new Actions(driver);

        //Build actions
        Action  action = actions
                .keyDown(txtUsername, Keys.SHIFT)
                .sendKeys(txtUsername, "admin")
                .keyUp(txtUsername, Keys.SHIFT)
                .build();

        //Perform the actions
        action.perform();


    }


}
