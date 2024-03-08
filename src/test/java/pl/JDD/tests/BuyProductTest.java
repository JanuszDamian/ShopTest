package pl.JDD.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.JDD.pages.HomePage;

public class BuyProductTest extends BaseTest {

    @Test
    public void buyProductTestFail() {
            new HomePage(driver)
                    .openProductPage("FITT Belts")
                    .addProductToCart();
    }
    @Test
    public void buyProductTest() throws InterruptedException {
        new HomePage(driver)
                .addToCart("FITT Belts")
                .viewCart()
                .openAddressDetails();
    }
}
