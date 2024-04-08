package com.phonebook.tests;
/*
@date 04.04.2024
@author Mihail Nedioglo
 */


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginPositiveTest() {
        //click on Login Link
        click(By.cssSelector("[href='/login']"));
        //enter email
        type(By.name("email"), "manuel@gm.com");
        //enter password
        type(By.name("password"), "Manuel1234$");
        //click on login button [name ='login']
        click(By.cssSelector("[name ='login']"));
        //assert Sign out button is present
        Assert.assertTrue(isElementPresent(By.xpath("//button[.='Sign Out']")));

    }//test

}//class
