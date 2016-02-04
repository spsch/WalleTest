package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.name;

/**
 * Created by svehlak on 29.11.15.
 */
public class LoginPage {

    WebDriver driver;
    By LoginEmail = By.id("user_email");
    By LoginPassword = By.id("user_password");
    By LoginButton = name("commit");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void InputLogin(String LoginName) {
        driver.findElement(LoginEmail).sendKeys(LoginName);
    }

    public void InputPassword(String Password) {
        driver.findElement(LoginPassword).sendKeys(Password);
    }

    public void ClickLoginButton() {
        driver.findElement(LoginButton).click();
    }

    public void LoginToWallet(String LoginName, String Password) {
        this.InputLogin(LoginName);
        this.InputPassword(Password);
        this.ClickLoginButton();

    }
}
