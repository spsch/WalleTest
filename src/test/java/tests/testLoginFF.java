package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import pages.Helper;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by svehlak on 29.11.15.
 */
public class testLoginFF implements Helper {

    WebDriver driver;
    LoginPage objLoginPage;

    @BeforeTest
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://app.qa.cashplay.co/wallet/users/sign_in");
    }

    @org.testng.annotations.Test(description = "Login in FF")
    public void testLoginIn() {
        objLoginPage = new LoginPage(driver);

        objLoginPage.LoginToWallet("jansvehlak@cashplay.co", "Cashplay12345");
        String LoginText = driver.findElement(By.xpath("/html/body/div/div[3]/div/h4")).getText();
        Assert.assertEquals(LoginText, "Select the amount to deposit\n" +
                "You have entered a secure page");
        driver.close();
    }

}
