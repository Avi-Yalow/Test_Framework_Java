package com.moonactive.utils;

import com.moonactive.config.Config;

import java.io.IOException;
import java.util.logging.*;

import static com.moonactive.utils.Constants.LOG_FILE_PATH;


public class Reporter  {

    private static Logger logger = Logger.getLogger("tests reporter");
    private static Reporter instance;
    private Reporter() {
        init();
    }

    public static Reporter getInstance() {
        if (instance == null) {
            instance = new Reporter();
        }
        return instance;
    }

    public void init (){
        FileHandler fh;
        try{
            fh = new FileHandler(LOG_FILE_PATH);
            logger.addHandler(new StreamHandler(System.out, new SimpleFormatter()));
            fh.setFormatter(new SimpleFormatter());
            logger.info("Logger initialize");
        } catch (IOException e) {
            logger.log(Level.WARNING,"Exception :: ", e);
        }
    }
    public void log(String msg){
        logger.info(msg);
    }
}
