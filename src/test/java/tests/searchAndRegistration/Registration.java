package tests.searchAndRegistration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import tests.BaseTest;

import java.io.FileReader;

public class Registration extends BaseTest {
    private WebDriver driver;
    private String part1;
    private String part2;
    private String password;
    private String passwordPravi;
    @BeforeMethod
    public void setUpTest() throws Exception{
        fileReader=new FileReader("C:\\Users\\User\\Desktop\\Comtrade\\PolovniAutomobili\\src\\main\\java\\data\\Page.properties");
        properties.load(fileReader);
        driver=setUpDriver();
        part1=properties.getProperty("userDeo1");
        part2=properties.getProperty("userDeo2");
        password=properties.getProperty("passwordNovi");
        passwordPravi=properties.getProperty("passwordPravi");
    }

    @Test
    public void testRegistration(){
        HomePage homePage = new HomePage(driver).open();

        LoginPage loginPage=homePage.clickPostaviOglas();
        Assert.assertTrue(loginPage.verifyLoginPage(),"NIJE DOBAR URL");

        SignUpPage signUpPage=loginPage.clickRegistrujSe();
        Assert.assertTrue(signUpPage.verifySignUpPage(),"NIJE DOBAR URL");
        signUpPage.fillSignUpForm(part1,part2,password);

        SignUpSuccessfulPage successfulPage = signUpPage.clickSubmit();
        successfulPage.verifySignUpSuccessfulPage();
        Assert.assertTrue(successfulPage.getWebElement(successfulPage.porukaLokator).isDisplayed());

        driver.switchTo().newWindow(WindowType.TAB);
        ProtonPage protonPage = new ProtonPage(driver).open();

        ProtonSignInPage protonSignInPage = protonPage.clickSignIn();
        Assert.assertTrue(protonSignInPage.verifyProtonSignInPage(),"NIJE DOBAR URL!");
        protonSignInPage.fillSignIn(part1,part2,passwordPravi);

        ProtonHomePage protonHomePage=protonSignInPage.clickSignIn();
        protonHomePage.clickUnreadMail();
        protonHomePage.clickActivationMail();
        protonHomePage.clickActivationLink();

        ActivationSuccessfulPage activationSuccessfulPage = protonHomePage.dialogAnswerYes();
        driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
        Assert.assertTrue(activationSuccessfulPage.getWebElement(activationSuccessfulPage.loginPanelLocator).isDisplayed());

        PolovniSettingsPage psp=activationSuccessfulPage.checkAndProcede();
        Assert.assertTrue(psp.verifySettingsPage(),"NIJE DOBAR URL");
        psp.setFields("Marko","Markovic","Markovcanska","Bor","0605555555");
        Assert.assertTrue(psp.getWebElement(psp.alertSuccessLocator).isDisplayed(),"NIJE PRIKAZANA PORUKA ZA USPESNU IZMENU");
        String email=psp.getTextFromElement();
        System.out.println(email);

        homePage= psp.clickLogOut();
        Assert.assertTrue(homePage.verifyHomePage(),"NIJE DOBAR URL");
    }

    @AfterMethod
    public void tearDownTest(){
        quitDriver(driver);
    }
}
