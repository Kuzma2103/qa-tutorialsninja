package tests;

import org.junit.Test;
import pages.CheckoutPage;

import java.util.ArrayList;

public class CheckoutAsGuestTest extends BaseTest {

    public CheckoutPage checkoutPage;
    ArrayList<String> userData = new ArrayList<>();

    @Test
    public void checkoutAsGuestTest() {
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.purchaseItemAsGuest(userData);
    }
}
