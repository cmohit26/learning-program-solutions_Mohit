package DeepSkilling.EngConcepts.DesignPrinciples_Patterns.Exercise1.code;

// File: Logger.java
public class Logger {
    // Step 1: Create a private static instance of Logger
    private static Logger instance;

    // Step 2: Make the constructor private so it cannot be instantiated outside
    private Logger() {
        System.out.println("Logger initialized.");
    }

    // Step 3: Provide a public static method to get the single instance
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Sample method to demonstrate functionality
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}
