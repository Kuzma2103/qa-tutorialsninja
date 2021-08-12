package pages;

import methods.ContactMethod;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class ContactPage extends BasePage {

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    public ContactMethod method;


    // test methods

    // contact us method
    public ContactPage contactUs(ArrayList<String> userData) {
        method = new ContactMethod(driver);
        method.contactUs(userData);
        return this;
    }

    // verification methods
    public ContactPage verifyContactUs() {
        method = new ContactMethod(driver);
        method.verifyContactUs("Contact Us");
        return this;
    }
}
