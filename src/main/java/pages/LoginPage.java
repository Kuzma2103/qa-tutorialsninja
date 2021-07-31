package pages;

import methods.LoginMethods;
import org.openqa.selenium.WebDriver;
import utilities.PropertyManager;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginMethods methods;

    // test methods
    public LoginPage loginWithEmptyEmailField() {
        methods = new LoginMethods(driver);
        methods.loginWithEmptyEmail(PropertyManager.getInstance().getPassword());
        return this;
    }

    // verification methods
    public LoginPage verifyloginWithEmptyEmailField() {
        methods = new LoginMethods(driver);
        methods.verifyFailLogin(" Warning: No match for E-Mail Address and/or Password.");
        return this;
    }
}
