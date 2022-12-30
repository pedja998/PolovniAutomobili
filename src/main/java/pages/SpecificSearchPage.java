package pages;

import data.CommonStrings;
import data.Time;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SpecificSearchPage extends BasePage{
    private final String SearchPageUrl= CommonStrings.SPECIFIC_SEARCH_PAGE;
    private final By resultContainerLocator= By.id("search-results");
    private final By searchTitleLocator=By.className("searchTitle");
    public SpecificSearchPage (WebDriver driver){
        super(driver);
    }
    public boolean verifySearchPage(){
        return waitForUrlChange(SearchPageUrl, Time.TIME_SHORTER);
    }
    public boolean verifyTitle(){
        return getWebElement(searchTitleLocator).isDisplayed();
    }
    public boolean verifyResults(){
        return getWebElement(resultContainerLocator).isDisplayed();
    }
}
