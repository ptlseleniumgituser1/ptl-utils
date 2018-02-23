package com.pragmatic.util;

import org.testng.annotations.DataProvider;

public class DataSource {


    //NOTE : Ensure the method is static
    @DataProvider(name = "user-credentials-external")
    public static Object[][] userCredentials(){
        return new Object[][]{
                {"", "", "Username cannot be empty"},
                {"Admin", "", "Password cannot be empty"},
                {"", "admin", "Username cannot be empty"},
                {"Test3ed", "asdf", "Invalid credentials"}
        };
    }
}
