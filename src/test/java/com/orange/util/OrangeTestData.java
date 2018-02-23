package com.orange.util;

import org.testng.annotations.DataProvider;

public class OrangeTestData {




    @DataProvider(name="orange-test-data")
    public static Object[][] loginTestData(){
        return new Object[][]{
                {"", "", "Username cannot be empty"},
                {"", "Admin", "Username cannot be empty"},
                {"Admin", "", "Password cannot be empty"},
                {"Admin", "InvalidPW", "Invalid credentials"}
        };

    }
}
