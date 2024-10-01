package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BasePage {

    private By subtotalElement = By.cssSelector(".sc-subtotal-amount");
    private By priceElement = By.cssSelector("#sc-subtotal-amount-buybox");
    private By proceedToCheckoutButton = By.name("proceedToRetailCheckout");

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public String getSubtotal() {
        return getText(subtotalElement);
    }

    public String getPrice() {
        return getText(priceElement);
    }

    public void proceedToCheckout() {
        click(proceedToCheckoutButton);
    }
}
