package com.phonebook.tests;
/*
@date 08.04.2024
@author Mihail Nedioglo
*/

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        //click on Login Link
        clickOnLoginLink();
        //enter email
        fillLoginRegisterForm(new User()
                .setEmail("qwerty007$@gmail.com")
                .setPassword("Qwerty007$"));
        //click on login button [name ='login']
        clickOnLoginButton();

        clickOnAddLink();
        fillAddContactForm(new Contact()
                .setName("Karl")
                .setLastName("Adam")
                .setPhone("1234567890")
                .setEmail("adam@gm.com")
                .setAddress("Berlin")
                .setDescription("goalkeeper"));
        clickOnSaveButton();

    }

    @Test
    public void deleteContactPositive() {
        int sizeBefore = sizeOfContacts();
        click(By.cssSelector(".contact-item_card__2SOIM"));
        click(By.xpath("//button[.='Remove']"));


        pause(500);
        int sizeAfter = sizeOfContacts();
        Assert.assertEquals(sizeAfter, sizeBefore - 1);
    }


}//class
