package pages;

import data.CommonStrings;
import data.Time;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActivationSuccessfulPage extends BasePage {
    private final String activationSuccessUrl= CommonStrings.ACTIVATION_SUCCESS_PAGE_URL;
    private final By checkBoxLocators=By.xpath("//input[@type=\"checkbox\"]");
    public final By loginPanelLocator=By.xpath("//div[contains(@class,\"loginPanel\")]");
    private final By submitLocator=By.xpath("//button[@name=\"submit_registration_survey\"]");
    private final By modalDialogLocator=By.xpath("//div[contains(@class,\"uk-modal-dialog\")]");
    private final By modalButtonLocator=By.xpath("//div[contains(@class,\"uk-modal-dialog\")]//child::button");
    public ActivationSuccessfulPage(WebDriver driver){
        super(driver);
    }
    private ActivationSuccessfulPage checkAllBoxes(){
        createListOfElementsAndClickAll(checkBoxLocators);
        return this;
    }
    private ActivationSuccessfulPage clickPotvrdi(){
        clickButton(submitLocator);
        return this;
    }
    private void dialogAnswerYes(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Time.PAGE_LOAD_TIME_OUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(modalDialogLocator));
        clickButton(modalButtonLocator);
    }
    public PolovniSettingsPage checkAndProcede(){
        checkAllBoxes();
        clickPotvrdi();
        dialogAnswerYes();
        return new PolovniSettingsPage(driver);
    }
}
