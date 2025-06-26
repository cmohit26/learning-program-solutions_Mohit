package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Exercise 1
public class LoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        logger.error("This is an error message");
        logger.warn("This is a warning message");
    }
}
