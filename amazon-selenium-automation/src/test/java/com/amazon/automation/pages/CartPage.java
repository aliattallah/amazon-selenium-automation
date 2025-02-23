package com.amazon.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.List;
import org.openqa.selenium.WebElement;

public class CartPage {
    private WebDriver driver;
    private By priceElements = By.xpath("//span[@class='a-price-whole']");
    private By addToCartButtons = By.xpath("//input[@value='Add to Cart']");
    private By cartTotal = By.id("sc-subtotal-amount-buybox");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProductsBelowPrice(double maxPrice) {
        List<WebElement> prices = driver.findElements(priceElements);
        List<WebElement> addToCartButtonsList = driver.findElements(addToCartButtons);

        for (int i = 0; i < prices.size(); i++) {
            double price = Double.parseDouble(prices.get(i).getText().replace(",", ""));
            if (price < maxPrice) {
                addToCartButtonsList.get(i).click();
            }
        }
    }

    public boolean verifyCartTotal(double expectedTotal) {
        double actualTotal = Double.parseDouble(driver.findElement(cartTotal).getText().replace(",", ""));
        return actualTotal == expectedTotal;
    }
}
