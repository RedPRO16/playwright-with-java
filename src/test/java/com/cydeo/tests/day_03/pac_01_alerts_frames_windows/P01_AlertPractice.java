package com.cydeo.tests.day_03.pac_01_alerts_frames_windows;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.*;

public class P01_AlertPractice {


    static private Playwright playwright;

    static private Browser browser;

    private Page page;

    @BeforeAll
    static void beforeAll() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setSlowMo(1000)
        );
    }


    @AfterAll
    static void afterAll() {

        browser.close();
        playwright.close();
    }


    @BeforeEach
    void setUp() {
        page = browser.newPage();
        page.navigate("https://practice.cydeo.com/javascript_alerts");
    }

    @AfterEach
    void tearDown() {
        page.close();
    }


    @Test
    void test1() { //ONLY ONE OPTION HANDLED AUTOMATICLY FROM PLAYWRIGHT

        //we need to use before in that example we have only ONE OPTION IN ALERT DIALOG BOX then playwriht will handle without this line!!!!
        page.onceDialog(d -> d.accept());

        page.locator("button")
                //.nth(0) is also use index method (start from 0)
                .first().click();

        String s = page.locator("#result").textContent();

        System.out.println("s = " + s);

    }


    @Test
    void test2() { //IF YOU HAVE TWO OPTION NEED TO HANDLE BY CLICK

        page.onceDialog(d -> d.accept()); //MUST USE BEFORE ACTION THIS CODE TO HANDLE ALERT ACTION IF HVAE TWO OPTION.

        //page.locator("//button[.='Click for JS Confirm']").click(); //other way with location solution common used this

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Click for JS Confirm")).click(); // can use instead of locator with playwright option

        String s = page.locator("#result").textContent();

        System.out.println("s = " + s);
    }
}