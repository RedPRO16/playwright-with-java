package com.cydeo.tests.day_03.homeWork_3;

import com.cydeo.utils.BrowserUtils;
import com.cydeo.utils.ConfigurationReader;
import com.cydeo.utils.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HW01_Registration_Form {


    @BeforeEach
    public void setupMethod(){
        //1. Open browser
        //2. Go to website:https://practice.cydeo.com/registration_form
        Driver.getPage().navigate(ConfigurationReader.getProperty("registration.form.url"));

    }

    @AfterEach
    void tearDown() {

        BrowserUtils.sleepWithThread(3);
        Driver.closeDriver();
    }


    @Test
    public void registration_form(){
        //3. Enter first name


        //4. Enter last name


        //5. Enter username


        //6. Enter email address


        //7. Enter password


        //8. Enter phone number


        //9. Select a gender from radio buttons


        //10.Enter date of birth


        //11.Select Department/Office

        //departmentDropdown.selectByVisibleText("Department of Engineering");


        //12.Select Job Title


        //13.Select programming language from checkboxes


        //14.Click to sign up button

        //15.Verify success message “You’ve successfully completed registration.” is displayed.
       


    }



}
