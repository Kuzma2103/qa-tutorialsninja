package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropertyManager {

    // set up
    private static String chromeDriverPath;
    private static String firefoxDriverPath;

    private static String url;

    // registration data
    private static String firstName;
    private static String lastName;
    private static String email;
    private static String telephone;
    private static String password;

    // wrong user data
    private static String bad_email;
    private static String bad_password;

    public static PropertyManager getInstance() {

        Properties properties = new Properties();
        PropertyManager instance = new PropertyManager();

        // set path to configuration.properties file and load the file
        try {
            FileInputStream file = new FileInputStream("src/main/resources/configuration.properties");
            properties.load(file);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // set up
        chromeDriverPath = properties.getProperty("chromeDriverPath");
        firefoxDriverPath = properties.getProperty("firefoxDriverPath");

        url = properties.getProperty("url");

        // registration data
        firstName = properties.getProperty("firstName");
        lastName = properties.getProperty("lastName");
        email = properties.getProperty("email");
        telephone = properties.getProperty("telephone");
        password = properties.getProperty("password");

        // wrong user data
        bad_email = properties.getProperty("bad_email");
        bad_password = properties.getProperty("bad_password");

        return instance;
    }

    // Vrite user data to configuration.properties file
    public static void writeProperty(String key, String value) {

        Properties editProperties = new Properties();

        // Load file for store the values
        try {
            FileInputStream editFile = new FileInputStream("src/main/resources/configuration.properties");
            editProperties.load(editFile);
            editProperties.setProperty(key, value);
            editProperties.store(new FileOutputStream("src/main/resources/configuration.properties"), null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // getters
    public String getChromeDriverPath() {
        return chromeDriverPath;
    }

    public String getFirefoxDriverPath() {
        return firefoxDriverPath;
    }

    public String getUrl() {
        return url;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getPassword() {
        return password;
    }

    public String getBadEmail() {
        return bad_email;
    }

    public String getBadPassword() {
        return bad_password;
    }
}
