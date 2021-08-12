package tests_with_login;

import org.junit.Assert;
import org.junit.Test;
import pages.WishListPage;

public class RemoveFromWishListTest extends BaseTestWithLogin {

    public WishListPage wishListPage;

    @Test
    public void removeItemFromWishListTest() {

        wishListPage = new WishListPage(driver);

        wishListPage.removeItemFromWishList();

        // test assertion
        try {
            wishListPage.verifyRemoveItemFromWishList();
            System.out.println("Item is removed from wishlist.");
        } catch (Exception e) {
            Assert.fail("Something went wrong.");
        }
    }
}
