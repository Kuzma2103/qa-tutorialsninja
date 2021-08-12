package methods;

import data.DataCreation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

import java.util.ArrayList;

public class ContactMethod extends BasePage {

    public ContactMethod(WebDriver driver) {
        super(driver);
    }

    // element references
    By contactLinkFooterBy = By.xpath("//ul[@class='list-unstyled']//li//a[text()='Contact Us']");
    By nameBy = By.id("input-name");
    By emailBy = By.id("input-email");
    By enquiryBy = By.id("input-enquiry");
    By submitButtonBy = By.xpath("//input[@value='Submit']");

    // verify element references
    By elementTextBy = By.xpath("//div[@id='content']//h1[text()='Contact Us']");

    // test methods

    // contact us method
    public ContactMethod contactUs(ArrayList<String> userData) {
        DataCreation.createData(userData);
        click(contactLinkFooterBy);
        writeText(nameBy, userData.get(0));
        writeText(emailBy, userData.get(2));
        writeText(enquiryBy, userData.get(8));
        click(submitButtonBy);
        return this;
    }

    // verify methods

    public ContactMethod verifyContactUs(String expectedText) {
        String elementText = readText(elementTextBy);
        assertTwoEqualStrings(elementText, expectedText);
        return this;
    }
}
