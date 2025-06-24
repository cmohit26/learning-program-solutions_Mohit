package org.example;

public class PerformanceTester {

    public void performTask() {
        // Simulated short task (less than 1 second)
        try {
            Thread.sleep(10000); // 300 milliseconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Best practice
            System.out.println(e.getStackTrace() + "Error message displayed");
        }
    }
}
