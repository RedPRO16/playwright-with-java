package com.cydeo.tests.day_03.homeWork_3;

import com.cydeo.utils.BrowserUtils;
import com.cydeo.utils.Driver;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HW01_Alert_Practices {

    Page page;
    static Playwright playwright;
    static Browser browser;


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
    public void setupMethod() {
        //1. Open browser
        //1. Open Chrome browser
        page = browser.newContext().newPage();
        //2. Go to website: https://practice.cydeo.com/javascript_alerts
        page.navigate("https://practice.cydeo.com/javascript_alerts");
    }

    @AfterEach
    public void tearDownMethod() {

        BrowserUtils.sleepWithThread(3);

        page.close();
    }

    @Test
    public void confirmation_alert_test2() {
        //TC #2: Confirmation alert practice

        //3. Type "prompt" and click to OK button from the alert (need to handle before action)
        page.onceDialog(dialog -> dialog.accept("prompt"));

        //4. Click to “Click for JS Prompt” button
        Locator promptClick = page.locator("//button[.='Click for JS Prompt']");

        promptClick.click();


        //5. Verify “You entered: prompt” text is displayed.

        String expectedText = "You entered: prompt";
        String actualText = page.locator("#result").textContent();

        System.out.println(actualText);

        assertEquals(expectedText, actualText);

    }

    @Test
    void RAMADAN_solution() {

        Driver.getPage().navigate("https://practice.cydeo.com/javascript_alerts");

        String text = "Text entered testing purpose!";
        Driver.getPage().onceDialog(dialog -> {
            dialog.accept(text);
            String actualResult = Driver.getPage().getByTestId("result").textContent();
            Assertions.assertEquals(actualResult, "You entered: " + text);

            //The Below codes are for debugging purposes:
            System.out.println(Driver.getPage().getByTestId("result").textContent());
            System.out.println(String.format("Dialog message: %s", dialog.message()));
        });
        Driver.getPage().getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Click for JS Prompt")).click();
        Driver.closeDriver();
    }
}




