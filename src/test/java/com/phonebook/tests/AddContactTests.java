package com.phonebook.tests;
/*
@date 05.04.2024
@author Mihail Nedioglo
*/

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition(){
        //click on Login Link
        clickOnLoginLink();
        //enter email
        fillLoginRegisterForm(new User()
                .setEmail("qwerty007$@gmail.com")
                .setPassword("Qwerty007$"));
        //click on login button [name ='login']
        clickOnLoginButton();

    }

    @Test
    public void addContactPositiveTest(){

        //click on Add link
        clickOnAddLink();
        //enter name
        fillAddContactForm(new Contact()
                .setName("Karl")
                .setLastName("Adam")
                .setPhone("1234567890")
                .setEmail("adam@gm.com")
                .setAddress("Berlin")
                .setDescription("goalkeeper"));
        //click on Save button
        clickOnSaveButton();
        //assert Contact is added by text
        Assert.assertTrue(isContactCreated("Karl"));
    }

    @AfterMethod
    public void postCondition() {
        removeContact();
    }


}//class
