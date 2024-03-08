package pl.JDD.tests;

import org.testng.annotations.Test;
import pl.JDD.models.Customer;
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
        Customer customer = new Customer();
        customer.setEmail("dobry@gmail.com");

        new HomePage(driver)
                .addToCart("FITT Belts")
                .viewCart()
                .openAddressDetails()
                .fillAddresDetails(customer);
    }
}
