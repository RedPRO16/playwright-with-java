package com.cydeo.tests.day_01.pac_02_locators_getText_getAttribute;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HWP4_Class_Locator_Practice {
    @Test
    void test1() {

        //HWP #4: Practice Cydeo – Class locator practice
        //PS: Locate “Home” link using “className” locator

        //1- Open a Chrome browser
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();


        //2- Go to: https://practice.cydeo.com/inputs
        page.navigate("https://practice.cydeo.com/inputs");


        //3- Click to “Home” link
        //Locating the "Home" link web element
        page.querySelector(".nav-link");


        //click to the link
        page.click(".nav-link");

        page.waitForTimeout(3000);

        //4- Verify title is as expected:
        // Expected: Practice
        Assertions.assertEquals("Practice", page.title());


        //close the page
        page.close();


        //close the browser
        browser.close();

        //close the playwright
        playwright.close();

    }
}
