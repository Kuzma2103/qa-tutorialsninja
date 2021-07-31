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
    By contentTitleBy = By.xpath("//div[@id='content']//h2[text()='My Account']");

    // navigate to login form
    private void navigateToLogin() {
        click(myAccountBy);
        click(loginBy);
    }

    // login method
    public LoginMethods login(String email, String password) {
        navigateToLogin();
        writeText(emailBy, email);
        writeText(passwordBy, password);
        click(loginButtonBy);
        return this;
    }

    // login with empty username field
    public LoginMethods loginWithEmptyEmail(String password) {
        navigateToLogin();
        writeText(passwordBy, password);
        click(loginButtonBy);
        return this;
    }

    // login with empty password field
    public LoginMethods loginWithEmptyPassword(String email) {
        navigateToLogin();
        writeText(emailBy, email);
        click(loginButtonBy);
        return this;
    }

    // verification methods

    // fail login verification
    public LoginMethods verifyFailLoginAssertion(String expectedText) {
        String errorMsg = readText(errorMsgBy);
        assertTwoEqualStrings(errorMsg, expectedText);
        return this;
    }

    // valid login verification
    public LoginMethods verifyValidLogin(String expectedText) {
        String elementText = readText(contentTitleBy);
        assertTwoEqualStrings(elementText, expectedText);
        return this;
    }
}
