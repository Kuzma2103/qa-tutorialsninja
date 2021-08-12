package methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class WishListMethod extends BasePage {

    public WishListMethod(WebDriver driver) {
        super(driver);
    }

    // element references
    By camerasNavLinkBy = By.xpath("//ul[@class='nav navbar-nav']//li//a[text()='Cameras']");
    By itemTitleBy = By.xpath("//div[@class='caption']//h4//a[text()='Nikon D300']");
    By addToWishListBy = By.xpath("//button[@type='button'][@data-original-title='Add to Wish List']");

    By wishListLinkBy = By.id("wishlist-total");
    By removeItemButtonBy = By.xpath("//a[@data-original-title='Remove']");

    // verification references
    By successElementBy = By.xpath("//div[@class='alert alert-success alert-dismissible']");

    // private methods
    private void navigateToItem() {
        click(camerasNavLinkBy);
        click(itemTitleBy);
    }

    // test methods

    // add item to wish list
    public WishListMethod addToWishList() {
        navigateToItem();
        click(addToWishListBy);
        return this;
    }

    // remove item from wishlist
    public WishListMethod removeItemFromWishList() {
        addToWishList();
        click(wishListLinkBy);
        click(removeItemButtonBy);
        return this;
    }

    // verification methods
    public WishListMethod verifyAddToWishList() {
        elementIsVisible(successElementBy);
        return this;
    }

    public WishListMethod verifyRemoveItemFromWishList(String expectedText) {
        String successMessage = readText(successElementBy);
        assertTwoEqualStrings(successMessage, expectedText);
        return this;
    }
}
