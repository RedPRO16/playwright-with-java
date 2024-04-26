package com.cydeo.tests.day_01.pac_02_locators_getText_getAttribute;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

public class P04_PlayWrightMethods {

    @Test
    void test() {

        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();
        Browser browser = chromium.launch(
                //if you want to see browser pass this line
                new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://library2.cybertekschool.com/login.html");

        page.getByPlaceholder("Email address", new Page.GetByPlaceholderOptions().setExact(true)).fill("incorrect@gmail.com");

        //page.getByLabel("Password").fill("incorrectpassword");
        //page.getByPlaceholder("Password").fill("incorrectpassword");
        page.querySelector("#inputPassword").fill("incorrectpassword");

        //page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign in")).click(); //if have more than one buttn need to specified!!!

        page.getByRole(AriaRole.BUTTON).click(); //if has only one button use this

        System.out.println(page.getByRole(AriaRole.ALERT).textContent());
        System.out.println(page.getByRole(AriaRole.ALERT).isVisible());

        page.waitForTimeout(3000);

        page.close();
        browser.close();
        playwright.close();


    }
}
