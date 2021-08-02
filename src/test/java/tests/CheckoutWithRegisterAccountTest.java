package tests;

import org.junit.Test;
import pages.CheckoutPage;

import java.util.ArrayList;

public class CheckoutWithRegisterAccountTest extends BaseTest {

    public CheckoutPage checkoutPage;
    ArrayList<String> userData = new ArrayList<>();

    @Test
    public void checkoutWithRegisterAccountTest() {
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.purchaseItemWithRegisterAccount(userData);
    }
}
