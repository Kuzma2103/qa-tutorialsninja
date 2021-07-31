package tests_with_login;

import org.junit.Assert;
import org.junit.Test;
import pages.LogoutPage;

public class LogoutTest extends BaseTestWithLogin {
    public LogoutPage logoutPage;

    @Test
    public void logoutTest() {
        logoutPage = new LogoutPage(driver);

        logoutPage.logout();

        // test assertion
        try {
            logoutPage.verifyLogout();
            System.out.println("User is logged out.");
        } catch (Exception e) {
            Assert.fail("Something went wrong.");
        }
    }
}
