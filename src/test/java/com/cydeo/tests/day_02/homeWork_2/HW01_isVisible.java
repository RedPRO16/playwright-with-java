package com.cydeo.tests.day_02.homeWork_2;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HW01_isVisible {
    @Test
    void test1() {
        //1. Open Chrome browser
        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();

        //2- Go to: https://practice.cydeo.com/abtest
        page.navigate("https://practice.cydeo.com/abtest");


        //3- Locate “CYDEO” link, verify it is displayed.

        //ElementHandle cydeoText = page.querySelector("a:has-text('CYDEO')");

        Locator cydeoText = page.locator("//*[text()='CYDEO']");

        //Assertions.assertEquals("CYDEO",cydeoText.textContent());
        Assertions.assertTrue(cydeoText.isVisible());

        //assertThat(page.getByText("CYDEO")).isVisible();

        //System.out.println("cydeo = " + cydeoText);


        //4- Refresh the page.
        page.reload();


        //5- Verify it is displayed, again.
        //assertThat(page.getByText("CYDEO").last()).isVisible();
        //assertThat(page.getByText("CYDEO")).isVisible();

        System.out.println(page.getByText("CYDEO").isVisible());


        //close the page
        page.close();
        //close the browser
        browser.close();
        //close the playwright
        playwright.close();

    }
}
