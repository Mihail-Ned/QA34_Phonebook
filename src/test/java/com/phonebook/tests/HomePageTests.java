package com.phonebook.tests;
/*
@date 03.04.2024
@author Mihail Nedioglo
*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomePageTests {
    WebDriver driver;

    @BeforeMethod
    public void setUp () {
        driver = new ChromeDriver();
        driver.get("https://telranedu.web.app");
        //maximize browser to windows
        driver.manage().window().maximize();
        // wait for elements on the site to load before starting the test
        driver.manage().timeouts(). implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void isHomeComponentPresent() {
        driver.findElement(By.cssSelector("div:nth-child(2) div h1"));
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit();
    }


}//class
