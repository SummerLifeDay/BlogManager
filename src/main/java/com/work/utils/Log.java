package com.work.utils;

import com.work.manager.ManagerApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Log {

    private static Logger logger = LoggerFactory.getLogger(ManagerApplication.class);;

    public static void print(String str){
        logger.info(str);
    }
}
