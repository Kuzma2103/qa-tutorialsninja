package pages;

import methods.RegistrationMethod;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public RegistrationMethod method;

    // Test methods

    // register user method
    public RegistrationPage registerUser(ArrayList<String> userData) {
        method = new RegistrationMethod(driver);
        method.registerUser(userData);
        return this;
    }

    // Verification methods

    public RegistrationPage verifyRegisterUser() {
        method = new RegistrationMethod(driver);
        method.verifyRegisterUser("Your Account Has Been Created!");
        return this;
    }
}
