package com.validation.apptest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import static java.time.Duration.ofSeconds;

public class common extends basePage{

    public void scroll(AppiumDriver driver, int startx, int starty, int endx, int endy) {

        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(PointOption.point(startx, starty))
                .waitAction(WaitOptions.waitOptions(ofSeconds(1)))
                .moveTo(PointOption.point(endx, endy))
                .release()
                .perform();

    }
}
