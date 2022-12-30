package pages;

import data.CommonStrings;
import data.Time;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class DetailSearchPage extends BasePage{
    private final String DetailPageUrl= CommonStrings.DETAIL_SEARCH_URL;
    public final By buttonPollLocator=By.id("btn_poll_no");
    private final By markaSelectLocator= By.xpath("//div[@class=\"SumoSelect sumo_brand\"]//child::ul");
    public final By markaPlaceHolder = By.xpath("//div[@class=\"SumoSelect sumo_brand\"]//child::span[1]");
    public final By modelPlaceHoleder=By.xpath("//div[@class=\"SumoSelect sumo_model\"]//child::span[1]");
    private final By modelSelectLocator=By.xpath("//div[@class=\"SumoSelect sumo_model\"]//child::ul");
    public final By bodyPlaceHolder=By.xpath("//div[@class=\"SumoSelect sumo_chassis\"]//child::span[1]");
    private final By bodySelectLocator=By.xpath("//div[@class=\"SumoSelect sumo_chassis\"]//child::ul");

    public final By fuelPlaceHolder=By.xpath("//div[@class=\"SumoSelect sumo_fuel\"]//child::span[1]");
    private final By fuelPlaceSelector=By.xpath("//div[@class=\"SumoSelect sumo_fuel\"]//child::ul");

    public final By regionPlaceHolder=By.xpath("//div[@class=\"SumoSelect sumo_region\"]//child::span[1]");
    private final By regionSelectLocator=By.xpath("//div[@class=\"SumoSelect sumo_region\"]//child::ul");

    public final By numberOfDoorsPlaceHolder=By.xpath("//div[@class=\"SumoSelect sumo_door_num\"]//child::span[1]");
    private final By doorsSelectLocator=By.xpath("//div[@class=\"SumoSelect sumo_door_num\"]//child::ul");
    public final By yearFromPlaceholder=By.xpath("//div[@class=\"SumoSelect sumo_year_from\"]//child::span[1]");
    private final By yearFromSelectLocator=By.xpath("//div[@class=\"SumoSelect sumo_year_from\"]//child::ul");
    public final By yearToPlaceholder=By.xpath("//div[@class=\"SumoSelect sumo_year_to\"]//child::span[1]");
    private final By yearToSelectLocator=By.xpath("//div[@class=\"SumoSelect sumo_year_to\"]//child::ul");
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

    public DetailSearchPage selectBrand(String nameOfBrand){
        selectFromList(markaSelectLocator,markaPlaceHolder,nameOfBrand);
        return this;
    }
    public DetailSearchPage selectModel(String model){
        selectFromList(modelSelectLocator,modelPlaceHoleder,model);
        return this;
    }

    //Ovo sam morao ovako jer ne mogu da uhvatim samo tekst elemenata liste
    public DetailSearchPage selectBodyType(int ime){
        waitForWebElementToBeVisible(bodyPlaceHolder,Time.TIME_SHORTER);
        WebElement element = driver.findElement(bodySelectLocator);
        clickButton(bodyPlaceHolder);
        List<WebElement> options = element.findElements(By.tagName("li"));
        options.get(ime).click();
        return this;
    }
    public DetailSearchPage selectFuelType(String tip){
        selectFromList(fuelPlaceSelector,fuelPlaceHolder,tip);
        return this;
    }
    public DetailSearchPage selectRegion(String naziv){
        selectFromList(regionSelectLocator,regionPlaceHolder,naziv);
        return this;
    }
    public DetailSearchPage selectDoors(String opis){
        selectFromList(doorsSelectLocator,numberOfDoorsPlaceHolder,opis);
        return this;
    }
    public DetailSearchPage insertPrice(String niza, String visa){
        clickOnWebElement(priceFromLocator);
        clearAndTypeTextToWebElement(getWebElement(priceFromLocator),niza);
        clickOnWebElement(priceToLocator);
        clearAndTypeTextToWebElement(getWebElement(priceToLocator),visa);
        return this;
    }
    public DetailSearchPage setYears(String prva, String druga){
        selectFromList(yearFromSelectLocator,yearFromPlaceholder,prva);
        selectFromList(yearToSelectLocator,yearToPlaceholder,druga);
        return this;
    }
    public SpecificSearchPage subbmitSearch(){
        clickButton(searchLocator);
        return new SpecificSearchPage(driver);
    }
}
