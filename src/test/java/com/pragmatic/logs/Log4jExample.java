package com.pragmatic.logs;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class Log4jExample {

    private static final Logger logger = LogManager.getLogger(Log4jExample.class);


    @Test
    public void testFatal(){
        //System.out.println("I in FATAL");
        logger.fatal("I in FATAL");
    }

    @Test
    public void testERROR(){
        //System.out.println("I am in ERROR");
        logger.error("I am in ERROR");
    }

    @Test
    public void testWARN(){
        //System.out.println("I am in WARN");
        logger.warn("I am in WARN");
    }


    @Test
    public void testINFO(){
        //System.out.println("I am in INFO");
        logger.info("I am in INFO");
    }


    @Test
    public void testDEBUG(){
        //System.out.println("I am in DEBUG");
        logger.debug("I am in DEBUG");
    }


    @Test
    public void testTrace(){
        //System.out.println("I am in TRACE");
        logger.trace("I am in TRACE");
    }
}
