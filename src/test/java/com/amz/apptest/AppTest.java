package com.amz.apptest;

import com.sun.org.glassfish.gmbal.Description;
import com.validation.apptest.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest extends basePage {

    homePage home = new homePage();
    listingPage listPage = new listingPage();
    productPage productDetailsPage = new productPage();
    paymentPage paymentDetailsPage = new paymentPage();
    String product1 = "airpods";


    @Description("Test to buy amazon prime product with steps of drop down selection, prime filter, price assert and buy now")
    @Test(priority = 1)
    public void testAmazonPlayStoreApp() throws InterruptedException {

        Boolean searchBarResult = home.searchAndAssert(driver); //find search bar and assert the field
        Assert.assertTrue(searchBarResult);
        home.clickOnSearchBar(driver);  //click on search bar
        home.searchForProduct(driver, product1);  //Type airpods and select from the drop down
        listPage.applyPrimeFilter(driver);  //Apply filter and check for prime only items
        Boolean listingResult = listPage.checkProductFromListings(driver);  //Assert product from listing
        Assert.assertTrue(listingResult);
        listPage.clickProductFromListing(driver);  //Click on the product
        productDetailsPage.getPriceAndAssert(driver);  //Get product price and assert the value
        productDetailsPage.clickOnBuyNowButton(driver);  //Click on buy now button
        Boolean paymentMethodTitle = paymentDetailsPage.paymentMethodPage(driver); //Assert the payment method page title
        Assert.assertTrue(paymentMethodTitle);
    }
}
