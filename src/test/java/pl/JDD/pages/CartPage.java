package pl.JDD.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    @FindBy(xpath = "//a[contains(text(),'Proceed to checkout')]")
    private WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//td[@class='product-name']/a")
    private WebElement productInCartName;

    private WebDriver driver;

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public AddressDetailsPage openAddressDetails() {
        proceedToCheckoutButton.click();
        return new AddressDetailsPage(driver);
    }

    public WebElement getProductInCartName() {
        return productInCartName;
    }
}
