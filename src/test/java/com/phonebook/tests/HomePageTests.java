package com.phonebook.tests;
/*
@date 03.04.2024
@author Mihail Nedioglo
*/

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HomePageTests extends TestBase {

    @Test
    public void isHomeComponentPresentTest() {
        //System.out.println("Home component is" + isHomeComponentPresent() );
        Assert.assertTrue(isHomeComponentPresent());
    }


    public boolean isHomeComponentPresent() {
        return isElementPresent(By.cssSelector("div:nth-child(2) div h1"));
    }


}//class
