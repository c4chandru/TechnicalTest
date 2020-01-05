package com.validation.apptest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.Assert;

public class homePage {

    common commonMethod = new common();

    public String continueButton = "in.amazon.mShop.android.shopping:id/sso_continue";
    public String searchBarId = "in.amazon.mShop.android.shopping:id/rs_search_src_text";
    public String saveButton = "//android.widget.Button[@text=\"Save Changes\"]";
    String radioButton = "android.widget.RadioButton";
    String catagories = "in.amazon.mShop.android.shopping:id/iss_search_dropdown_item_department";
    String productList = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ViewAnimator/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View/android.view.View[17]";
    String prime = "//android.view.View[@text=\"Prime Eligible\"]";
    String filterDropDown = "filters-link-declarative";
    String productPrice = "//android.widget.EditText[@text=\"rupees 12,499\"]";
    String buyNow = "a-autoid-1";
    String paymentMethodTitle = "//android.view.View[@text=\"Select a payment method\"]";

    public void homePageRedirect(AppiumDriver driver){
        MobileElement cont = (MobileElement) driver.findElementById(continueButton);
        cont.click();
        MobileElement radio = (MobileElement) driver.findElementByClassName(radioButton);
        radio.click();
        MobileElement save = (MobileElement) driver.findElementByXPath(saveButton);
        save.click();
    }

    public Boolean searchAndAssert(AppiumDriver driver) throws InterruptedException {
        Thread.sleep(5000);
        MobileElement searchBar = (MobileElement) driver.findElementById(searchBarId);
        return searchBar.isDisplayed();
    }

    public void clickOnSearchBar(AppiumDriver driver){
        MobileElement searchBar = (MobileElement) driver.findElementById(searchBarId);
        searchBar.click();
    }

    public void searchForProduct(AppiumDriver driver, String product) throws InterruptedException {
        MobileElement searchProduct = (MobileElement) driver.findElementById(searchBarId);
        searchProduct.sendKeys(product);
        MobileElement clickFromList = (MobileElement) driver.findElementById(catagories);
        clickFromList.click();
        Thread.sleep(4000);
    }

    public String getFilterValue(AppiumDriver driver){
        MobileElement filter = (MobileElement) driver.findElementById(filterDropDown);
        String filterValue = filter.getText();
        return filterValue;
    }

    public void applyPrimeFilter(AppiumDriver driver) throws InterruptedException {
        MobileElement primeSwitch = (MobileElement) driver.findElementByXPath(prime);
        Boolean primeVisible = primeSwitch.isDisplayed();
        Assert.assertTrue(primeVisible);
        primeSwitch.click();
        Thread.sleep(3000);
    }

    public Boolean checkProductFromListings(AppiumDriver driver) throws InterruptedException {
//        commonMethod.scroll(driver, 998,1960,1004,892);
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
        commonMethod.scroll(driver, 873,1782,959,294);;
        MobileElement buyNowButton = (MobileElement) driver.findElementById(buyNow);
        buyNowButton.click();
        Thread.sleep(5000);
        MobileElement title = (MobileElement) driver.findElementByXPath(paymentMethodTitle);
        title.isDisplayed();
    }

    public Boolean paymentMethodPage(AppiumDriver driver){
        MobileElement title = (MobileElement) driver.findElementByXPath(paymentMethodTitle);
        return title.isDisplayed();

    }

}
