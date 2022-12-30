package pages;

import data.CommonStrings;
import data.Time;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpSuccessfulPage extends BasePage{
    private final String successfulPageUrl= CommonStrings.SIGN_UP_SUCCESSFUL_URL;
    public final By porukaLokator= By.xpath("//*[contains(text(),'Hvala')]");

    public SignUpSuccessfulPage(WebDriver driver){
        super(driver);
    }
    public boolean verifySignUpSuccessfulPage(){
        return waitForUrlChange(successfulPageUrl, Time.TIME_SHORTER);
    }
}
