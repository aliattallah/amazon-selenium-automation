package com.amazon.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By allMenu = By.id("nav-hamburger-menu");
    private By videoGamesCategory = By.xpath("//div[text()='Video Games']");
    private By allVideoGames = By.xpath("//a[text()='All Video Games']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToVideoGames() {
        driver.findElement(allMenu).click();
        driver.findElement(videoGamesCategory).click();
        driver.findElement(allVideoGames).click();
    }
}
