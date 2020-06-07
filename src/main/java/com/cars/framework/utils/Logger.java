package com.cars.framework.utils;

public class Logger {
    private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Logger.class);

    public static void info(final String message) {
        logger.info(message);
    }

    public static void warn(final String message) {
        logger.warn(message);
    }

    public static void step(int step, final String message) {
        logger.info("Step " + step + ". " + message);
    }
}