package com.phonebook.tests;
/*
@date 05.04.2024
@author Mihail Nedioglo
*/

import com.phonebook.data.ContactData;
import com.phonebook.data.UserData;
import com.phonebook.models.Contact;
import com.phonebook.models.User;
import com.phonebook.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddContactTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
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
    public void addContactPositiveTest() {
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

    //
    @Test(dataProvider = "addNewContact", dataProviderClass = DataProviders.class)
    public void addContactPositiveTestFromDataProvider(String name, String lastName, String phone,
                                                       String email, String address, String description) {
        //click on Add link
        app.getContact().clickOnAddLink();
        //enter name
        app.getContact().fillAddContactForm(new Contact()
                .setName(name)
                .setLastName(lastName)
                .setPhone(phone)
                .setEmail(email)
                .setAddress(address)
                .setDescription(description));
        //click on Save button
        app.getContact().clickOnSaveButton();
        //assert Contact is added by text
        Assert.assertTrue(app.getContact().isContactCreated(name));
    }

    //
    @Test(dataProvider = "addNewContactFromCsvFile", dataProviderClass = DataProviders.class)
    public void addContactPositiveTestFromDataProviderWithCsvFile(Contact contact) {

        //click on Add link
        app.getContact().clickOnAddLink();
        //enter name
        app.getContact().fillAddContactForm(contact);
        //click on Save button
        app.getContact().clickOnSaveButton();

        //assert Contact is added by text
        Assert.assertTrue(app.getContact().isContactCreated(contact.getName()));
    }


}//class
