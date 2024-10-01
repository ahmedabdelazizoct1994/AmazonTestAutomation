package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            System.out.println("Driver is null. Initializing new WebDriver instance.");
          //  WebDriverManager.chromedriver().driverVersion("129").setup();


            WebDriverManager.firefoxdriver().setup();  // Ensure WebDriver is set up
            driver = new FirefoxDriver();
            System.out.println("Driver initialized: " + driver);
        } else {
            System.out.println("Driver already exists: " + driver);
        }
        return driver;
    }
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
//
//package utils;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//
//public class DriverManager {
//    private static WebDriver driver;
//
//    public static WebDriver getDriver() {
//        if (driver == null) {
//            // Set up WebDriverManager to use a specific ChromeDriver version
//            WebDriverManager.chromedriver().driverVersion("114.0.5735.90").setup(); // Set compatible ChromeDriver version
//
//            // Optional: Set Chrome options
//            ChromeOptions options = new ChromeOptions();
//            options.setBinary("C:/Program Files/Google/Chrome/Application/chrome.exe"); // Adjust path if necessary
//
//            driver = new ChromeDriver(options);
//        }
//        return driver;
//    }
//
//    public static void quitDriver() {
//        if (driver != null) {
//            driver.quit();
//            driver = null;
//        }
//    }
//}
