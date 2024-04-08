package com.phonebook.tests;
/*
@date 04.04.2024
@author Mihail Nedioglo
 */


import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginPositiveTest() {
        //click on Login Link
        clickOnLoginLink();
        //enter email
        fillLoginRegisterForm(new User()
                .setEmail("qwerty007$@gmail.com")
                .setPassword("Qwerty007$"));
        //click on login button [name ='login']
        clickOnLoginButton();
        //assert Sign out button is present
        Assert.assertTrue(isSignOutButtonPresent());

    }//test

    @Test
    public void loginNegativeTestWithoutEmail() {
        //click on Login Link
        clickOnLoginLink();
        //enter email
        fillLoginRegisterForm(new User()
                .setPassword ("Qwerty007$"));
        //click on login button [name ='login']
        clickOnLoginButton();
        //assert Sign out button is present
        Assert.assertTrue(isAlertPresent());

    }//test

}//class
