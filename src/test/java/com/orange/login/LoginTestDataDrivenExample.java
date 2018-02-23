package com.orange.login;

import com.orange.util.OrangeTestData;
import com.pragmatic.util.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class LoginTestDataDrivenExample {

    private WebDriver driver;


    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "E:\\Software\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Define implicit wait
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }


    @AfterClass
    public void afterClass() {
        driver.close();
    }


    @BeforeMethod
    public void beforeMethod() {
        driver.get(Constants.ORANGE_BASE_URL);
    }


    @Test(dataProvider = "login-tests-data")
    public void testUserLoginWithDataSource(String userName, String password, String expectOutcome) throws InterruptedException {

        //Type user name
        driver.findElement(By.id("txtUsername")).sendKeys(userName);


        //Type password
        driver.findElement(By.id("txtPassword")).sendKeys(password);

        //Click login button or hit enter key
        driver.findElement(By.id("txtPassword")).submit();


        //Verify the welcome message
        String strWelcomeMessage = driver.findElement(By.id("spanMessage")).getText();

        Assert.assertEquals(strWelcomeMessage, expectOutcome);

    }


    @Test(dataProvider = "orange-test-data", dataProviderClass = OrangeTestData.class)
    public void testUserloginExternalDataSource(String userName, String password, String expectOutcome) throws InterruptedException {

        //Type user name
        driver.findElement(By.id("txtUsername")).sendKeys(userName);


        //Type password
        driver.findElement(By.id("txtPassword")).sendKeys(password);

        //Click login button or hit enter key
        driver.findElement(By.id("txtPassword")).submit();


        //Verify the welcome message
        String strWelcomeMessage = driver.findElement(By.id("spanMessage")).getText();

        Assert.assertEquals(strWelcomeMessage, expectOutcome);

    }


    @DataProvider(name="login-tests-data")
    public Object[][] loginTestData(){
        return new  Object[][]{
                {"", "", "Username cannot be empty"},
                {"", "Admin", "Username cannot be empty"},
                {"Admin", "", "Password cannot be empty"},
                {"Admin", "InvalidPW", "Invalid credentials"}
        };
    }


}
