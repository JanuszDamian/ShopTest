package pl.JDD.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.JDD.pages.HomePage;

public class BuyProductTest extends BaseTest {

    @Test
    public void buyProductTest() {
            new HomePage(driver)
                    .openProductPage("FITT Belts")
                    .addProductToCart();
    }
}
