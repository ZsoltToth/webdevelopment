package hu.uni.miskolc.iit.swtest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Hello world!
 */
public class App {

    private static Logger LOGGER = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println("I am lazy AF!");

        LOGGER.info("Info");
        LOGGER.warn("warning");
        LOGGER.error("shit happens");
        LOGGER.fatal("Ups");
    }
}
