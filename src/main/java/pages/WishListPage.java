package pages;

import methods.WishListMethod;
import org.openqa.selenium.WebDriver;

public class WishListPage extends BasePage {

    public WishListPage(WebDriver driver) {
        super(driver);
    }

    public WishListMethod method;

    // test methods
    public WishListPage addItemToWishList() {
        method = new WishListMethod(driver);
        method.addToWishList();
        return this;
    }

    // verify test methods
    public WishListPage verifyAddItemToWishList() {
        method = new WishListMethod(driver);
        method.verifyAddToWishList();
        return this;
    }
}
