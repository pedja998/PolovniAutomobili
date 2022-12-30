package pages;

import data.CommonStrings;
import data.Time;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage extends BasePage{
    private final String signUpUrl= CommonStrings.SIGN_UP_URL;
    private final By submitLocator= By.name("login");
    private final By emailLocator=By.id("email");
    private final By passwordLocator=By.id("password_first");
    private final By repetePasswordLocator=By.id("password_second");
    private final By checkBoxLocators=By.xpath("//input[contains(@type,\"checkbox\")]");
    public SignUpPage(WebDriver driver){
        super(driver);
    }
    public boolean verifySignUpPage(){
        return waitForUrlChange(signUpUrl, Time.TIME_SHORTER);
    }

    private SignUpPage insertEmail(String part1, String part2){
        String email=part1+"+"+randomSixNumbers()+part2;
        clearAndTypeTextToWebElement(getWebElement(emailLocator),email);
        return this;
    }
    private SignUpPage insertPassword(String password){
        clearAndTypeTextToWebElement(getWebElement(passwordLocator),password);
        return this;
    }
    private SignUpPage repetePassword(String password){
        clearAndTypeTextToWebElement(getWebElement(repetePasswordLocator),password);
        return this;
    }
    private SignUpPage clickAllCheckBox(){
        createListOfElementsAndClickAll(checkBoxLocators);
        return this;
    }
    public SignUpPage fillSignUpForm(String emailPart1, String emailPart2, String password){
        insertEmail(emailPart1,emailPart2);
        insertPassword(password);
        repetePassword(password);
        clickAllCheckBox();
        return this;
    }
    public SignUpSuccessfulPage clickSubmit(){
        clickButton(submitLocator);
        return new SignUpSuccessfulPage(driver);
    }
}
