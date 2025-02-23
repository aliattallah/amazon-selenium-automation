package com.amazon.automation.tests;

import com.amazon.automation.base.BaseTest;
import com.amazon.automation.pages.HomePage;
import com.amazon.automation.pages.LoginPage;
import com.amazon.automation.pages.VideoGamesPage;
import com.amazon.automation.pages.CartPage;
import org.testng.annotations.Test;

public class AmazonTest extends BaseTest {
    @Test
    public void testAmazonScenario() {

        HomePage homePage = new HomePage(driver);
        homePage.navigateToVideoGames();

        VideoGamesPage videoGamesPage = new VideoGamesPage(driver);
        videoGamesPage.applyFilters();
        videoGamesPage.sortByPriceHighToLow();

        CartPage cartPage = new CartPage(driver);
        cartPage.addProductsBelowPrice(15000);

        assert cartPage.verifyCartTotal(15000) : "Cart total does not match expected amount!";
    }
}
