package pages;

import methods.WishListMethod;
import org.openqa.selenium.WebDriver;

public class WishListPage extends BasePage {

    public WishListPage(WebDriver driver) {
        super(driver);
    }

    public WishListMethod method;

    // test methods

    // add item to wish list
    public WishListPage addItemToWishList() {
        method = new WishListMethod(driver);
        method.addToWishList();
        return this;
    }

    // remove item from wish list
    public WishListPage removeItemFromWishList() {
        method = new WishListMethod(driver);
        method.removeItemFromWishList();
        return this;
    }


    // verify test methods
    public WishListPage verifyAddItemToWishList() {
        method = new WishListMethod(driver);
        method.verifyAddToWishList();
        return this;
    }

    public WishListPage verifyRemoveItemFromWishList() {
        method = new WishListMethod(driver);
        method.verifyRemoveItemFromWishList("Success: You have modified your wish list!\n" + "×");
        return this;
    }
}
