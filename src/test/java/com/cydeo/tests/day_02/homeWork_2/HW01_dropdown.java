package com.cydeo.tests.day_02.homeWork_2;

import com.cydeo.utils.BrowserUtils;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HW01_dropdown {
    @Test
    void test() {


        //HW #1: Selecting state from State dropdown and verifying result

        //1. Open Chrome browser
        Playwright playwright = Playwright.create();
        /*

       BrowserType chromium = playwright.chromium();
        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));

         */
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();


        //2. Go to https://practice.cydeo.com/dropdown
        page.navigate("https://practice.cydeo.com/dropdown");


        //locate the dropdown and create select object
        Locator stateDropdown = page.locator("#state");

        BrowserUtils.sleepWithThread(1);

        //Use all Select options. (visible text, value, index)
        //3. Select Illinois with visible text

        //select with text
        stateDropdown.selectOption(new SelectOption().setLabel("Illinois"));

        //select value
        stateDropdown.selectOption(new SelectOption().setValue("IL"));
        BrowserUtils.sleepWithThread(1);
        //select index
        stateDropdown.selectOption(new SelectOption().setIndex(14));

        BrowserUtils.sleepWithThread(1);
        //4. Select Virginia with value
        stateDropdown.selectOption(new SelectOption().setValue("VA"));

        BrowserUtils.sleepWithThread(1);
        //5. Select California with index
        stateDropdown.selectOption(new SelectOption().setIndex(5));


        //6. Verify final selected option is California.
        String expectedOptionText = "California";
        String actualSelectedOption = page.evaluate("el=>el.selectedOptions[0].text", stateDropdown.elementHandle()).toString();

        Assertions.assertEquals(expectedOptionText,actualSelectedOption);
        System.out.println("actualSelectedOption = " + actualSelectedOption);


        //wait 3 seconds
        BrowserUtils.sleepWithThread(3);

        //close the page
        page.close();

        //close the browser
        browser.close();

        //close the playwright
        playwright.close();


    }

}
