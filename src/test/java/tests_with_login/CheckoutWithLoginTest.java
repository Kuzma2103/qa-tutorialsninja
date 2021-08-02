package tests_with_login;

import org.junit.Assert;
import org.junit.Test;
import pages.CheckoutPage;

import java.util.ArrayList;

public class CheckoutWithLoginTest extends BaseTestWithLogin {

    public CheckoutPage checkoutPage;
    ArrayList<String> userData = new ArrayList<>();

    @Test
    public void checkoutWithLoginTest() throws InterruptedException {
        checkoutPage = new CheckoutPage(driver);

        checkoutPage.purchaseItemAsLoggedInUser(userData);

        // test assertion

        try {
            checkoutPage.verifyPurchaseItemAsLoggedInUser();
            System.out.println("User is successfully purchased the product.");
        } catch (Exception e) {
            Assert.fail("Something went wrong.");
        }
    }
}
