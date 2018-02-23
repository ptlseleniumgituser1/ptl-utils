package com.orange;

import com.pragmatic.util.Constants;
import com.pragmatic.util.DataSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestLogin {

    WebDriver webDriver;


    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.gecko.driver", "E:\\Software\\Drivers\\geckodriver.exe");
        webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.get(Constants.ORANGE_BASE_URL);

    }

    @AfterClass
    public void afterClass(){
        webDriver.close();
    }


    @BeforeMethod
    public void beforeMethod(){
        webDriver.navigate().refresh();
    }

    @Test(dataProvider = "user-credentials")
    public void testInvalidLogin(String userName, String password, String expectedMsg) throws Exception {

        webDriver.findElement(By.id("txtUsername")).sendKeys(userName);
        webDriver.findElement(By.id("txtPassword")).sendKeys(password);
        webDriver.findElement(By.id("txtPassword")).submit();
        String errorMessage = webDriver.findElement(By.id("spanMessage")).getText();
        Thread.sleep(10000); //Not efficient. NOT recommended
        Assert.assertEquals(errorMessage, expectedMsg);

    }



    @Test(dataProvider = "user-credentials-external", dataProviderClass = DataSource.class)
    public void testInvalidLogin2(String userName, String password, String expectedMsg) {

        webDriver.findElement(By.id("txtUsername")).sendKeys(userName);
        webDriver.findElement(By.id("txtPassword")).sendKeys(password);
        webDriver.findElement(By.id("txtPassword")).submit();
        String errorMessage = webDriver.findElement(By.id("spanMessage")).getText();
        Assert.assertEquals(errorMessage, expectedMsg);

    }

    //Step 1 : Add @DataProvider annotation with a name
    //Step 2 : Create a method which returns an Object array
    //Step 3 : Add return statement
    //Step 4 : Add test data
    //Step 5 : Link the test method with data provider
    // 5.1 : Add dataProvider name into the test method
    // 5.2 : Add the parameters into the test method
    //NOTE : Parameters count and the data types should be matched
    //Step 6 : Use the parameters inside the test method

    @DataProvider(name = "user-credentials")
    public Object[][] userCredentials(){
        return new Object[][]{
                {"", "", "Username cannot be empty"},
                {"Admin", "", "Password cannot be empty"},
                {"", "admin", "Username cannot be empty"},
                {"Test3ed", "asdf", "Invalid credentials"}
        };
    }






}
