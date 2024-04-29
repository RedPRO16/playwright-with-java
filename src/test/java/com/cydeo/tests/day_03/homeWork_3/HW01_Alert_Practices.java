package com.cydeo.tests.day_03.homeWork_3;

import com.cydeo.utils.BrowserUtils;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HW01_Alert_Practices {

    Page page;
  static   Playwright playwright;
  static   Browser browser;


    @BeforeAll
    static void beforeAll() {
        //1. Open browser
        //1. Open Chrome browser
        playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();
        browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(List.of("--lang=en-US", "--force-english-ui")));
    }

    @AfterAll
    static void afterAll() {
        browser.close();
        playwright.close();
    }

    @BeforeEach
    public void setupMethod(){
        //1. Open browser
        //1. Open Chrome browser
        page = browser.newContext().newPage();
        //2. Go to website: https://practice.cydeo.com/javascript_alerts
        page.navigate("https://practice.cydeo.com/javascript_alerts");
    }

    @AfterEach
    public void tearDownMethod(){

        BrowserUtils.sleepWithThread(3);

        page.close();
    }

    @Test
    public void confirmation_alert_test2(){
        //TC #2: Confirmation alert practice

        //3. Click to “Click for JS Prompt” button


        //4. Type "prompt" and click to OK button from the alert
     


        //5. Verify “You entered: prompt” text is displayed.

    }



}




