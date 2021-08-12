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

    // verification references
    By successElementBy = By.xpath("//div[@class='alert alert-success alert-dismissible']");

    // private methods
    private void navigateToItem() {
        click(camerasNavLinkBy);
        click(itemTitleBy);
    }

    // test methods
    public WishListMethod addToWishList() {
        navigateToItem();
        click(addToWishListBy);
        return this;
    }

    // verification methods
    public WishListMethod verifyAddToWishList() {
        elementIsVisible(successElementBy);
        return this;
    }
}
