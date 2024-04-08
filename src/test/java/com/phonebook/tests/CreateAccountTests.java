package com.phonebook.tests;
/*
@date 04.04.2024
@author Mihail Nedioglo
 */

import org.testng.Assert;
import org.testng.annotations.Test;


public class CreateAccountTests extends TestBase {

    @Test(enabled = false)
    public void CreateNewAccountPositiveTest() {
//!        Random random = new Random();
//!        int i = random.nextInt(1000)+1000;
        //click on Login Link
        clickOnLoginLink();
        //enter email
        fillLoginRegisterForm(new User()
                .setEmail("qwerty007$@gmail.com")
                .setPassword("Qwerty007$"));
        //click on Registration button
        clickOnRegistrationButton();
        //assert Sign Out button is present
        Assert.assertTrue(isSignOutButtonPresent());

    }//test

    @Test
    public void CreateNewAccountWithExistedEmailNegativeTest() {

        //click on Login Link
        clickOnLoginLink();
        //enter email
        fillLoginRegisterForm(new User()
                .setEmail("qwerty007$@gmail.com")
                .setPassword("Qwerty007$"));
        //click on Registration button
        clickOnRegistrationButton();
        //assert Alert is present
        Assert.assertTrue(isAlertPresent());

    }//test

}//class


// 1.  id
// 1.2 className
// 2. css
// 3. xPath