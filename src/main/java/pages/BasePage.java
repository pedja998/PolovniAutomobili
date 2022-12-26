package pages;

import data.Time;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    WebDriver driver;
    public BasePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    protected void openUrl(String url){
        driver.get(url);
    }
    protected String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
    protected boolean waitForUrlChange(String url, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.urlToBe(url));
    }
    protected WebElement waitForWebElementToBeVisible(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    protected WebElement waitForWebElementToBeClickable(By locator, int timeout){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    protected WebElement waitForWebElementToBeVisible(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    protected WebElement getWebElement(By lokator){
        waitForWebElementToBeVisible(lokator,Time.TIME_SHORTER);
        WebElement element = driver.findElement(lokator);
        return element;
    }
    protected void typeTextToWebElement(WebElement element, String text) {
        waitForWebElementToBeVisible(element, Time.TIME_SHORTER);
        element.sendKeys(text);
    }
    protected void clearTextFromWebElement(WebElement element) {
        waitForWebElementToBeVisible(element, Time.TIME_SHORTER);
        element.clear();
    }
    protected void clearAndTypeTextToWebElement(WebElement element, String text) {
        clearTextFromWebElement(element);
        typeTextToWebElement(element, text);
    }
    protected void clickOnWebElement(WebElement element) {
        element.click();
    }
    protected void clickButton(By locator) {
        clickOnWebElement(getWebElement(locator));
    }
}
