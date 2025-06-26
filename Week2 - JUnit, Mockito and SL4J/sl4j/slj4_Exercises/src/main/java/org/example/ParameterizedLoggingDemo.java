package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Exercise 2
public class ParameterizedLoggingDemo {

    // Create a logger instance for this class
    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingDemo.class);

    public static void main(String[] args) {
        String user = "Alice";
        int itemsPurchased = 5;
        double totalPrice = 123.45;

        // Parameterized logging: placeholders {} are replaced by provided arguments
        logger.info("User {} purchased {} items for a total price of Rs.{}.", user, itemsPurchased, totalPrice);

        // Demonstrate different log levels
        logger.debug("This is a debug message, only visible if debug level is enabled.");
        logger.warn("This is a warning message.");
        logger.error("This is an error message.");
    }
}
