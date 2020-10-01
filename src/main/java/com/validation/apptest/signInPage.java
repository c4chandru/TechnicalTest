package com.validation.apptest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.Assert;

public class signInPage {

    String header = "//*[@resource-id='com.malmstein.yahnac:id/login_header_text']";
    String userName = "//*[@resource-id='com.malmstein.yahnac:id/login_username']";
    String password = "//*[@resource-id='com.malmstein.yahnac:id/login_password']";
    String loginInButton = "//*[@resource-id='com.malmstein.yahnac:id/login_login']";
    String cancelButton = "//*[@resource-id='com.malmstein.yahnac:id/login_cancel']";
    String credentialErrorMessage = "//*[@resource-id='com.malmstein.yahnac:id/login_error_label']";
    String validUserName = "c4chandrasekar@gmail.com";
    String invalidUserName = "asdfger@gmail.com";
    String passwordData = "qwerty";
    String invalidPasswordData = "qwfadf!!#@ad~erty";
    String specialCharacterData = "~!_Á&@gmail.com";




    public Boolean assertSignInPage(AppiumDriver driver){

        MobileElement signInHeader = (MobileElement) driver.findElementByXPath(header);
        MobileElement userNameField = (MobileElement) driver.findElementByXPath(userName);
        Assert.assertTrue(userNameField.isDisplayed(), "Is visible");
        MobileElement passwordField = (MobileElement) driver.findElementByXPath(password);
        Assert.assertTrue(passwordField.isDisplayed(), "Is visible");
        MobileElement loginIn = (MobileElement) driver.findElementByXPath(loginInButton);
        Assert.assertTrue(loginIn.isDisplayed(), "Is visible");
        MobileElement cancel = (MobileElement) driver.findElementByXPath(cancelButton);
        Assert.assertTrue(cancel.isDisplayed(), "Is visible");
        return signInHeader.isDisplayed();

    }

    public void emptyLoginFormSubmit(AppiumDriver driver) throws InterruptedException {
        MobileElement loginIn = (MobileElement) driver.findElementByXPath(loginInButton);
        Assert.assertTrue(loginIn.isDisplayed(), "Is visible");
        loginIn.click();
        MobileElement credentialError = (MobileElement) driver.findElementByXPath(credentialErrorMessage);
        Assert.assertTrue(credentialError.isDisplayed(), "Is visible");
        Thread.sleep(3000);
    }

    public void invalidUserNameSubmit(AppiumDriver driver) throws InterruptedException {
        MobileElement userNameField = (MobileElement) driver.findElementByXPath(userName);
        Assert.assertTrue(userNameField.isDisplayed(), "Is visible");
        userNameField.sendKeys(invalidUserName);
        MobileElement passwordField = (MobileElement) driver.findElementByXPath(password);
        Assert.assertTrue(passwordField.isDisplayed(), "Is visible");
        passwordField.sendKeys(passwordData);
        driver.findElementByXPath(loginInButton).click();
        Thread.sleep(4000);
        MobileElement credentialError = (MobileElement) driver.findElementByXPath(credentialErrorMessage);
        Assert.assertTrue(credentialError.isDisplayed(), "Is visible");
        Thread.sleep(3000);
    }

    public void invalidPasswordSubmit(AppiumDriver driver) throws InterruptedException {
        MobileElement userNameField = (MobileElement) driver.findElementByXPath(userName);
        Assert.assertTrue(userNameField.isDisplayed(), "Is visible");
        userNameField.clear();
        userNameField.sendKeys(validUserName);
        MobileElement passwordField = (MobileElement) driver.findElementByXPath(password);
        Assert.assertTrue(passwordField.isDisplayed(), "Is visible");
        passwordField.clear();
        passwordField.sendKeys(invalidPasswordData);
        driver.findElementByXPath(loginInButton).click();
        Thread.sleep(3000);
        MobileElement credentialError = (MobileElement) driver.findElementByXPath(credentialErrorMessage);
        Assert.assertTrue(credentialError.isDisplayed(), "Is visible");
        Thread.sleep(2000);


    }

    public void specialCharacterSubmit(AppiumDriver driver) throws InterruptedException {
        MobileElement userNameField = (MobileElement) driver.findElementByXPath(userName);
        Assert.assertTrue(userNameField.isDisplayed(), "Is visible");
        userNameField.clear();
        userNameField.sendKeys(specialCharacterData);
        MobileElement passwordField = (MobileElement) driver.findElementByXPath(password);
        Assert.assertTrue(passwordField.isDisplayed(), "Is visible");
        passwordField.clear();
        passwordField.sendKeys(specialCharacterData);
        driver.findElementByXPath(loginInButton).click();
        Thread.sleep(3000);
        MobileElement credentialError = (MobileElement) driver.findElementByXPath(credentialErrorMessage);
        Assert.assertTrue(credentialError.isDisplayed(), "Is visible");
        Thread.sleep(2000);

    }


}
