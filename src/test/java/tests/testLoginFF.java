package tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by svehlak on 29.11.15.
 */
public class testLoginFF {

    WebDriver driver;
    LoginPage objLoginPage;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://app.qa.cashplay.co/wallet");
    }

    @Test
    public void testLoginIn() {
        objLoginPage = new LoginPage(driver);

        objLoginPage.LoginToWallet("jansvehlak@cashplay.co", "Cashplay12345");
    }


}
