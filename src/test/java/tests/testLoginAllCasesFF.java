package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.Helper;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by svehlak on 4.2.16.
 */
public class testLoginAllCasesFF implements Helper {

    WebDriver driver;
    LoginPage objLoginPage;

    @BeforeTest
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://app.qa.cashplay.co/wallet/users/sign_in");
    }

    @org.testng.annotations.Test(description="no email provided for login, password is")
    public void testLoginANoEmail() {
        objLoginPage = new LoginPage(driver);

        objLoginPage.LoginToWallet("", PWD);
        String MissingEmail = driver.findElement(By.xpath("/html/body/div/div[1]")).getText();
        Assert.assertEquals(MissingEmail, "×\n" +
                "Invalid email or password.");

    }
    @org.testng.annotations.Test(description = "email is provided to login, password  does not")
    public void testLoginBPageNoPwd() {
        objLoginPage = new LoginPage(driver);
        objLoginPage.LoginToWallet(USERNAME,"");
        String MissingPassword = driver.findElement(By.xpath("/html/body/div/div[1]")).getText();
        Assert.assertEquals(MissingPassword, "×\n" +
                "Invalid email or password.");
    }

    @org.testng.annotations.Test(description = "no credentials at all - login")
    public void testLoginCNoCredentials() {
        objLoginPage = new LoginPage(driver);
        objLoginPage.LoginToWallet("","");
        String NoPWD = driver.findElement(By.xpath("/html/body/div/div[1]")).getText();
        Assert.assertEquals(NoPWD, "×\n" +
                "Invalid email or password.");
    }

    @org.testng.annotations.Test(description = "Login in with valid credentials")
    public void testLoginZIn() {
        objLoginPage = new LoginPage(driver);
        WebElement LoginField = driver.findElement(By.id("user_email"));
        LoginField.clear();
        objLoginPage.LoginToWallet(USERNAME, PWD);
        String LoginText = driver.findElement(By.xpath("/html/body/div/div[3]/div/h4")).getText();
        Assert.assertEquals(LoginText, "Select the amount to deposit\n" +
                "You have entered a secure page");
    }

    @AfterTest
    public void teardown() {

        driver.quit();
    }
}
