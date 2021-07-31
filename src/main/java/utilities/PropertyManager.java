package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyManager {

    private static String chromeDriverPath;
    private static String firefoxDriverPath;

    private static String url;

    private static String password;

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

        chromeDriverPath = properties.getProperty("chromeDriverPath");
        firefoxDriverPath = properties.getProperty("firefoxDriverPath");

        url = properties.getProperty("url");

        password = properties.getProperty("password");

        return instance;
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

    public String getPassword() {
        return password;
    }
}
