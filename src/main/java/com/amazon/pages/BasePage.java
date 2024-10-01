// src/main/java/com.amazon.base/BasePage.java
package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Base class for page object classes.
 * Provides common actions like clicking, entering text, and waiting for elements.
 */
public class BasePage {
    protected WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void click(By locator) {
        findElement(locator).click();
    }

    protected void enterText(By locator, String text) {
        findElement(locator).sendKeys(text);
    }

    protected String getText(By locator) {
        return findElement(locator).getText();
    }
}
