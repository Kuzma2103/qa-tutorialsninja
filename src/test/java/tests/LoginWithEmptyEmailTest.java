package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.LoginPage;

public class LoginWithEmptyEmailTest extends BaseTest {

    public LoginPage loginPage;

    @Test
    public void loginWithEmptyPasswordTest() {
        loginPage = new LoginPage(driver);

        loginPage.loginWithEmptyEmailField();

        // test assertion
        try {
            loginPage.verifyloginWithEmptyEmailField();
            System.out.println("User is not logged in.");
        } catch (Exception e) {
            Assert.fail("Something went wrong.");
        }
    }
}
