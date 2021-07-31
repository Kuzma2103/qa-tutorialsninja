package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.RegistrationPage;
import utilities.PropertyManager;

import java.util.ArrayList;

public class RegistrationTest extends BaseTest {

    public RegistrationPage registrationPage;
    ArrayList<String> userData = new ArrayList<>();

    @Test
    public void registrationUserTest() {
        registrationPage = new RegistrationPage(driver);

        registrationPage.registerUser(userData);

        // test assertion

        try {
            registrationPage.verifyRegisterUser();
            System.out.println("User is registered.");
            PropertyManager.writeProperty("firstName", userData.get(0));
            PropertyManager.writeProperty("lastName", userData.get(1));
            PropertyManager.writeProperty("email", userData.get(2));
            PropertyManager.writeProperty("telephone", userData.get(3));
            PropertyManager.writeProperty("password", userData.get(4));
        } catch (Exception e) {
            Assert.fail("Something went wrong.");
        }
    }
}
