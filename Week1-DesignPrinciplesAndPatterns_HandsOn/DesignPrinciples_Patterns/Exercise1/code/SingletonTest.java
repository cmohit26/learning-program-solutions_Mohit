package DeepSkilling.EngConcepts.DesignPrinciples_Patterns.Exercise1.code;

// File: SingletonTest.java
public class SingletonTest {
    public static void main(String[] args) {
        // Get Logger instances
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Use the logger
        logger1.log("First log message");
        logger2.log("Second log message");

        // Check if both instances are the same
        if (logger1 == logger2) {
            System.out.println("Both logger instances are the same (Singleton confirmed).");
        } else {
            System.out.println("Logger instances are different (Singleton failed).");
        }
    }
}
