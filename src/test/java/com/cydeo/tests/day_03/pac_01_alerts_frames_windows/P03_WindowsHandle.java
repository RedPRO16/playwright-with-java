package com.cydeo.tests.day_03.pac_01_alerts_frames_windows;

import com.cydeo.utils.BrowserUtils;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

public class P03_WindowsHandle {


    static private Playwright playwright;

    static private Browser browser;

    private Page page;

    @BeforeAll
    static void beforeAll() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setSlowMo(1000)  // if use elementHandle must delete this one!!! Also do not use with window handle use promise
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
        page.navigate("https://practice.cydeo.com/windows");
    }

    @AfterEach
    void tearDown() {
        page.close();
    }

    @Test
    void test1() {
         //for Debugging process need t use below code
        //page.pause();  (this the code for playwright inspection for code working steps)

        //get the title
        System.out.println("before clicking page title = " + page.title());

        //click "Click Here" button (it will open a new tab)

        page.click("text=Click Here");

/*
     //   search   it
        ElementHandle locator = page.querySelector("text=Click Here");

        locator.click();
*/

        //get second window title
        BrowserUtils.sleepWithThread(3);

        Page secondPage = page.waitForPopup(() -> {
            page.getByText("Click Here").click();
        });

       // Page secondPage = page.waitForPopup(( )->{}); //if you use this way must delete .setSlowMo(1000)


        System.out.println("after clicking button second page title= " + secondPage.title());

        BrowserUtils.sleepWithThread(3);

        //go back to first page
        page.bringToFront();
        BrowserUtils.sleepWithThread(3);

        //If want to go second page follow below code
        secondPage.bringToFront();
        BrowserUtils.sleepWithThread(3);

        page.bringToFront();

        //Click home

        page.click("text=Home");

        BrowserUtils.sleepWithThread(3);

        //get the title again

        System.out.println("practice title= " + page.title());


    }
}