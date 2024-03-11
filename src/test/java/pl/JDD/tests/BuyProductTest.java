package pl.JDD.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.JDD.models.Customer;
import pl.JDD.pages.CartPage;
import pl.JDD.pages.HomePage;
import pl.JDD.pages.OrderDetailsPage;

public class BuyProductTest extends BaseTest {

    @Test
    public void cartCheckTest() throws InterruptedException {
        ExtentTest testCart = extentReports.createTest("Cart Test");
        CartPage cartPage =
                new HomePage(driver)
                        .addToCart("FITT Belts")
                        .viewCart();

        Assert.assertEquals(cartPage.getProductInCartName().getText(), "FITT Belts");
        testCart.log(Status.PASS,"Cart Test Assertion passed");
    }

    @Test
    public void buyProductTest() throws InterruptedException {
        ExtentTest testProd = extentReports.createTest("Buy Product Test");
        Customer customer = new Customer();
        customer.setEmail("dobry@gmail.com");

        OrderDetailsPage orderDetailsPage =
                new HomePage(driver)
                        .addToCart("FITT Belts")
                        .viewCart()
                        .openAddressDetails()
                        .fillAddresDetails(customer);

        Assert.assertEquals(orderDetailsPage.getConfirmOrder().getText(), "Thank you. Your order has been received.");
        testProd.log(Status.PASS,"Buy Product Assertion passed");
    }
}
