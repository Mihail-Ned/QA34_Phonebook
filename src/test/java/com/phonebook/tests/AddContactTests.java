package com.phonebook.tests;
/*
@date 05.04.2024
@author Mihail Nedioglo
*/

import com.phonebook.data.ContactData;
import com.phonebook.data.UserData;
import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }

        //click on Login Link
        app.getUser().clickOnLoginLink();
        //enter email
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD));
        //click on login button [name ='login']
        app.getUser().clickOnLoginButton();

    }

    @Test
    public void addContactPositiveTest(){
        //click on Add link
        app.getContact().clickOnAddLink();
        //enter name
        app.getContact().fillAddContactForm(new Contact()
                .setName(ContactData.NAME)
                .setLastName(ContactData.LAST_NAME)
                .setPhone(ContactData.PHONE)
                .setEmail(ContactData.CONTACT_EMAIL)
                .setAddress(ContactData.ADDRESS)
                .setDescription(ContactData.DESC));
        //click on Save button
        app.getContact().clickOnSaveButton();
        //assert Contact is added by text
        Assert.assertTrue(app.getContact().isContactCreated(ContactData.NAME));
    }

    @AfterMethod
    public void postCondition() {
        app.getContact().removeContact();
    }


}//class
