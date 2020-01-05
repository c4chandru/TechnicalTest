package com.validation.apptest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.Assert;

public class productPage {

    common commonMethod = new common();

    String productPrice = "//android.widget.EditText[@text=\"rupees 12,499\"]";
    String paymentMethodTitle = "//android.view.View[@text=\"Select a payment method\"]";

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
}
