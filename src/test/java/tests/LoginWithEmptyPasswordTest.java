package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.LoginPage;

public class LoginWithEmptyPasswordTest extends BaseTest {

    public LoginPage loginPage;

    @Test
    public void loginWithEmptyPasswordTest() {
        loginPage = new LoginPage(driver);

        loginPage.loginWithEmptyPasswordField();

        // test assertion

        try {
            loginPage.verifyFailLogin();
            System.out.println("User is not logged in.");
        } catch (Exception e) {
            Assert.fail("Something went wrong.");
        }
    }
}
