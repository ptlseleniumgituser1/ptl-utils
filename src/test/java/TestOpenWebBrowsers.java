import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class TestOpenWebBrowsers {


    private String BASE_URL= "http://pragmatictestlabs.com";





    @Test
    public void launchingFirefox(){
        System.setProperty("webdriver.gecko.driver","E:\\Software\\Drivers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get( "http://pragmatictestlabs.com");
        driver.navigate().to("http://pragmatictestlabs.com");

        driver.navigate().forward();
        System.out.println(driver.getTitle());
        driver.manage().window().fullscreen();
    }


    @Test
    public void launchingGoogleChrome(){
        System.setProperty("webdriver.chrome.driver","E:\\Software\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(BASE_URL);
        System.out.println(driver.getTitle());
        driver.manage().window().fullscreen();

    }




    @Test
    public void launchingChromeWithoutInfoBar(){
        System.setProperty("webdriver.chrome.driver","E:\\Software\\Drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        WebDriver driver = new ChromeDriver(options);
        driver.get(BASE_URL);
        System.out.println(driver.getTitle());
    }



    @Test
    public void launchingChromeMaximized (){
        System.setProperty("webdriver.chrome.driver","E:\\Software\\Drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.get(BASE_URL);
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());

        Select drpSelectStatus = (Select) empStatus;
        drpSelectStatus.selectByValue("Enabled");
        drpSelectStatus.selectByIndex(0);
        drpSelectStatus.selectByVisibleText("Enabled");



    }
    //Add this to Add Employee class
    @FindBy(xpath = "//input[@id='empStatus]")
    WebElement empStatus;
    public void setEnabled(){
        setStatus("Enabled");

    }

    public void setDisabled (){
        setStatus("Disabled");
    }

    private void setStatus(String status ){
        Select drpSelectStatus = (Select) empStatus;
        drpSelectStatus.selectByValue(status);
    }




    @Test
    public void launchingChromeHeadless (){
        System.setProperty("webdriver.chrome.driver","E:\\Software\\Drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        WebDriver driver = new ChromeDriver(options);
        driver.get(BASE_URL);
        System.out.println(driver.getTitle());
    }





    @Test
    public void launchingIEBrowser(){
        System.setProperty("webdriver.ie.driver","E:\\Software\\Drivers\\IEDriverServer.exe");
        WebDriver driver = new InternetExplorerDriver();
        driver.get(BASE_URL);
        System.out.println(driver.getTitle());

    }

    @Test
    public void launchingEdgeBrowser(){
        System.setProperty("webdriver.edge.driver","E:\\Software\\Drivers\\MicrosoftWebDriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get(BASE_URL);
        System.out.println(driver.getTitle());

    }



    @Test
    public void minimizingBrowser () throws Exception{
        System.setProperty("webdriver.chrome.driver","E:\\Software\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get(BASE_URL);
        System.out.println(driver.getTitle());
        Robot robot= new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_D);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_D);
    }





}
