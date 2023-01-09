package pages;

import data.CommonStrings;
import data.Time;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PrijavaPage extends BasePage {
    private final String prijavaPageUrl= CommonStrings.PRIJAVA_PAGE_URL;
    private final By daljeBtnLocator=By.id("next-step");
    private final By usernameFieldLocator=By.name("_username");
    private final By passwordFieldLocator=By.name("_password");
    private final By prijaviSeBtnLocator=By.name("login");

    public PrijavaPage(WebDriver driver){
        super(driver);
    }
    public boolean verifyPrijavaPage(){
        return waitForUrlChange(prijavaPageUrl, Time.TIME_SHORTER);
    }
    private void setUsernameAndProceed(String username){
        typeTextToWebElement(getWebElement(usernameFieldLocator),username);
        clickButton(daljeBtnLocator);
    }
    public HomePage proceedToProfilePage(String username, String password){
        setUsernameAndProceed(username);
        typeTextToWebElement(getWebElement(passwordFieldLocator),password);
        clickButton(prijaviSeBtnLocator);
        return new HomePage(driver);
    }
}
