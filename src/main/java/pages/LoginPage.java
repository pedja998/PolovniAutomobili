package pages;

import data.CommonStrings;
import data.Time;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    private final String loginPageUrl= CommonStrings.LOGIN_PAGE_URL;
    private final By registrujBtnLocator= By.xpath("//a[text()=\"Registruj se\"]");

    public LoginPage(WebDriver driver){
        super(driver);
    }
    public boolean verifyLoginPage(){
        return waitForUrlChange(loginPageUrl, Time.TIME_SHORTER);
    }
    public SignUpPage clickRegistrujSe(){
        clickButton(registrujBtnLocator);
        return new SignUpPage(driver);
    }
}
