package data;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

import java.util.ArrayList;

public class DataCreation extends BasePage {

    public DataCreation(WebDriver driver) {
        super(driver);
    }

    public static ArrayList<String> createData(ArrayList<String> userData) {
        // Faker library
        Faker faker = new Faker();

        // registration data
        userData.add(faker.name().firstName()); // 0 First Name
        userData.add(faker.name().lastName()); // 1 Last Name
        userData.add(faker.internet().emailAddress()); // 2 Email
        userData.add(faker.number().digits(10)); // 3 Telephone
        userData.add(faker.internet().password()); // 4 Password

        return userData;
    }
}
