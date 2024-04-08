package com.phonebook.tests;
/*
@date 04.04.2024
@author Mihail Nedioglo
 */

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;


public class CreateAccountTests extends TestBase {

    @Test(enabled = true)
    public void CreateNewAccountPositiveTest() {
//!        Random random = new Random();
//!        int i = random.nextInt(1000)+1000;
        //click on Login Link
        click(By.cssSelector("[href='/login']"));
        //enter email
        type(By.name("email"), "manuel@gm.com");
//!        type(By.name("email"), "manuel" + i +"@gm.com");
        //enter password
        type(By.name("password"), "Manuel1234$");
        //click on Registration button
        click(By.cssSelector("[name='registration']"));
        //assert Sign Out button is present
        Assert.assertTrue(isElementPresent(By.xpath("//button[.='Sign Out']")));

    }//test

    @Test
    public void CreateNewAccountWithExistedEmailNegativeTest() {

        //click on Login Link
        click(By.cssSelector("[href='/login']"));
        //enter email
        type(By.name("email"), "manuel@gm.com");
        //enter password
        type(By.name("password"), "Manuel1234$");
        //click on Registration button
        click(By.cssSelector("[name='registration']"));
        //assert Alert is present
        Assert.assertTrue(isAlertPresent());

    }//test

}//class


// 1.  id
// 1.2 className
// 2. css
// 3. xPath