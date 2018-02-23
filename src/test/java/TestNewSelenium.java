import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNewSelenium {

    private WebDriver webDriver;


    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.geko.driver", "E:\\temp\\geckodriver-v0.19.1-win64.\\geckodriver.exe");
        webDriver = new FirefoxDriver();
    }


    @AfterClass
    public void afterClass(){
        webDriver.close();
    }

    @Test
    public void testMethod1(){
        System.out.println("Hello Selenium ");
        webDriver.get("http://www.google.com");
    }



    @Test
    public void testEcommerceSiteLogin(){

        webDriver.navigate().to("https://www.linkedin.com/notifications/");
        webDriver.findElement(By.linkText("Log on"));
        webDriver.findElement(By.className("LogonTextBox"));
        webDriver.findElement(By.className("LogonTextBox"));

    }
}
