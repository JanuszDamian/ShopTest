package pl.JDD.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.JDD.pages.HomePage;

public class LogInTest extends BaseTest {

    @Test
    public void logInTest() {
        WebElement dashboardLink = new HomePage(driver)
                .openAccountPage()
                .logInValidData("test1233911", "qwerty1029384756alskdjfh")
                .getDashboardLink();

        Assert.assertEquals(dashboardLink.getText(), "Dashboard");
    }

    @Test
    public void logInWithInvalidPasswordTest() {
        WebElement error = new HomePage(driver)
                .openAccountPage()
                .logInInvalidData("test1233911", "qwerty1029384756alskdjfb")
                .getError();

        Assert.assertTrue(error.getText().contains(" The password you entered for the username "), "Expected error text doesn't match");
    }
}
