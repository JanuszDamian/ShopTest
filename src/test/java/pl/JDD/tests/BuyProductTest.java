package pl.JDD.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
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
        customer.setFirstName("Jan");
        customer.setLastName("Kowalski");
        customer.setCompanyName("BMB");
        customer.setStreet("Produkcyjna");
        customer.setFlatNumber("23");
        customer.setZipCode("15-800");
        customer.setCity("Białystok");
        customer.setPhone("111111111");
        customer.setEmail("test@test123.pl");

        new HomePage(driver)
                .addToCart("FITT Belts")
                .viewCart()
                .openAddressDetails()
                .fillAddresDetails(customer);
    }
}
