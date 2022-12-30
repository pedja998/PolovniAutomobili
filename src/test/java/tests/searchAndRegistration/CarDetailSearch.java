package tests.searchAndRegistration;

import data.CommonStrings;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DetailSearchPage;
import pages.HomePage;
import pages.SpecificSearchPage;
import tests.BaseTest;

import java.time.Duration;

public class CarDetailSearch extends BaseTest {
    private WebDriver driver;
    private String[] auto={"Audi","A4","5000","8000","Benzin","Beograd","4/5 vrata","2005 god.","2020 god."};

    @BeforeMethod
    public void setUpTest(){
        driver=setUpDriver();
    }
    @Test
    public void testDetailSearch(){
        HomePage homePage = new HomePage(driver).open();

        DetailSearchPage detailPage = homePage.clickDetaljnaPretraga();

        Assert.assertTrue(detailPage.verifyDetailPage(),"Nije dobar URL");

        //Unos auta, kroz string definisan pre testa
        detailPage.selectBrand(auto[0]);
        detailPage.selectModel(auto[1]);
        detailPage.insertPrice(auto[2],auto[3]);
        detailPage.selectBodyType(CommonStrings.LIMUZINA);
        detailPage.selectFuelType(auto[4]);
        detailPage.selectRegion(auto[5]);
        detailPage.selectDoors(auto[6]);
        detailPage.setYears(auto[7],auto[8]);

        /*Proveru da li su uspešno prikazane vrednosti sam ostavio nakon unosa vrednosti jer se u nekim slučajevima
        dešava da počne proveru vrenosti pre nego što je promenjeno stanje u placeholder-u
         */
        Assert.assertEquals(detailPage.getPlaceholderText(detailPage.markaPlaceHolder),auto[0]);
        Assert.assertEquals(detailPage.getPlaceholderText(detailPage.modelPlaceHoleder),auto[1]);
        Assert.assertEquals(detailPage.getPlaceholderText(detailPage.fuelPlaceHolder),auto[4]);
        Assert.assertEquals(detailPage.getPlaceholderText(detailPage.regionPlaceHolder),auto[5]);
        Assert.assertEquals(detailPage.getPlaceholderText(detailPage.numberOfDoorsPlaceHolder),auto[6]);
        Assert.assertEquals(detailPage.getPlaceholderText(detailPage.yearFromPlaceholder),auto[7]);
        Assert.assertEquals(detailPage.getPlaceholderText(detailPage.yearToPlaceholder),auto[8]);

        SpecificSearchPage results = detailPage.subbmitSearch();
        Assert.assertTrue(results.verifySearchPage(),"NIJE PROMENJEN URL");
        Assert.assertTrue(results.verifyTitle(),"NIJE PRIKAZAN SEARCH TITLE");
        Assert.assertTrue(results.verifyResults(),"NISU PRIKAZANI REZULTATI PRETRAGE");
    }
    @AfterMethod
    public void tearDownTest(){
        quitDriver(driver);
    }
}
