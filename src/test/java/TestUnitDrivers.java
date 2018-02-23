import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class TestUnitDrivers {


    public static void main(String[] args) {


//        FirefoxBinary firefoxBinary = new FirefoxBinary();
//        firefoxBinary.addCommandLineOptions("--headless");
        System.setProperty("webdriver.gecko.driver","E:\\Software\\Drivers\\geckodriver.exe");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
//        firefoxOptions.setBinary(firefoxBinary);
//        FirefoxDriver driver = new FirefoxDriver(firefoxOptions);
        FirefoxDriver driver = new FirefoxDriver();

        driver.get("http://opensource.demo.orangehrmlive.com/");
        System.out.println(driver.getTitle());




    }
}
