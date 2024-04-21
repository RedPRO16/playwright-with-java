package com.cydeo.tests.day_01.pac_01_playwright_intro;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class P01_PlayWrightTest {

    
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();

        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false)); //if you want to see browser pass this line - cause playwright defaults use headless browser.

        Page page = browser.newPage();
        page.navigate("https://www.google.com/");

        Thread.sleep(3000);

        page.close();
        browser.close();
        playwright.close();


    }
}
