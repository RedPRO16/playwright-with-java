package com.cydeo.tests.day_03.homeWork_3;

import com.cydeo.utils.BrowserUtils;
import com.cydeo.utils.ConfigurationReader;
import com.cydeo.utils.Driver;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Response;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.SelectOption;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HW01_Registration_Form {


    @BeforeEach
    public void setupMethod() {
        //1. Open browser
        //2. Go to website:https://practice.cydeo.com/registration_form
        // Driver.getPage().navigate(ConfigurationReader.getProperty("registrationForm"));
        Driver.getPage().navigate("https://practice.cydeo.com/registration_form");

    }

    @AfterEach
    void tearDown() {

        BrowserUtils.sleepWithThread(3);
        Driver.closeDriver();
    }


    @Test
    public void registration_form() {
        //3. Enter first name
        Driver.getPage().locator("//input[@name='firstname']").fill("Neso");

        //4. Enter last name
        Driver.getPage().locator("//input[@name='lastname']").fill("RDV");


        //5. Enter username
        Driver.getPage().locator("//input[@name='username']").fill("redprooo");


        //6. Enter email address
        Driver.getPage().locator("//input[@name='email']").fill("redpro@gmail.com");


        //7. Enter password
        Driver.getPage().locator("//input[@name='password']").fill("12345678");

        //8. Enter phone number
        Driver.getPage().locator("//input[@name='phone']").fill("571-000-0000");


        //9. Select a gender from radio buttons
        //Locator male = Driver.getPage().getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName("Male"));
        Locator male = Driver.getPage().locator("//input[@value='male']");

        male.click();

        //10.Enter date of birth
        Driver.getPage().locator("//input[@name='birthday']").fill("04/09/1982");

        //11.Select Department/Office

        Locator departmentDropdown = Driver.getPage().locator("//select[@name='department']");
        //departmentDropdown.selectByVisibleText("Department of Engineering");

        departmentDropdown.selectOption(new SelectOption().setValue("DE"));

        // If an assertion need from dropdown picked option by name need to use below code
        String s = Driver.getPage().evaluate("el=>el.selectedOptions[0].text", departmentDropdown.elementHandle()).toString();
        System.out.println(s);

        BrowserUtils.sleepWithThread(3);
        //12.Select Job Title
        Locator jobTitle = Driver.getPage().locator("//select[@name='job_title']");
        jobTitle.selectOption(new SelectOption().setLabel("SDET"));
        //Driver.getPage().evaluate("el=>el.selectedOptions[0].text", jobTitle.elementHandle()).toString();

        BrowserUtils.sleepWithThread(3);
        //13.Select programming language from checkboxes
        Locator Java = Driver.getPage().locator("#inlineCheckbox2");
        Java.check();
        Locator JavaScript = Driver.getPage().locator("#inlineCheckbox3");
        JavaScript.check();


        //14.Click to sign up button

        //Driver.getPage().locator("#wooden_spoon").click();

        Driver.getPage().getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign up")).click();

        //15.Verify success message “You’ve successfully completed registration.” is displayed.

        String expected = "You've successfully completed registration!";
        String actual = Driver.getPage().locator("//*[@id=\"content\"]/div/div/p").textContent();
        Assertions.assertEquals(expected, actual);

    }


}
