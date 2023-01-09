package pages;

import data.CommonStrings;
import data.Time;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class HomePage extends BasePage {
    private final String homePageUrl= CommonStrings.HOME_PAGE_URL;
    private final By detaljnaPretragaLokator =By.name("isDetailed");
    private final By searchFormLocator = By.xpath("//div[contains(@class,\"search-holder-box\")]");
    private final By postaviOglasLocator=By.xpath("//a[contains(@class,\"top-menu-submit\")]");
    private final By prijaviSeLocator=By.xpath("//div[contains(@class,\"uk-button-dropdown inline-block top-dropdown\")]//child::a[contains(@title,\"Prijavi se\")]");
    private final By emailLocator=By.xpath("//*[@class=\"uk-button-dropdown inline-block top-dropdown\"]//child::span[contains(text(),'proton')]");
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
    public PrijavaPage clickPrijaviSe(){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//div[contains(@class,\"top-menu\")]"))).perform();
        getWebElement(prijaviSeLocator).click();
        return new PrijavaPage(driver);
    }
    public String getEmail(){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//div[contains(@class,\"top-menu\")]"))).perform();
        String email = getWebElement(emailLocator).getText();
        return email;
    }
    public ProtonHomePage closeTabsAndReturnToMail(){
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(0));
        driver.close();
        driver.switchTo().window(tabs2.get(2));
        driver.close();
        driver.switchTo().window(tabs2.get(1));
        return new ProtonHomePage(driver);
    }
}
