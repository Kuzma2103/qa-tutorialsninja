package tests_with_login;

import org.junit.Assert;
import org.junit.Test;
import pages.WishListPage;

public class AddToWishListTest extends BaseTestWithLogin {

    public WishListPage wishListPage;

    @Test
    public void addToWishListTest() {

        wishListPage = new WishListPage(driver);

        wishListPage.addItemToWishList();

        // test assertion
        try {
            wishListPage.verifyAddItemToWishList();
            System.out.println("Item is on wishlist.");
        } catch (Exception e) {
            Assert.fail("Something went wrong.");
        }
    }
}
