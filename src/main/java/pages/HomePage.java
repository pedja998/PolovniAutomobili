package pages;

import data.CommonStrings;
import data.Time;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {
    private final String homePageUrl= CommonStrings.HOME_PAGE_URL;
    private final By detaljnaPretragaLokator =By.name("isDetailed");
    private final By searchFormLocator = By.xpath("//div[contains(@class,\"search-holder-box\")]");
    private final By postaviOglasLocator=By.xpath("//a[contains(@class,\"top-menu-submit\")]");
    public HomePage(WebDriver driver){
        super(driver);
    }
    public HomePage open(){
        openUrl(homePageUrl);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Time.TIME_SHORT));
        wait.until(ExpectedConditions.elementToBeClickable(getWebElement(detaljnaPretragaLokator)));
        return this;
    }
    public boolean verifyHomePage(){
        return waitForUrlChange(homePageUrl,Time.TIME_SHORTER);
    }
    public DetailSearchPage clickDetaljnaPretraga(){
        clickOnWebElement(detaljnaPretragaLokator);
        return new DetailSearchPage(driver);
    }
    public LoginPage clickPostaviOglas(){
        clickButton(postaviOglasLocator);
        return new LoginPage(driver);
    }
}
