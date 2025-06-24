package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExceptionThrowerTest {

    @Test
    void testThrowsIllegalArgumentException() {
        ExceptionThrower thrower = new ExceptionThrower();

        // Assert that the exception is thrown
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                thrower::throwException,
                "Expected throwException() to throw, but it didn't"
        );

        // Optionally assert the exception message
        assertEquals("This is an expected exception", thrown.getMessage());
    }
}