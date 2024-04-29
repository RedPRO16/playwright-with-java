package com.cydeo.tests.day_03.homeWork_3;

import com.cydeo.utils.BrowserUtils;
//import com.cydeo.utils.WebOrderUtils;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

import java.util.List;

public class HW01_WebTable_Order_Verify {
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
    public void setupMethod(){
        //1. Open browser
        //1. Open Chrome browser
       page = browser.newContext().newPage();
        //2. Go to: https://practice.cydeo.com/web-tables
        page.navigate("https://practice.cydeo.com/web-tables");
    }

    @AfterEach
    public void tearDownMethod(){

        BrowserUtils.sleepWithThread(3);

        page.close();

    }

    @Test
    public void order_verify_name_test(){

        //2. VerifyBob’s name is listed as expected.
        //below locator is locating me the Bob Martin's cell as where it is currently stored.
        //table[@class='SampleTable']/tbody/tr[7]/td[2]

        //locate Bob's cell using its name as the text.




        //Expected: “Bob Martin”



        //3. VerifyBobMartin’s order date is as expected.
        //WebElement bobsOrderDate = driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']/../td[5]"));

        //Expected: 12/31/2021




    }

  
}
