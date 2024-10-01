package com.amazon.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomePage extends BasePage {

    // Locator for category dropdown menu and search elements
    private By categoryDropdown = By.id("searchDropdownBox");
    private By searchField = By.id("twotabsearchtextbox");
    private By searchButton = By.id("nav-search-submit-button");

    // Locator for the "Deliver to" button to open the delivery options pop-up
    private By deliverToButtonLocator = By.id("nav-global-location-popover-link");

    // Locator for the country dropdown in the pop-up window
    private By countryDropdownLocator = By.cssSelector("select[name='glow-ingress-line2']");

    // Locator for each country option in the dropdown list
    private By countryOptionsLocator = By.cssSelector("select[name='glow-ingress-line2'] option");

    // Locator for the "Done" button in the pop-up window
    private By doneButtonLocator = By.cssSelector("button[name='glowDoneButton']");


    public HomePage(WebDriver driver) {
        super(driver);
    }


    @Step("Click on 'Deliver to' button to open the delivery options pop-up.")
    public void openDeliverToPopup() {
        click(deliverToButtonLocator);
    }


    @Step("Selecting country: {countryName} from the 'Deliver to' dropdown list.")
    public void selectCountry(String countryName) {
        // Open the "Deliver to" pop-up first
        openDeliverToPopup();

        // Get all country options in the dropdown list
        List<WebElement> countryOptions = driver.findElements(countryOptionsLocator);
        for (WebElement option : countryOptions) {
            if (option.getText().equalsIgnoreCase(countryName)) {
                option.click(); // Select the desired country
                break;
            }
        }
    }


    @Step("Clicking on the 'Done' button to confirm country selection.")
    public void clickDoneButton() {
        click(doneButtonLocator);
    }


    @Step("Selecting country: {countryName} and confirming selection.")
    public void selectCountryAndConfirm(String countryName) {
        selectCountry(countryName);
        clickDoneButton();
    }

//    public void selectCategory(String category) {
//        click(categoryDropdown);
//        By categoryOption = By.xpath("//option[contains(text(), '" + category + "')]");
//        click(categoryOption);
//    }


    @Step("Selecting category: {categoryValue} from the category dropdown menu.")
    public void selectCategoryByValue(String categoryValue) {
        // Locate the dropdown element
        WebElement dropdownElement = driver.findElement(categoryDropdown);

        // Create a Select object to interact with the dropdown
        Select categorySelect = new Select(dropdownElement);

        // Select the category based on the value attribute
        categorySelect.selectByValue(categoryValue);
    }


    public void searchForProductByKeyword(String keyword) {
        enterText(searchField, keyword);
        click(searchButton);
    }
}
