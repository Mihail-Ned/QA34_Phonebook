package com.phonebook.tests;
/*
@date 04.04.2024
@author Mihail Nedioglo
 */


import com.phonebook.data.UserData;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
    }

    @Test
    public void loginPositiveTest() {
        app.getUser().clickOnLoginLink();
        //enter email
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();
        //assert Sign out button is present
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());

    }//test

    @Test
    public void loginNegativeTestWithoutEmail() {
        app.getUser().clickOnLoginLink();
        //enter email
        app.getUser().fillLoginRegisterForm(new User()
                .setPassword (UserData.PASSWORD));
        app.getUser().clickOnLoginButton();
        //assert Sign out button is present
        Assert.assertTrue(app.getUser().isAlertPresent());

    }//test

}//class
