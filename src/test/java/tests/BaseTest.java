package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.WebDriverUtils;

public class BaseTest {
    protected WebDriver setUpDriver() {
        return WebDriverUtils.setUpWebDriver();
    }
    protected void quitDriver(WebDriver driver) {
        WebDriverUtils.quitWebDriver(driver);
    }
}
