package com.cydeo.tests.day_02.homeWork_2;

import com.cydeo.utils.BrowserUtils;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Assertions;
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
        page.navigate("https://practice.cydeo.com/radio_buttons");


        //for 3 - 4 - 5, do not repeat yourself create a method to click and verify the radio button

        //3. Click to “Hockey” radio button
        clickAndVerifyRadioButton(page, "id", "hockey");

        //4. Click to “Football” radio button
        clickAndVerifyRadioButton(page, "id", "football");

        //5. Click to “Red” radio button
        clickAndVerifyRadioButton(page, "id", "red");


        //wait 3 seconds
        BrowserUtils.sleepWithThread(3);


        //close the page
        page.close();

        //close the browser
        browser.close();

        //close the playwright
        playwright.close();


    }

    private void clickAndVerifyRadioButton(Page page, String attribute, String value) {

        //Find the element
        ElementHandle radioButton = page.querySelector(String.format("[%s='%s']", attribute, value));

        //click the radio button
        radioButton.click();

        // Verify radio button is selected after clicking.

        Boolean isSelected = (Boolean) radioButton.evaluate("el => el.checked");

        System.out.println(isSelected);

        Assertions.assertTrue(isSelected, String.format("Radio button %s is not selected after clicking.", value));


    }
}
