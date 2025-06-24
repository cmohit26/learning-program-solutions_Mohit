package org.example;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
//import org.junit.runners.Parameterized;

import static org.junit.jupiter.api.Assertions.*;


class EvenCheckerTest {

    private final EvenChecker evenChecker = new EvenChecker();

    @Test
    void testIsEven() {
        assertTrue(new EvenChecker().isEven(2));
        assertFalse(new EvenChecker().isEven(3));
    }

    @ParameterizedTest
    @ValueSource(ints = {8, 6, 2, -10})
    void testWithEven(int number){
        assertTrue(evenChecker.isEven(number), number + " should be even");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, -1})
    void testWithOdd(int number){
        assertFalse(evenChecker.isEven(number), number + " should be odd");
    }

}