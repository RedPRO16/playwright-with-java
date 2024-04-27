package com.cydeo.tests.day_02.homeWork;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;

import java.util.List;

public class HW02_radio_button_utility_method {

    @Test
    void test() {

        // TC#2: Radiobutton handling
        //1. Open Chrome browser
        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();


        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(List.of("--lang=en-US", "--force-english-ui")));

        Page page = browser.newContext().newPage();


        //2. Go to https://practice.cydeo.com/radio_buttons


        //for 3 - 4 - 5, do not repeat yourself create a method to click and verify the radio button

        //3. Click to “Hockey” radio button
        clickAndVerifyRadioButton(page, "id", "hockey");

        //4. Click to “Football” radio button
        clickAndVerifyRadioButton(page, "id", "football");
        //5. Click to “Red” radio button
        clickAndVerifyRadioButton(page, "id", "red");


        //wait 3 seconds


        //close the page

        //close the browser

        //close the playwright


    }

    private void clickAndVerifyRadioButton(Page page, String attribute, String value) {

        //Find the element


        // Verify radio button is selected after clicking.


    }
}
