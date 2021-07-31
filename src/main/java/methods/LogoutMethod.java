package methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class LogoutMethod extends BasePage {

    public LogoutMethod(WebDriver driver) {
        super(driver);
    }

    // element references
    By myAccountBy = By.xpath("//a[@class='dropdown-toggle']//span[@class='hidden-xs hidden-sm hidden-md']");
    By logoutLinkBy = By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//li//a[text()='Logout']");

    // assertion element references
    By messageBy = By.xpath("//div[@id='content']//h1");


    // log out user method
    public LogoutMethod logoutUser() {
        click(myAccountBy);
        click(logoutLinkBy);
        return this;
    }

    // verification method
    public LogoutMethod verifyLogoutUser(String expectedText) {
        String message = readText(messageBy);
        assertTwoEqualStrings(message, expectedText);
        return this;
    }
}
