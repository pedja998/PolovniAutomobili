package utils;

import data.Time;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.time.Duration;
import java.util.Set;

public class WebDriverUtils {

    public static WebDriver setUpWebDriver(){
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver","C:\\BrowserDrivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("C:\\Users\\User\\Desktop\\Comtrade\\extension_5_3_3_0.crx"));
        driver=new ChromeDriver(options);
        String originalWindow = driver.getWindowHandle();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Time.IMPLICIT_TIME_OUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Time.PAGE_LOAD_TIME_OUT));
        driver.manage().window().maximize();
        driver.switchTo().window(originalWindow);
        return driver;
    }
    public static void quitWebDriver(WebDriver driver){
        driver.quit();
    }
}
