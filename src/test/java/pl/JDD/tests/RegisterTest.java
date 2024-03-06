package pl.JDD.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.JDD.pages.HomePage;

public class RegisterTest extends BaseTest {

    @Test
    public void registerUserTest() throws InterruptedException {
        int random = (int) (Math.random() * 1000);

        WebElement dashboardLink = new HomePage(driver)
                .openAccountPage()
                .registerUser("test" + random + "@test" + random + ".pl", "gax457nfaei8dgfhdfhjgfdfgh")
                .getDashboardLink();

        Assert.assertEquals(dashboardLink.getText(), "Dashboard");
    }
}
