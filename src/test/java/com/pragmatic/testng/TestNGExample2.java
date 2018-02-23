package com.pragmatic.testng;

import org.testng.annotations.Test;

public class TestNGExample2 {



    @Test(priority = 0)
    public void aTest(){
        System.out.println("I am in aTest");
    }

    @Test(priority = 1)
    public void bTest(){
        System.out.println("I am in bTest");
    }


    @Test(priority = 3)
    public void wTest(){
        System.out.println("I am in wTest");
    }


    @Test
    public void zTest(){
        System.out.println("I am in zTest");
    }



    @Test(priority =2)
    public void aaTest(){
        System.out.println("I am in aaTest");
    }
}
