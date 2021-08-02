package pages;

import methods.CheckoutMethod;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutMethod method;

    // purchase as guest method
    public CheckoutPage purchaseItemAsGuest(ArrayList<String> userData) {
        method = new CheckoutMethod(driver);
        method.checkoutAsGuest(userData);
        return this;
    }

    // purchase with register account method
    public CheckoutPage purchaseItemWithRegisterAccount(ArrayList<String> userData) {
        method = new CheckoutMethod(driver);
        method.checkoutWithRegisterAccount(userData);
        return this;
    }

    // purchase with user login
    public CheckoutPage purchaseItemAsLoggedInUser(ArrayList<String> userData) throws InterruptedException {
        method = new CheckoutMethod(driver);
        method.checkoutWithUserLogin(userData);
        return this;
    }

    // verification methods

    // verify purchase as user logged in
    public CheckoutPage verifyPurchaseItemAsLoggedInUser() {
        method = new CheckoutMethod(driver);
        method.verifyCheckoutWithUserLogin("Your order has been placed!");
        return this;
    }
}
