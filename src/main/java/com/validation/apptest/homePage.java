package com.validation.apptest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.Assert;

public class homePage {

    common commonMethod = new common();

    public String searchBarId = "//android.widget.EditText[@text=\"Search\"]";
    String catagories = "in.amazon.mShop.android.shopping:id/iss_search_dropdown_item_department";
    String productList = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ViewAnimator/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[16]";
    String prime = "//android.view.View[@text=\"Prime Eligible\"]";
    String productPrice = "//android.widget.EditText[@text=\"rupees 12,499\"]";
    String paymentMethodTitle = "//android.view.View[@text=\"Select a payment method\"]";


    public Boolean searchAndAssert(AppiumDriver driver) throws InterruptedException {
        MobileElement searchBar = (MobileElement) driver.findElementByXPath(searchBarId);
        return searchBar.isDisplayed();
    }

    public void clickOnSearchBar(AppiumDriver driver) throws InterruptedException {
        MobileElement searchBar = (MobileElement) driver.findElementByXPath(searchBarId);
        searchBar.click();
        Thread.sleep(3000);
    }

    public void searchForProduct(AppiumDriver driver, String product) throws InterruptedException {
        MobileElement searchProduct = (MobileElement) driver.findElementByXPath(searchBarId);
        searchProduct.sendKeys(product);
        MobileElement clickFromList = (MobileElement) driver.findElementById(catagories);
        clickFromList.click();
        Thread.sleep(4000);
    }

    public void applyPrimeFilter(AppiumDriver driver) throws InterruptedException {
        MobileElement primeSwitch = (MobileElement) driver.findElementByXPath(prime);
        Boolean primeVisible = primeSwitch.isDisplayed();
        Assert.assertTrue(primeVisible);
        primeSwitch.click();
        Thread.sleep(3000);
    }

    public Boolean checkProductFromListings(AppiumDriver driver) throws InterruptedException {
        Thread.sleep(2000);
        MobileElement productElem = (MobileElement) driver.findElementByXPath(productList);
        return productElem.isDisplayed();
    }

    public void clickProductFromListing(AppiumDriver driver) throws InterruptedException {
        MobileElement selectProduct = (MobileElement) driver.findElementByXPath(productList);
        selectProduct.click();
        Thread.sleep(3000);
    }

    public void getPriceAndAssert(AppiumDriver driver){
        MobileElement prdPrice = (MobileElement) driver.findElementByXPath(productPrice);
        String priceValue = prdPrice.getText();
        Assert.assertEquals(priceValue, "rupees 12,499");
    }

    public void clickOnBuyNowButton(AppiumDriver driver) throws InterruptedException {
        commonMethod.scroll(driver, 873,1782,959,294);
        commonMethod.touch(driver, 567,1446);
        Thread.sleep(5000);
        MobileElement title = (MobileElement) driver.findElementByXPath(paymentMethodTitle);
        title.isDisplayed();
        Thread.sleep(5000);
    }

    public Boolean paymentMethodPage(AppiumDriver driver){
        MobileElement title = (MobileElement) driver.findElementByXPath(paymentMethodTitle);
        return title.isDisplayed();

    }

}
