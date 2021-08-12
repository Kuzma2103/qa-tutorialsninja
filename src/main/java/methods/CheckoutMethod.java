package methods;

import data.DataCreation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;

import java.util.ArrayList;

public class CheckoutMethod extends BasePage {

    public CheckoutMethod(WebDriver driver) {
        super(driver);
    }

    // element references
    By macbookTitleBy = By.xpath("//div[@class='caption']//h4//a[text()='MacBook']");
    By addToCartBy = By.id("button-cart");
    By cartButtonBy = By.id("cart-total");
    By checkoutButtonBy = By.xpath("//a//strong[text()=' Checkout']");

    // radio inputs
    By guestCheckoutRadioBy = By.xpath("//input[@value='guest']");
    By registerAccountRadioBy = By.xpath("//input[@value='register']");

    // buttons
    By buttonAccountBy = By.id("button-account");
    By buttonGuestBy = By.id("button-guest");
    By buttonRegisterBy = By.id("button-register");
    By buttonPaymentAddressBy = By.id("button-payment-address");
    By buttonShippingAddressBy = By.id("button-shipping-address");
    By buttonShippingMethodBy = By.id("button-shipping-method");
    By buttonPaymentMethodBy = By.id("button-payment-method");
    By buttonConfirmBy = By.id("button-confirm");
    By removeItemButtonBy = By.xpath("//button[@title='Remove']");
    By directAddToCartBy = By.xpath("//*[@id='content']/div[2]/div[2]/div/div[3]/button[1]");

    // form data
    By firstNameBy = By.id("input-payment-firstname");
    By lastNameBy = By.id("input-payment-lastname");
    By emailBy = By.id("input-payment-email");
    By telephoneBy = By.id("input-payment-telephone");
    By addressBy = By.id("input-payment-address-1");
    By cityBy = By.id("input-payment-city");
    By postCodeBy = By.id("input-payment-postcode");
    By passwordBy = By.id("input-payment-password");
    By confirmPasswordBy = By.id("input-payment-confirm");

    // selections
    By countryBy = By.id("input-payment-country");
    By regionStateBy = By.id("input-payment-zone");

    // checkbox
    By termsConditionsCheckmarkBy = By.xpath("//input[@type='checkbox'][@name='agree']");

    // for purchasing camera
    By camerasLinkBy = By.xpath("//ul[@class='nav navbar-nav']//li//a[text()='Cameras']");
    By cameraTitleBy = By.xpath("//div[@class='caption']//h4//a[text()='Nikon D300']");


    // warning message
    By warningMessageBy = By.xpath("//div[@class='alert alert-warning alert-dismissible']");

    // assertion element references
    By messageBy = By.xpath("//div[@id='content']//h1");
    By cartTotalBy = By.id("cart-total");


    // add item to the cart
    private void buyItem() {
        click(macbookTitleBy);
        click(addToCartBy);
        click(cartButtonBy);
        click(checkoutButtonBy);
    }

    // fill the form with user data
    private void fillUserData(ArrayList<String> userData) {
        writeText(firstNameBy, userData.get(0));
        writeText(lastNameBy, userData.get(1));
        writeText(emailBy, userData.get(2));
        writeText(telephoneBy, userData.get(3));
        writeText(addressBy, userData.get(5));
        writeText(cityBy, userData.get(6));
        writeText(postCodeBy, userData.get(7));
        // selection
        Select country = new Select(driver.findElement(countryBy));
        country.selectByValue("243");
        Select state = new Select(driver.findElement(regionStateBy));
        state.selectByValue("3994");
    }

    // fill password and confirm password field for purchase with register account
    private void fillPassword(String password) {
        writeText(passwordBy, password);
        writeText(confirmPasswordBy, password);
    }

    // fill the form for first purchase after user registration
    private void fillBillingDetails(ArrayList<String> userData) {
        writeText(firstNameBy, userData.get(0));
        writeText(lastNameBy, userData.get(1));
        writeText(addressBy, userData.get(5));
        writeText(cityBy, userData.get(6));
        writeText(postCodeBy, userData.get(7));
        // selection
        Select country = new Select(driver.findElement(countryBy));
        country.selectByValue("243");
        Select state = new Select(driver.findElement(regionStateBy));
        state.selectByValue("3994");
        click(buttonPaymentAddressBy);
    }

    // checkout as a guest user
    public CheckoutMethod checkoutAsGuest(
            ArrayList<String> userData
    ) {
        buyItem();
        click(guestCheckoutRadioBy);
        click(buttonAccountBy);

        DataCreation.createData(userData);

        // fill the form
        fillUserData(userData);

        click(buttonGuestBy);
        checkActiveWarning(
                warningMessageBy,
                "Warning: No Payment options are available. Please contact us for assistance!"
        );
        return this;
    }

    // checkout with register account
    public CheckoutMethod checkoutWithRegisterAccount(ArrayList<String> userData) {
        buyItem();
        click(registerAccountRadioBy);
        click(buttonAccountBy);
        DataCreation.createData(userData);
        fillUserData(userData);
        fillPassword(userData.get(4));
        click(termsConditionsCheckmarkBy);
        click(buttonRegisterBy);
        checkActiveWarning(
                warningMessageBy,
                "Warning: No Payment options are available. Please contact us for assistance!"
        );
        return this;
    }

    // checkout with login user - purchasing the photo camera nikon d300
    public CheckoutMethod checkoutWithUserLogin(ArrayList<String> userData) throws InterruptedException {
        click(camerasLinkBy);
        click(cameraTitleBy);
        click(addToCartBy);
        click(cartButtonBy);
        click(checkoutButtonBy);

        // check if it's first purchase after registration.
        // If it is user must fill the form, otherwise don't.

        if ( driver.findElement(firstNameBy).isDisplayed()) {
            DataCreation.createData(userData);
            fillBillingDetails(userData);
        }

        click(buttonPaymentAddressBy);
        click(buttonShippingAddressBy);
        click(buttonShippingMethodBy);
        click(termsConditionsCheckmarkBy);
        click(buttonPaymentMethodBy);
        click(buttonConfirmBy);
        // wait to load next page
        Thread.sleep(2000);

        return this;
    }

    // remove item from cart
    public CheckoutMethod removeItem() throws Exception {
        click(directAddToCartBy);
        // pause to load element
        Thread.sleep(1000);
        click(cartButtonBy);
        click(removeItemButtonBy);
        return this;
    }

    // verification methods

    // verify purchase as login user
    public CheckoutMethod verifyCheckoutWithUserLogin(String expectedText) {
        String message = readText(messageBy);
        assertTwoEqualStrings(message, expectedText);
        return this;
    }

    public CheckoutMethod verifyRemoveItem(String expectedText) {
        String elementText = readText(cartTotalBy);
        assertTwoEqualStrings(elementText, expectedText);
        return this;
    }
}
