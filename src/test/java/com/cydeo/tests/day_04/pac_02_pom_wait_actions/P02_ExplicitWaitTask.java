package com.cydeo.tests.day_04.pac_02_pom_wait_actions;

import com.cydeo.pages.DynamicPage;
import com.cydeo.pages.LibraryLoginPage;
import com.cydeo.utils.BrowserUtils;
import com.cydeo.utils.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class P02_ExplicitWaitTask {

    @BeforeEach
    void setUp() {
        Driver.getPage().navigate("https://practice.cydeo.com/dynamic_loading/7");
    }


    @AfterEach
    void tearDown() {

        BrowserUtils.sleepWithThread(3);

        Driver.closeDriver();
    }

    @Test
    void test1() {
        DynamicPage dynamicPage = new DynamicPage();

        /* JS comments
        1=='1'  //true --> checking only value !!!

        1==='1' false  --> checking value and date type !!!
         */

        //Driver.getPage().waitForFunction("document.URL.includes('search')");
        Driver.getPage().waitForFunction("document.title === 'Dynamic title'");

        //  BrowserUtils.sleepWithThread(6); if use this code will be static wait but not preferred!!!

        System.out.println(dynamicPage.getAlertMessage().textContent());
        Assertions.assertTrue(dynamicPage.getAlertMessage().textContent().contains("Done"));


    }
}
