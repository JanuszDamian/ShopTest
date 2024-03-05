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

}
