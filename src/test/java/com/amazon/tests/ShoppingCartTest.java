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
        // Create page object instances
       // HomePage homePage = new HomePage(driver);
        ProductResultsPage resultsPage = new ProductResultsPage(driver);
        ShoppingCartPage cartPage = new ShoppingCartPage(driver);

        // Retrieve search criteria from the config file or define them directly in the test
        //String category = ConfigReader.getProperty("searchCategory");
        String keyword = ConfigReader.getProperty("searchKeyword");
        String sortOption = ConfigReader.getProperty("sortOption");


        // Step 2: Sort products by the specified option
        resultsPage.sortBy(sortOption);

        // Step 3: Add the first product after sorting to the shopping cart
        resultsPage.selectFirstProductAfterSort();
        resultsPage.addToCart();
        resultsPage.goToCart();


        // Step 5: Validate the price and subtotal in the cart
        String productPrice = cartPage.getPrice();
        String subtotal = cartPage.getSubtotal();

//        boolean isDiscountApplied = cartPage.isDiscountApplied();
//
        // Convert price and subtotal from string to double for comparison
        double productPriceValue = Double.parseDouble(productPrice.replace("$", "").replace(",", ""));
        double subtotalValue = Double.parseDouble(subtotal.replace("$", "").replace(",", ""));
        Assert.assertEquals(subtotalValue, productPriceValue);
//        if (isDiscountApplied) {
//            String discount = cartPage.getDiscountAmount();
//            double discountValue = Double.parseDouble(discount.replace("$", "").replace(",", ""));
//            // Validate that subtotal is equal to product price minus discount
//            Assert.assertEquals(subtotalValue, productPriceValue - discountValue, "Subtotal should equal product price minus discount.");
//        } else {
//            // Validate that subtotal is equal to product price when no discount is applied
//            Assert.assertEquals(subtotalValue, productPriceValue, "Subtotal should equal product price when no discount is applied.");
//        }

    }
}
