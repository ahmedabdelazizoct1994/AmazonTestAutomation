package com.amazon.tests;

import com.amazon.pages.HomePage;
import com.amazon.pages.ProductResultsPage;
import io.qameta.allure.Description;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigReader;

import java.util.List;

public class SearchTest extends BaseTest {

    @Test
    @Description("Test searching for products by category or keyword and verify products are displayed.")
    public void testSearchAndVerifyResults() {
        // Create page object instances
        HomePage homePage = new HomePage(driver);
        ProductResultsPage resultsPage = new ProductResultsPage(driver);


        // Retrieve search criteria (category and keyword& country) from the config file or define them directly in the test
        String category = ConfigReader.getProperty("searchCategory");
        String keyword = ConfigReader.getProperty("searchKeyword");
        String country = ConfigReader.getProperty("country");
        homePage.selectCountryAndConfirm(country);

        // Step 1: Select the category and search for a product by keyword
        homePage.selectCategoryByValue(category);       // Select category from dropdown
        homePage.searchForProductByKeyword(keyword);  // Enter the keyword in the search field and click search

        // Step 2: Verify that products are displayed
        List<WebElement> products = resultsPage.getAllProductElements();
        Assert.assertFalse(products.isEmpty(), "No products found for the given category and keyword!");

//        // Log the result for additional verification
//        System.out.println("Total number of products found: " + products.size());
    }
}
