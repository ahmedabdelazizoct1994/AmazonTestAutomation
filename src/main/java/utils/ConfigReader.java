package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();
    private static final String configFilePath = System.getProperty("user.dir") + "/resources/config.properties";  // Correct the file path separator

    // Static block to initialize properties when the class is loaded
    static {
        try (InputStream inputStream = new FileInputStream(configFilePath)) {
            properties.load(inputStream);

        } catch (IOException e) {
            System.err.println("Error loading properties file: " + e.getMessage());
        }
    }



    public static String getProperty(String key) {
        return properties.getProperty(key, "Property not found: " + key);
    }
}
