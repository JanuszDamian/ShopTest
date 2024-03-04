package pl.JDD.tests;

import org.testng.annotations.Test;
import pl.JDD.pages.HomePage;

public class RegisterTest extends BaseTest{

    @Test
    public void registerUserTest() {
         new HomePage(driver).openAccountPage();


    }
}
