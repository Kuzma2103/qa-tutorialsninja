package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.CheckoutPage;

public class RemoveItemFromCartTest extends BaseTest {

    public CheckoutPage checkoutPage;

    @Test
    public void removeItemFromCartTest() throws Exception {
        checkoutPage = new CheckoutPage(driver);

        checkoutPage.removeItemFromCart();

        // test assertion

        try {
            checkoutPage.verifyRemoveItemFromCart();
            System.out.println("Item is removed from cart.");
        } catch (Exception e) {
            Assert.fail("Something went wrong.");
        }
    }
}
