package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    private final MathUtils mathUtils = new MathUtils();

    @Test
    void testAdd(){
        assertEquals(5, mathUtils.add(2,3));
    }

}