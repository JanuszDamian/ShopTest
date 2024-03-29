package pl.JDD.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.JDD.models.Customer;
import pl.JDD.utils.SeleniumHelper;

public class AddressDetailsPage {

    @FindBy(id = "billing_first_name")
    private WebElement billingFirstNameInput;

    @FindBy(id = "billing_last_name")
    private WebElement billingLastNameInput;

    @FindBy(id = "billing_company")
    private WebElement billingCompanyInput;

    @FindBy(id = "select2-billing_country-container")
    private WebElement CountrySelect;

    @FindBy(id = "billing_address_1")
    private WebElement billingAddress1Input;

    @FindBy(id = "billing_address_2")
    private WebElement billingAddress2Input;

    @FindBy(id = "billing_postcode")
    private WebElement billingPostCodeInput;

    @FindBy(id = "billing_city")
    private WebElement billingCityInput;

    @FindBy(id = "billing_email")
    private WebElement billingEmailInput;

    @FindBy(id = "billing_phone")
    private WebElement billingPhoneInput;

    @FindBy(id = "createaccount")
    private WebElement createAccountCheckbox;

    @FindBy(id = "payment_method_bacs")
    private WebElement bankTransferCheckbox;

    @FindBy(xpath = "//input[@value='cheque']")
    private WebElement checkPaymentsCheckbox;

    @FindBy(id = "payment_method_cod")
    private WebElement cashOnDeliveryCheckbox;

    @FindBy(id = "payment_method_paypal")
    private WebElement payPalCheckbox;

    @FindBy(id = "order_comments")
    private WebElement orderComments;

    @FindBy(id = "place_order")
    private WebElement placeOrderButton;

    private WebDriver driver;

    private static final Logger logger = LogManager.getLogger();

    public AddressDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public OrderDetailsPage fillAddresDetails(Customer customer) throws InterruptedException {
        logger.info("Filling out the required data on the AddresDetails form");
        billingFirstNameInput.sendKeys(customer.getFirstName());
        billingLastNameInput.sendKeys(customer.getLastName());
        billingCompanyInput.sendKeys(customer.getCompanyName());
        billingAddress1Input.sendKeys(String.format("%s %s", customer.getStreet(), customer.getFlatNumber()));
        orderComments.sendKeys(customer.getOrderComments());
        billingPostCodeInput.sendKeys(customer.getZipCode());
        billingCityInput.sendKeys(customer.getCity());
        billingPhoneInput.sendKeys(customer.getPhone());
        billingEmailInput.sendKeys(customer.getEmail());
        Thread.sleep(1500);
        SeleniumHelper.waitForClickable(placeOrderButton, driver);
        placeOrderButton.click();
        logger.info("Order confirmed");

        return new OrderDetailsPage(driver);
    }
}
