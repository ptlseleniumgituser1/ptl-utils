package com.pragmatic.selenium.screenshot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class TakeScreenshotExample {




    @Test
    public void testScreenshots() throws IOException {

        //Open a web browser
        System.setProperty("webdriver.gecko.driver","E:\\Software\\Drivers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        //Navigate to the website
        driver.get( "http://pragmatictestlabs.com");
        driver.manage().window().fullscreen();



        //Create the screenshot (Source file)
        TakesScreenshot  takesScreenshot = ((TakesScreenshot) driver);
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        //Save the screenshot into a physical file (Destination file)
        File destFile = new File("out/screens/homepage.png");
        FileUtils.copyFile(srcFile, destFile);

    }
}
