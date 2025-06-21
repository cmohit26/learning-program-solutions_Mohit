package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTest {
    @Test
    public void testAssertions() {
        // Assert equals
        assertEquals(5, 2 + 3);
        System.out.println("Assertion 1 Passed");

        // Assert true
        assertTrue(5 > 3);
        System.out.println("Assertion 2 Passed");

        // Assert false
        assertFalse(5 < 3);
        System.out.println("Assertion 3 Passed");

        // Assert null
        assertNull(null);
        System.out.println("Assertion 4 Passed");

        // Assert not null
        assertNotNull(new Object());
        System.out.println("Assertion 5 Passed");
    }
}