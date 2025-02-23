package com.amazon.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VideoGamesPage {
    private WebDriver driver;
    private By freeShippingFilter = By.xpath("//span[text()='Free Shipping']");
    private By newConditionFilter = By.xpath("//span[text()='New']");
    private By sortDropdown = By.id("s-result-sort-select");
    private By sortHighToLow = By.xpath("//option[@value='price-desc-rank']");

    public VideoGamesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void applyFilters() {
        driver.findElement(freeShippingFilter).click();
        driver.findElement(newConditionFilter).click();
    }

    public void sortByPriceHighToLow() {
        driver.findElement(sortDropdown).click();
        driver.findElement(sortHighToLow).click();
    }
}
