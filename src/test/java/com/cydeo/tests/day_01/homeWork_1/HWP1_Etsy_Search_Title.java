package com.cydeo.tests.day_01.homeWork_1;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HWP1_Etsy_Search_Title {

    @Test
    void test1() {

        //HWP #1: Etsy Title Verification
        //1. Open Chrome browser
        //Setting up our chromedriver using WebDriverManager


        //Creating a new ChromeDriver and storing it in "driver"

        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();
        Browser browser = chromium.launch(
                //if you want to see browser pass this line
                new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();


        //2. Go to https://www.etsy.com

        page.navigate("https://www.etsy.com");


        Locator cookies = page.locator("//*[@id=\"gdpr-single-choice-overlay\"]/div/div[2]/div[2]/button");
        cookies.click();

        page.waitForTimeout(2000);


        //3. Search for “wooden spoon”
        //page.locator("#global-enhancements-search-query").type("wooden spoon");
        // page.locator("#gnav-search > div > div:nth-child(2) > button").click();

        Locator searchBoxType = page.locator("#global-enhancements-search-query");
        searchBoxType.pressSequentially("wooden spoon", new Locator.PressSequentiallyOptions().setDelay(100));

        page.keyboard().press("Enter");
        page.waitForTimeout(3000);


        //4. Verify title:
        //Expected: “Wooden spoon - Etsy”

        String expectedTitle = "Wooden spoon - Etsy UK";

        String actualTitle = page.title();

        System.out.println(actualTitle);

        Assertions.assertEquals(expectedTitle, actualTitle);


        //close the page
        page.close();

        //close the browser
        browser.close();

        //close the playwright
        playwright.close();
    }
}