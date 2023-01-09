package pages;

import data.CommonStrings;
import data.Time;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProtonHomePage extends BasePage {
    private final String protonHomeUrl= CommonStrings.PROTON_HOME_PAGE_URL;
    private final By unreadMailBtnLocator=By.xpath("//button[contains(text(),\"Unread\")]");
    private final By activationLinkLocator=By.xpath("//a[contains(@href,\"aktivacija\")]");
    private final By aktivacioniMailLocator=By.xpath("//div[contains(@class,\"unread\")]");
    private final By polovniMailLocator=By.xpath("//div[contains(@data-testid,\"Aktivirajte\")]");
    private final By dialogFormLocator=By.xpath("//div[@class=\"modal-two\"]");
    public final By dialogOpenNewTabYesBtn=By.xpath("//div[@class=\"modal-two\"]//child::button[2]");
    private final By allMailBtnLocator=By.xpath("//button[contains(text(),\"All\")]");
    private final By trashBtnLocator=By.xpath("//div[contains(@class,\"flex toolbar-inner\")][1]//child::button[contains(@data-testid,\"toolbar:movetotrash\")]");
    public ProtonHomePage(WebDriver driver){
        super(driver);
    }
    public boolean verifyProtonHomePage(){
        return waitForUrlChange(protonHomeUrl, Time.TIME_SHORTER);
    }
    public ProtonHomePage clickUnreadMail(){
        clickButton(unreadMailBtnLocator);
        return this;
    }
    public ProtonHomePage clickActivationLink(){
        waitForWebElementToBeVisible(By.tagName("iframe"),Time.TIME_SHORT);
        driver.switchTo().frame(0);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", getWebElement(activationLinkLocator));
        getWebElement(activationLinkLocator).click();
        driver.switchTo().defaultContent();
        return this;
    }
    public ProtonHomePage clickActivationMail(){
        clickButton(aktivacioniMailLocator);
        return this;
    }
    public ActivationSuccessfulPage dialogAnswerYes(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Time.PAGE_LOAD_TIME_OUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(dialogFormLocator));
        clickButton(dialogOpenNewTabYesBtn);
        return new ActivationSuccessfulPage(driver);
    }
    public ProtonHomePage deleteActivationMail(){
        clickButton(allMailBtnLocator);
        clickButton(trashBtnLocator);
        return this;
    }
}
