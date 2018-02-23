package com.pragmatic.testng;

import org.testng.annotations.Test;

public class TestNGExample3 {



    @Test(timeOut = 5000)
    public void aTest(){
        System.out.println("I am in aTest");
    }

    @Test(invocationCount = 3)
    public void bTest(){
        System.out.println("I am in bTest");
    }

    @Test(dependsOnMethods ={"zTest"})
    public void wTest(){
        System.out.println("I am in wTest");
    }

    @Test
    public void zTest(){
        System.out.println("I am in zTest");
    }

    @Test
    public void aaTest(){
        System.out.println("I am in aaTest");
    }
}
