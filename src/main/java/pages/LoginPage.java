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
    public LoginPage validLogin() {
        methods = new LoginMethods(driver);
        methods.login(
                PropertyManager.getInstance().getEmail(),
                PropertyManager.getInstance().getPassword()
        );
        return this;
    }

    public LoginPage loginWithEmptyEmailField() {
        methods = new LoginMethods(driver);
        methods.loginWithEmptyEmail(PropertyManager.getInstance().getPassword());
        return this;
    }

    public LoginPage loginWithEmptyPasswordField() {
        methods = new LoginMethods(driver);
        methods.loginWithEmptyPassword(PropertyManager.getInstance().getEmail());
        return this;
    }

    // verification methods
    public LoginPage verifyFailLogin() {
        methods = new LoginMethods(driver);
        methods.verifyFailLoginAssertion("Warning: No match for E-Mail Address and/or Password.");
        return this;
    }

    public LoginPage verifyLogin() {
        methods = new LoginMethods(driver);
        methods.verifyValidLogin("My Account");
        return this;
    }

}
