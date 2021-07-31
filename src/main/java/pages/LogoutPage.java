package pages;


import methods.LogoutMethod;
import org.openqa.selenium.WebDriver;

public class LogoutPage extends BasePage {

    public LogoutPage(WebDriver driver) {
        super(driver);
    }

    public LogoutMethod method;


    // logout method
    public LogoutPage logout() {
        method = new LogoutMethod(driver);
        method.logoutUser();
        return this;
    }

    // verify logout method
    public LogoutPage verifyLogout() {
        method = new LogoutMethod(driver);
        method.verifyLogoutUser("Account Logout");
        return this;
    }
}
