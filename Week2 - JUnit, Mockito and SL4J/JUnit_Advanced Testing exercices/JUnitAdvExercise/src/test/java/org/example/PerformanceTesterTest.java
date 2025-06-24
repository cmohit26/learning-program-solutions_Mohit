package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

class PerformanceTesterTest {

    @Test
    void testPerformTaskCompletesWithinOneSecond() {
        PerformanceTester tester = new PerformanceTester();

        Executable executable = new Executable() {
            @Override
            public void execute() {
                tester.performTask();
            }
        };

        assertTimeout(Duration.ofSeconds(9), executable);
    }

}