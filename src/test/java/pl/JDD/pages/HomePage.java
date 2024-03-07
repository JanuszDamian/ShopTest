package pl.JDD.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(xpath = "//a[contains(text(),'Account')]")
    private WebElement accountLink;

    @FindBy(xpath = "//li[@class='top-cart'")
    private WebElement myCartButton;

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public AccountPage openAccountPage() {
        accountLink.click();
        return new AccountPage(driver);
    }

    public ProductPage openProductPage(String title) {
        driver.findElement(By.xpath("//h3/a[text()='"+ title +"']")).click();
        return new ProductPage(driver);

    }

    public HomePage addToCart(String title) {
        driver.findElement(By.xpath("//h3/a[contains(text(),'"+ title +"')]/following::a[@rel='nofollow'][1]")).click();
        return this;
    }

    public CartPage viewCart() {
        myCartButton.click();
        return new CartPage(driver);
    }
}

