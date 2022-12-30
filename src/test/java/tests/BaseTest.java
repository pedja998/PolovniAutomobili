package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.WebDriverUtils;

import java.io.FileReader;
import java.util.Properties;

public class BaseTest {
    public static FileReader fileReader;
    public static Properties properties = new Properties();
    protected WebDriver setUpDriver() {
        return WebDriverUtils.setUpWebDriver();
    }
    protected void quitDriver(WebDriver driver) {
        WebDriverUtils.quitWebDriver(driver);
    }
}
