package com.amz.apptest;

import com.validation.apptest.basePage;
import com.validation.apptest.homePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest extends basePage {

    homePage home = new homePage();
    String product1 = "airpods";


    @Test
    public void testAmazonPlayStoreApp() throws InterruptedException {

        //find search bar and assert the field
        Boolean searchBarResult = home.searchAndAssert(driver);
        Assert.assertTrue(searchBarResult);

        //click on search bar
        home.clickOnSearchBar(driver);

        //Type airpods and select from the drop down
        home.searchForProduct(driver, product1);

        //Apply filter and check for prime only items
        home.applyPrimeFilter(driver);

        //Assert product from listing
        Boolean listingResult = home.checkProductFromListings(driver);
        Assert.assertTrue(listingResult);

        //Click on the product
        home.clickProductFromListing(driver);

        //Get product price and assert the value
        home.getPriceAndAssert(driver);

        //Click on buy now button
        home.clickOnBuyNowButton(driver);

        //Asserting the payment method page title
        Boolean paymentMethodTitle = home.paymentMethodPage(driver);
        Assert.assertTrue(paymentMethodTitle);
    }
}
