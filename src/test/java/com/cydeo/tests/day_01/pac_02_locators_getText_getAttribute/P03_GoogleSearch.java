package com.cydeo.tests.day_01.pac_02_locators_getText_getAttribute;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;

public class P03_GoogleSearch {
    @Test
    void test1() {

        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();
        Browser browser = chromium.launch(
                //if you want to see browser pass this line
                new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://www.google.com");

        Locator acceptCookies = page.locator("//*[@id=\"L2AGLb\"]/div");
        acceptCookies.click();


        //locate the element with Css and Xpath
        // Locator searchBoxElement = page.locator("textarea[name='q']");  // with Css
        Locator searchBoxElement = page.locator("//textarea[@name='q']");  //with Xpath

        // searchBoxElement.type("Selenium");
        // searchBoxElement.fill("Selenium");
        searchBoxElement.pressSequentially("Selenium",
                //put that statement to put delay between letters while writing like human typing action.
                new Locator.PressSequentiallyOptions().setDelay(100));

        Keyboard keyboard = page.keyboard();
        keyboard.press("Enter");

        page.waitForTimeout(3000);


        //must have at every class this 3 close...
        page.close();
        browser.close();
        playwright.close();

    }
}
