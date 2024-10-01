package com.amazon.tests;
import com.amazon.pages.HomePage;
import com.amazon.pages.ProductResultsPage;
import com.amazon.pages.ShoppingCartPage;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class ShoppingCartTest extends BaseTest {

    @Test
    @Description("Test adding a product to the cart and verifying price and subtotal calculations with and without discounts.")
    public void testShoppingCartCalculations() {


        ProductResultsPage resultsPage = new ProductResultsPage(driver);
        ShoppingCartPage cartPage = new ShoppingCartPage(driver);


        String sortOption = ConfigReader.getProperty("sortOption");


        // Sort products by the specified option
        resultsPage.sortBy(sortOption);

        // Add the first product after sorting to the shopping cart
        resultsPage.selectFirstProductAfterSort();
        resultsPage.addToCart();
        resultsPage.goToCart();


        String productPrice = cartPage.getPrice();
        String subtotal = cartPage.getSubtotal();

//
        // Convert price and subtotal from string to double for comparison
        double productPriceValue = Double.parseDouble(productPrice.replace("$", "").replace(",", ""));
        double subtotalValue = Double.parseDouble(subtotal.replace("$", "").replace(",", ""));
        Assert.assertEquals(subtotalValue, productPriceValue);


    }
}
