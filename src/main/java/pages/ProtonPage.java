package pages;

import data.CommonStrings;
import data.Time;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProtonPage extends BasePage{
    private final String protonPageUrl= CommonStrings.PROTON_PAGE_URL;
    private final By signInLocator= By.xpath("//a[contains(@href,\"login\")]");
    public ProtonPage(WebDriver driver){
        super(driver);
    }
    public ProtonPage open(){
        openUrl(protonPageUrl);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Time.TIME_SHORT));
        wait.until(ExpectedConditions.elementToBeClickable(getWebElement(signInLocator)));
        return this;
    }
    public ProtonSignInPage clickSignIn(){
        clickButton(signInLocator);
        return new ProtonSignInPage(driver);
    }
}
