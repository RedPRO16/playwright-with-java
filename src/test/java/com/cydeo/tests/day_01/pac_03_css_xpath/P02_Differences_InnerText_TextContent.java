package com.cydeo.tests.day_01.pac_03_css_xpath;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;

public class P02_Differences_InnerText_TextContent {

    @Test
    void test1() {

        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();
        Browser browser = chromium.launch(
                //if you want to see browser pass this line
                new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("http://localhost:63342/playwright-with-java/INTERVIEW%20PREP%20DOCS/MARKET%20PROCESS/SDET%20Fast%20Track7_Mar_24/playwright-with-java/src/test/resources/getText.html?_ijt=si7uqdr65ttrnhfp8q9v5j4o51&_ij_reload=RELOAD_ON_SAVE");

        String textContent = page.querySelector("#example").textContent();
        String innerText = page.querySelector("#example").innerText();

        System.out.println("textContent = " + textContent);
        System.out.println("innerText = " + innerText);

        page.waitForTimeout(3000);
        page.close();
        browser.close();
        playwright.close();




    }
}
