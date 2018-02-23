package com.orange.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {


    public static void main(String[] args) throws Exception {

        //Create an instance of Properties class
        Properties properties= new Properties();

        //Create an input stream using the property file
        InputStream inputStream = new FileInputStream("conf/selenium.properties");

        //Load the properties into the properties instance
        properties.load(inputStream);


        //Call get methods to read the properties
        System.out.printf("Browser name " + properties.getProperty("browser.name"));



    }
}
