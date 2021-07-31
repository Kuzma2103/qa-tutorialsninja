package methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class LoginMethods extends BasePage {

    public LoginMethods(WebDriver driver) {
        super(driver);
    }

    // element references
    By myAccountBy = By.xpath("//span[text()='My Account']");
    By loginBy = By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Login']");

    By emailBy = By.id("input-email");
    By passwordBy = By.id("input-password");
    By loginButtonBy = By.xpath("//input[@value='Login']");

    // verification element references
    By errorMsgBy = By.xpath("//div[@class='alert alert-danger alert-dismissible']");

    // navigate to login form
    private void navigateToLogin() {
        click(myAccountBy);
        click(loginBy);
    }

    // login with empty username method
    public LoginMethods loginWithEmptyEmail(String password) {
        navigateToLogin();
        writeText(passwordBy, password);
        click(loginButtonBy);
        return this;
    }

    public LoginMethods loginWithEmptyPassword(String email) {
        navigateToLogin();
        writeText(emailBy, email);
        click(loginButtonBy);
        return this;
    }

    // verification methods
    public LoginMethods verifyFailLoginAssertion(String expectedText) {
        String errorMsg = readText(errorMsgBy);
        assertTwoEqualStrings(errorMsg, expectedText);
        return this;
    }
}
