package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.LoginPage;

public class LoginWithWrongUserDataTest extends BaseTest {

    public LoginPage loginPage;

    @Test
    public void loginWithWrongUserDataTest() {
        loginPage = new LoginPage(driver);

        loginPage.loginWithWrongUserData();

        // test assertion

        try {
            loginPage.verifyFailLogin();
            System.out.println("User is not logged in.");
        } catch (Exception e) {
            Assert.fail("Something went wrong.");
        }
    }
}
