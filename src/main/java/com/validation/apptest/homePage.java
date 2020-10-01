package com.validation.apptest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.Assert;

public class homePage {

    common commonMethod = new common();

    public String topStory = "//android.widget.TextView[@text=\"TOP STORIES\"]";
    public String newest = "//android.widget.TextView[@text=\"NEWEST\"]";
    public String best = "//android.widget.TextView[@text=\"BEST\"]";
    public String hamBurgerButton = "//android.widget.ImageButton[@content-desc='Navigate up']";
    public String signIn = "//*[@resource-id='com.malmstein.yahnac:id/view_drawer_header_login']";
    public String news = "//android.widget.CheckedTextView[@text='News']";
    public String myBookmarks = "//android.widget.CheckedTextView[@text='My bookmarks']";
    public String comments = "//android.widget.CheckedTextView[@text='Comments']";



    public Boolean assertHomePage(AppiumDriver driver){
        MobileElement navBarTopStory = (MobileElement) driver.findElementByXPath(topStory);
        MobileElement navBarNewest = (MobileElement) driver.findElementByXPath(newest);
        Assert.assertTrue(navBarNewest.isDisplayed(), "Is visible");
        MobileElement navBarBest = (MobileElement) driver.findElementByXPath(best);
        Assert.assertTrue(navBarBest.isDisplayed(), "Is visible");
        return navBarTopStory.isDisplayed();
    }

    public void clickOnHamburgerIcon(AppiumDriver driver) throws InterruptedException {
        MobileElement menuIcon = (MobileElement) driver.findElementByXPath(hamBurgerButton);
        Assert.assertTrue(menuIcon.isDisplayed(), "Is visible");
        Thread.sleep(2000);
        menuIcon.click();
    }

    public void assertSidePane(AppiumDriver driver) throws InterruptedException {
        MobileElement signInButton = (MobileElement) driver.findElementByXPath(signIn);
        Assert.assertTrue(signInButton.isDisplayed(), "Is visible");
        MobileElement newsButton = (MobileElement) driver.findElementByXPath(news);
        Assert.assertTrue(newsButton.isDisplayed(), "Is visible");
        MobileElement myBookmarksButton = (MobileElement) driver.findElementByXPath(myBookmarks);
        Assert.assertTrue(myBookmarksButton.isDisplayed(), "Is visible");
        MobileElement commentsButton = (MobileElement) driver.findElementByXPath(comments);
        Assert.assertTrue(commentsButton.isDisplayed(), "Is visible");

    }

    public void clickOnSignIn(AppiumDriver driver) throws InterruptedException {
        MobileElement signInButton = (MobileElement) driver.findElementByXPath(signIn);
        Assert.assertTrue(signInButton.isDisplayed(), "Is visible");
        signInButton.click();
        Thread.sleep(3000);

    }

}
