package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductResultsPage extends BasePage {

    // Locator for the sort dropdown
    private By sortDropdown = By.cssSelector("span.a-dropdown-container");

    // Locator for dynamically locating a sort option based on provided sort type
    private By sortOption(String sortType) {
        return By.xpath("//a[contains(text(), '" + sortType + "')]");
    }

    // Locator for product items - can be further refined if needed
    private By productItemsLocator = By.cssSelector(".s-main-slot .s-result-item[data-component-type='s-search-result']");

    // Locators for buttons related to adding to cart
    private By addToCartButton = By.id("add-to-cart-button");
    private By cartButton = By.id("nav-cart");

    public ProductResultsPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Selects a sorting option dynamically based on the sortType parameter.
     *
     * @param sortType The sorting option to be selected (e.g., "Best Seller", "Price: Low to High").
     */
    public void sortBy(String sortType) {
        click(sortDropdown);
        click(sortOption(sortType)); // Click on the sorting option based on the parameter
    }

    /**
     * Gets all product elements after sorting.
     *
     * @return List of WebElement representing the products on the page.
     */
    public List<WebElement> getAllProductElements() {
        return driver.findElements(productItemsLocator);
    }

    /**
     * Selects the first product from the search results after sorting.
     */
    public void selectFirstProductAfterSort() {
        List<WebElement> products = getAllProductElements();
        if (!products.isEmpty()) {
            products.get(0).click(); // Click on the first product in the list
        } else {
            throw new RuntimeException("No products found after sorting!");
        }
    }

    /**
     * Adds the currently viewed product to the shopping cart.
     */
    public void addToCart() {
        click(addToCartButton);
    }

    /**
     * Navigates to the shopping cart page.
     */
    public void goToCart() {
        click(cartButton);
    }
}
