package pl.JDD.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.JDD.models.Customer;
import pl.JDD.pages.CartPage;
import pl.JDD.pages.HomePage;
import pl.JDD.pages.OrderDetailsPage;

public class BuyProductTest extends BaseTest {

    @Test
    public void cartCheckTest() throws InterruptedException {

        CartPage cartPage =
                new HomePage(driver)
                        .addToCart("FITT Belts")
                        .viewCart();

        Assert.assertEquals(cartPage.getProductInCartName().getText(), "FITT Belts");

    }

    @Test
    public void buyProductTest() throws InterruptedException {

        Customer customer = new Customer();
        customer.setEmail("dobry@gmail.com");

        OrderDetailsPage orderDetailsPage =
                new HomePage(driver)
                        .addToCart("FITT Belts")
                        .viewCart()
                        .openAddressDetails()
                        .fillAddresDetails(customer);

        Assert.assertEquals(orderDetailsPage.getConfirmOrder().getText(), "Thank you. Your order has been received.");
    }
}
