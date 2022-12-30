package pages;

import data.CommonStrings;
import data.Time;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProtonSignInPage extends BasePage{
    private final String protonSignInUrl= CommonStrings.PROTON_SIGNIN_PAGE;
    private final By signInLocator= By.xpath("//button[contains(@type,\"submit\")]");
    private final By usernameLocator=By.id("username");
    private final By passwordLocator=By.id("password");

    public ProtonSignInPage (WebDriver driver){
        super(driver);
    }
    public boolean verifyProtonSignInPage(){
        return waitForUrlChange(protonSignInUrl, Time.TIME_SHORTER);
    }
    private ProtonSignInPage setUsername(String part1, String part2){
        String email=part1+part2;
        clearAndTypeTextToWebElement(getWebElement(usernameLocator),email);
        return this;
    }
    private ProtonSignInPage setPassword(String password){
        clearAndTypeTextToWebElement(getWebElement(passwordLocator),password);
        return this;
    }
    public ProtonSignInPage fillSignIn(String part1,String part2, String password){
        setUsername(part1,part2);
        setPassword(password);
        return this;
    }
    public ProtonHomePage clickSignIn(){
        clickButton(signInLocator);
        return new ProtonHomePage(driver);
    }
}
