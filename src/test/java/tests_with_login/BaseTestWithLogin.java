package tests_with_login;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.LoginPage;
import utilities.PropertyManager;

import java.util.concurrent.TimeUnit;

public class BaseTestWithLogin {
    public WebDriver driver;
    public ChromeOptions chromeOptions;
    public LoginPage loginPage;

    @Before
    public void setup() {
        // LOAD CHROME OPTIONS
        chromeOptions = new ChromeOptions();
        // disable browser notifications
        chromeOptions.addArguments("--disable-notifications");
        // start browser maximized
        chromeOptions.addArguments("start-maximized");

        // SET CHROME AND FIREFOX DRIVERS
        // chrome
        System.setProperty("webdriver.chrome.driver", PropertyManager.getInstance().getChromeDriverPath());
        // firefox
        System.setProperty("webdriver.gecko.driver", PropertyManager.getInstance().getFirefoxDriverPath());

        // LOAD CHROME BROWSER FOR TESTS - CHANGE THIS METHOD IF YOU WANT FIREFOX BROWSER TO RUN TESTS
        loadChromeBrowser();

        // set implicitly wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // enter url of website
        driver.get(PropertyManager.getInstance().getUrl());

        loginPage = new LoginPage(driver);
        loginPage.validLogin();

    }

    @After
    public void teardown() {
        driver.quit();
    }

    // load chrome browser
    private void loadChromeBrowser() {
        driver = new ChromeDriver(chromeOptions);
    }

    // load firefox browser
    private void loadFirefoxBrowser() {
        driver = new FirefoxDriver();
        // maximize firefox browser
        driver.manage().window().maximize();
    }
}
