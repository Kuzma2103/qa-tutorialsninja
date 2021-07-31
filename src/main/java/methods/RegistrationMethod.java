package methods;

import data.DataCreation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

import java.util.ArrayList;

public class RegistrationMethod extends BasePage {

    public RegistrationMethod(WebDriver driver) {
        super(driver);
    }

    // element references
    By myAccountBy = By.xpath("//span[text()='My Account']");
    By registerBy = By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Register']");

    By firstNameBy = By.id("input-firstname");
    By lastNameBy = By.id("input-lastname");
    By emailBy = By.id("input-email");
    By telephoneBy = By.id("input-telephone");
    By passwordBy = By.id("input-password");
    By confirmPasswordBy = By.id("input-confirm");
    By checkBoxBy = By.xpath("//input[@type='checkbox']");
    By continueButtonBy = By.xpath("//input[@value='Continue']");


    // verification element references
    By messageBy = By.xpath("//div[@id='content']//h1");


    private void navigateToRegisterUser() {
        click(myAccountBy);
        click(registerBy);
    }

    // register user method
    public RegistrationMethod registerUser(ArrayList<String> userData) {
        navigateToRegisterUser();
        DataCreation.createData(userData);

        writeText(firstNameBy, userData.get(0));
        writeText(lastNameBy, userData.get(1));
        writeText(emailBy, userData.get(2));
        writeText(telephoneBy, userData.get(3));
        writeText(passwordBy, userData.get(4));
        writeText(confirmPasswordBy, userData.get(4));
        click(checkBoxBy);
        click(continueButtonBy);

        return this;
    }

    // Verification methods

    // verify user registration method
    public RegistrationMethod verifyRegisterUser(String expectedText) {
        String message = readText(messageBy);
        assertTwoEqualStrings(message, expectedText);
        return this;
    }
}
