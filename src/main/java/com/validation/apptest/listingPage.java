package com.validation.apptest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.Assert;

public class listingPage {
    String prime = "//android.view.View[@text=\"Prime Eligible\"]";
    String productList = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ViewAnimator/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[16]";

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
}
