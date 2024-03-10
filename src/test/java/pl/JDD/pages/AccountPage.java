package pl.JDD.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.JDD.utils.SeleniumHelper;

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

    private static final Logger logger = LogManager.getLogger();

    public AccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public LoggedUserPage registerUser(String email, String password) throws InterruptedException {
        logger.info("Filling out the required data on the RegisterUser form");
        regEmailInput.sendKeys(email);
        regPasswordInput.sendKeys(password);
        Thread.sleep(1500);
        SeleniumHelper.waitForClickable(regButton, driver);
        regButton.click();
        logger.info("Filling out the required data on the RegisterUser form - done");
        return new LoggedUserPage(driver);
    }

    public LoggedUserPage logInValidData(String username, String password) {
        logger.info("completing the correct login details");
        logIn(username, password);
        logger.info("completing the correct login details - done");
        return new LoggedUserPage(driver);
    }

    public AccountPage logInInvalidData(String username, String password) {
        logger.info("completing the incorrect login details");
        logIn(username, password);
        logger.info("completing the incorrect login details - done");
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
