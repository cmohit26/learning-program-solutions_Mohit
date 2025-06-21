package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AAACalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        // This runs BEFORE each @Test method
        calculator = new Calculator();
        System.out.println("Setup: Created Calculator instance");
    }

    @After
    public void tearDown() {
        // This runs AFTER each @Test method
        calculator = null;
        System.out.println("Teardown: Cleared Calculator instance");
    }

    @Test
    public void testAdd() {
        // Arrange
        int a = 10;
        int b = 5;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(15, result);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        // Arrange
        int a = 10;
        int b = 0;

        // Act (and Assert that exception is thrown)
        calculator.divide(a, b);
    }
}
