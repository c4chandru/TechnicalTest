package com.validation.apptest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.Assert;

public class homePage {

    common commonMethod = new common();

    public String searchBarId = "//android.widget.EditText[@text=\"Search\"]";
    String catagories = "in.amazon.mShop.android.shopping:id/iss_search_dropdown_item_department";


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
}
