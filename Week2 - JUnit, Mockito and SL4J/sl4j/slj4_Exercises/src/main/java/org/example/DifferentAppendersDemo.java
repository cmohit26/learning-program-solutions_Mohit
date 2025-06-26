package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Exercise 3
public class DifferentAppendersDemo {

    private static final Logger logger = LoggerFactory.getLogger(DifferentAppendersDemo.class);

    public static void main(String[] args) {
        logger.info("This is an INFO message.");
        logger.debug("This is a DEBUG message.");
        logger.warn("This is a WARN message.");
        logger.error("This is an ERROR message.");

        String user = "Bob";
        int attempts = 3;
        logger.info("User {} attempted to login {} times.", user, attempts);
    }
}

