package com.validation.apptest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class paymentPage {

    String paymentMethodTitle = "//android.view.View[@text=\"Select a payment method\"]";

    public Boolean paymentMethodPage(AppiumDriver driver){
        MobileElement title = (MobileElement) driver.findElementByXPath(paymentMethodTitle);
        return title.isDisplayed();

    }
}
