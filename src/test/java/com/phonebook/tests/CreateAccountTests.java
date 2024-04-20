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


public class CreateAccountTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
    }

    @Test(enabled = false)
    public void CreateNewAccountPositiveTest() {
//!        Random random = new Random();
//!        int i = random.nextInt(1000)+1000;
        app.getUser().clickOnLoginLink();
        //enter email
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail(UserData.EMAIL)
//!                .setEmail("qwerty007$" + i + "@gmail.com")
                .setPassword(UserData.PASSWORD));
        app.getUser().clickOnRegistrationButton();
        //assert Sign Out button is present
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());

    }//test

    @Test
    public void CreateNewAccountWithExistedEmailNegativeTest() {

        app.getUser().clickOnLoginLink();
        //enter email
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD));
        app.getUser().clickOnRegistrationButton();
        //assert Alert is present
        Assert.assertTrue(app.getUser().isAlertPresent());

    }//test

}//class


// 1.  id
// 1.2 className
// 2. css
// 3. xPath