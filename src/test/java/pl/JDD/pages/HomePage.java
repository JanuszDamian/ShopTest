package pl.JDD.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.JDD.utils.SeleniumHelper;

public class HomePage {

    @FindBy(xpath = "//a[contains(text(),'Account')]")
    private WebElement accountLink;

    @FindBy(xpath = "//li[@class='top-cart']")
    private WebElement myCartButton;

    private WebDriver driver;

    private static final Logger logger = LogManager.getLogger();

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public AccountPage openAccountPage() {
        logger.info("Open AccountPage");
        accountLink.click();
        logger.info("Open AccountPage done");
        return new AccountPage(driver);
    }

    public ProductPage openProductPage(String title) {
        driver.findElement(By.xpath("//h3/a[text()='" + title + "']")).click();
        return new ProductPage(driver);

    }

    public HomePage addToCart(String title) throws InterruptedException {
        logger.info("adding a product to the cart");
        By productXpath = By.xpath("//h3/a[contains(text(),'" + title + "')]/following::a[@rel='nofollow'][1]");
        SeleniumHelper.waitForClickable(productXpath,driver);
        driver.findElement(productXpath).click();
        logger.info("adding a product to the cart - done");
        Thread.sleep(1000);
        return this;
    }

    public CartPage viewCart() {
        logger.info("Open cartPage");
        myCartButton.click();
        logger.info("Open cartPage - done");
        return new CartPage(driver);
    }

}

