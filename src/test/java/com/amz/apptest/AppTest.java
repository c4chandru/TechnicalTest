package com.amz.apptest;

import com.sun.org.glassfish.gmbal.Description;
import com.validation.apptest.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest extends basePage {

    homePage home = new homePage();
    signInPage signIn = new signInPage();
    productPage productDetailsPage = new productPage();
    paymentPage paymentDetailsPage = new paymentPage();
    String product1 = "airpods";


////  @Description("Test to buy amazon prime product with steps of drop down selection, prime filter, price assert and buy now")
    @Test()
    public void testEmptyLoginFormSubmission() throws InterruptedException {
        home.assertHomePage(driver);
        home.clickOnHamburgerIcon(driver);
        home.assertSidePane(driver);
        home.clickOnSignIn(driver);
        signIn.assertSignInPage(driver);
        signIn.emptyLoginFormSubmit(driver);
    }

    @Test()
    public void testInvalidUserNameFormSubmission() throws InterruptedException {
//        home.assertHomePage(driver);
//        home.clickOnHamburgerIcon(driver);
//        home.assertSidePane(driver);
//        home.clickOnSignIn(driver);
//        signIn.assertSignInPage(driver);
        signIn.invalidUserNameSubmit(driver);
    }

    @Test()
    public void testInvalidUserPasswordSubmission() throws InterruptedException {
//        home.assertHomePage(driver);
//        home.clickOnHamburgerIcon(driver);
//        home.assertSidePane(driver);
//        home.clickOnSignIn(driver);
//        signIn.assertSignInPage(driver);
        signIn.invalidPasswordSubmit(driver);
    }

    @Test()
    public void testSpecialCharacterSubmission() throws InterruptedException {
//        home.assertHomePage(driver);
//        home.clickOnHamburgerIcon(driver);
//        home.assertSidePane(driver);
//        home.clickOnSignIn(driver);
//        signIn.assertSignInPage(driver);
        signIn.specialCharacterSubmit(driver);
    }
}
