package tests.searchAndRegistration;

import data.CommonStrings;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DetailSearchPage;
import pages.HomePage;
import tests.BaseTest;

import java.time.Duration;

public class CarDetailSearch extends BaseTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUpTest(){
        driver=setUpDriver();
    }
    @Test
    public void testDetailSearch(){
        HomePage homePage = new HomePage(driver).open();

        DetailSearchPage detailPage = homePage.clickDetaljnaPretraga();
        Assert.assertTrue(detailPage.verifyDetailPage(),"Nije dobar URL");
        detailPage.pollAnswerNo();
        detailPage.selectBrand("Audi");
        detailPage.selectModel("A4");
        detailPage.insertPrice(5000,8000);
        detailPage.selectBodyType(CommonStrings.LIMUZINA);
        detailPage.selectFuelType("Benzin");
        detailPage.selectRegion("Beograd");
        detailPage.selectDoors("4/5 vrata");

    }
    @AfterMethod
    public void tearDownTest(){
        quitDriver(driver);
    }
}
