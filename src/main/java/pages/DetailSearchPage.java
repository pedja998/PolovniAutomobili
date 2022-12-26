package pages;

import data.CommonStrings;
import data.Time;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DetailSearchPage extends BasePage{
    private final String DetailPageUrl= CommonStrings.DETAIL_SEARCH_URL;
    private final By buttonPollLocator=By.id("btn_poll_no");
    private final By markaSelectLocator= By.xpath("//*[@id=\"search-form\"]/div/form/div[1]/div[1]/div/div[1]/div/div/ul");
    private final By markaPlaceHolder = By.className("placeholder");
    private final By modelPlaceHoleder=By.xpath("//*[@id=\"search-form\"]/div/form/div[1]/div[1]/div/div[2]/div/p/span");
    private final By spisakMarkiLokator=By.xpath("//*[@id=\"search-form\"]/div/form/div[1]/div[1]/div/div[1]/div/div/ul/li");
    private final By modelSelectLocator=By.xpath("//*[@id=\"search-form\"]/div/form/div[1]/div[1]/div/div[2]/div/div/ul");
    private final By modelSpisakLocator=By.xpath("//*[@id=\"search-form\"]/div/form/div[1]/div[1]/div/div[2]/div/div/ul/li");
    private final By bodyPlaceHolder=By.xpath("//*[@id=\"search-form\"]/div/form/div[1]/div[1]/div/div[7]/div/div[1]/div/p/span");
    private final By bodySelectLocator=By.xpath("//*[@id=\"search-form\"]/div/form/div[1]/div[1]/div/div[7]/div/div[1]/div/div/ul");
    private final By karoserijaSpisakLokator=By.xpath("//*[@id=\"search-form\"]/div/form/div[1]/div[1]/div/div[7]/div/div[1]/div/div/ul/li");
    private final By fuelPlaceHolder=By.xpath("//*[contains(text(),\"Vrsta goriva\")]");
    private final By fuelPlaceSelector=By.xpath("//*[@id=\"search-form\"]/div/form/div[1]/div[1]/div/div[8]/div/div/ul");
    private final By fuelItemsLocator=By.xpath("//*[@id=\"search-form\"]/div/form/div[1]/div[1]/div/div[8]/div/div/ul/li");
    private final By regionPlaceHolder=By.xpath("//*[contains(text(),\"Region\")]");
    private final By regionSelectLocator=By.xpath("//*[@id=\"search-form\"]/div/form/div[1]/div[1]/div/div[11]/div/div/ul");
    private final By regionItemsVelikeRegijeLocator=By.xpath("//*[@id=\"search-form\"]/div/form/div[1]/div[1]/div/div[11]/div/div/ul/li[1]/ul/li[1]");
    private final By numberOfDoorsPlaceHolder=By.xpath("//*[contains(text(),\"Broj vrata\")]");
    private final By doorsSelectLocator=By.xpath("//*[@id=\"search-form\"]/div/form/div[1]/div[1]/div/div[12]/div/div/ul");
    private final By doorsItemsLocator=By.xpath("//*[@id=\"search-form\"]/div/form/div[1]/div[1]/div/div[12]/div/div/ul/li");
    private final By priceFromLocator=By.id("price_from");
    private final By priceToLocator=By.id("price_to");
    private final By searchLocator=By.id("submit_1");
    public DetailSearchPage(WebDriver driver){
        super(driver);
    }
    public boolean verifyDetailPage(){
        return waitForUrlChange(DetailPageUrl, Time.TIME_SHORTER);
    }
    public DetailSearchPage pollAnswerNo(){
        clickButton(buttonPollLocator);
        return this;
    }
    private List<WebElement> createListOfItems(By lokatorListe, By lokatorHoldera, By lokatorElemenata){
        WebElement element = driver.findElement(lokatorListe);
        clickButton(lokatorHoldera);
        List<WebElement> options = element.findElements(lokatorElemenata);
        return options;
    }
    public DetailSearchPage selectBrand(String nameOfBrand){
        List<WebElement> options = createListOfItems(markaSelectLocator,markaPlaceHolder, spisakMarkiLokator);
        for (WebElement option : options){
            if (option.getText().equals(nameOfBrand)){
                option.click();
            }
        }
        return this;
    }
    public DetailSearchPage selectModel(String model){
        waitForWebElementToBeClickable(modelPlaceHoleder,Time.TIME_SHORT);
        List<WebElement> options = createListOfItems(modelSelectLocator,modelPlaceHoleder, modelSpisakLocator);
        for (WebElement option : options){
            if (option.getText().equals(model)){
                option.click();
            }
        }
        return this;
    }
    public DetailSearchPage selectBodyType(int ime){
        waitForWebElementToBeVisible(bodyPlaceHolder,Time.TIME_SHORTER);
        List<WebElement> options = createListOfItems(bodySelectLocator,bodyPlaceHolder,karoserijaSpisakLokator);
        options.get(ime).click();
        return this;
    }
    public DetailSearchPage selectFuelType(String tip){
        waitForWebElementToBeVisible(fuelPlaceHolder,Time.TIME_SHORTER);
        List<WebElement> options = createListOfItems(fuelPlaceSelector,fuelPlaceHolder,fuelItemsLocator);
        for (WebElement option : options){
            if (option.getText().equals(tip)){
                option.click();
            }
        }
        return this;
    }
    public DetailSearchPage selectRegion(String naziv){
        waitForWebElementToBeVisible(regionPlaceHolder,Time.TIME_SHORTER);
        List<WebElement> options = createListOfItems(regionSelectLocator,regionPlaceHolder,regionItemsVelikeRegijeLocator);
        for (WebElement option : options){
            if (option.getText().equals(naziv)){
                option.click();
            }
        }
        return this;
    }
    public DetailSearchPage selectDoors(String opis){
        waitForWebElementToBeVisible(numberOfDoorsPlaceHolder,Time.TIME_SHORTER);
        List<WebElement> options = createListOfItems(doorsSelectLocator,numberOfDoorsPlaceHolder,doorsItemsLocator);
        for (WebElement option : options){
            if (option.getText().equals(opis)){
                option.click();
            }
        }
        return this;
    }
    public DetailSearchPage insertPrice(int niza, int visa){
        getWebElement(priceFromLocator).click();
        typeTextToWebElement(getWebElement(priceFromLocator),String.valueOf(5000));
        getWebElement(priceToLocator).click();
        typeTextToWebElement(getWebElement(priceToLocator),String.valueOf(8000));
        return this;
    }

}
