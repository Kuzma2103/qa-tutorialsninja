package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.LoginPage;

public class ValidLoginTest extends BaseTest {

    public LoginPage loginPage;

    @Test
    public void ValidLoginTest() {
        loginPage = new LoginPage(driver);

        loginPage.validLogin();

        // test assertion

        try {
            loginPage.verifyLogin();
            System.out.println("User is logged in.");
        } catch (Exception e) {
            Assert.fail("Something went wrong.");
        }
    }
}
