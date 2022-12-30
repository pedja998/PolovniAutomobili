package pages;

import com.fasterxml.jackson.databind.ser.Serializers;
import data.CommonStrings;
import data.Time;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PolovniSettingsPage extends BasePage {
    private final By nameLocator=By.id("first_name");
    private final By lastNameLocator=By.id("last_name");
    private final By addressLocator=By.id("address");
    private final By cityLocator=By.id("city");
    private final By phoneNumberLocator=By.id("cellphone");
    private final By saveBtnLocator=By.id("submit");
    private final By gradDropDown=By.xpath("//div[contains(@class,\"uk-open\")]//child::ul");

    public final By alertSuccessLocator=By.xpath("//div[contains(@class,\"alert-success\")]");
    public final By emailAddressLocator=By.xpath("//span[contains(@class,\"ym-hide\")]");
    public final By dropDownMenu=By.xpath("//div[contains(@class,\"button-dropdown\")]");
    private final By logoutLocator=By.xpath("//div[contains(@class,\"uk-button-dropdown inline-block top-dropdown\")]//child::a[contains(@title,\"Odjavite se\")]");

    private final String settingsPageUrl= CommonStrings.POLOVNI_SETTINGS_PAGE_URL;
    public PolovniSettingsPage(WebDriver driver){
        super(driver);
    }
    public boolean verifySettingsPage(){
        return waitForUrlChange(settingsPageUrl, Time.TIME_SHORTER);
    }
    public PolovniSettingsPage setFields(String firstName, String lastName, String address, String city,String phone){
        clearAndTypeTextToWebElement(getWebElement(nameLocator),firstName);
        clearAndTypeTextToWebElement(getWebElement(lastNameLocator),lastName);
        clearAndTypeTextToWebElement(getWebElement(addressLocator),address);
        clearAndTypeTextToWebElement(getWebElement(cityLocator),city);
        selectFromList2(gradDropDown,city);
        clearAndTypeTextToWebElement(getWebElement(phoneNumberLocator),phone);
        clickSave();
        return this;
    }
    private PolovniSettingsPage clickSave(){
        getWebElement(saveBtnLocator).click();
        return this;
    }
    public HomePage clickLogOut(){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//div[contains(@class,\"top-menu\")]"))).perform();
        getWebElement(logoutLocator).click();
        return new HomePage(driver);
    }
    public String getTextFromElement(){
        return getWebElement(emailAddressLocator).getText();
    }
}
