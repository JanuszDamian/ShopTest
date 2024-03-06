package pl.JDD.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

    @FindBy(id = "reg_email")
    private WebElement regEmailInput;

    @FindBy(id = "reg_password")
    private WebElement regPasswordInput;

    @FindBy(name = "register")
    private WebElement regButton;

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(name = "login")
    private WebElement loginButton;

    @FindBy(xpath = "//ul[@class='woocommerce-error']//li")
    private WebElement error;

    private WebDriver driver;

    public AccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public LoggedUserPage registerUser(String email, String password) throws InterruptedException {
        regEmailInput.sendKeys(email);
        regPasswordInput.sendKeys(password);
        Thread.sleep(1000);
        regButton.click();
        regButton.click();

        return new LoggedUserPage(driver);
    }

    public LoggedUserPage logInValidData(String username, String password) {
        logIn(username, password);
        return new LoggedUserPage(driver);
    }

    public AccountPage logInInvalidData(String username, String password) {
        logIn(username, password);
        return this;
    }

    private void logIn(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public WebElement getError() {
        return error;
    }
}
