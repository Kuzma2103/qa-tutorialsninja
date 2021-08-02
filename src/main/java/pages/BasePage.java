package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void waitVisibility(By elementRef) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementRef));
    }

    // click on element
    public void click(By elementRef) {
        waitVisibility(elementRef);
        driver.findElement(elementRef).click();
    }

    // write text to element
    public void writeText(By elementRef, String text) {
        waitVisibility(elementRef);
        driver.findElement(elementRef).sendKeys(text);
    }

    // read text from element
    public String readText(By elementRef) {
        waitVisibility(elementRef);
        return driver.findElement(elementRef).getText();
    }

    // compare two strings
    public void assertTwoEqualStrings(String actualText, String expectedText) {
        Assert.assertEquals(actualText, expectedText);
    }

    // check if warning message is displayed
    public boolean checkActiveWarning(By elementRef, String warningText) {
        String element = readText(elementRef);

        if (element.contains(warningText)) {
            System.out.println("Bug found. Guest user cannot make the purchase.");
            return true;
        } else {
            System.out.println("There is no warning message.");
            return false;
        }
    }

}
