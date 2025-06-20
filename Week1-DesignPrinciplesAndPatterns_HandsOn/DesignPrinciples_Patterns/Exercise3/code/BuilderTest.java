package DeepSkilling.EngConcepts.DesignPrinciples_Patterns.Exercise3.code;

// ComputerBuilderTest.java
public class BuilderTest {
    public static void main(String[] args) {
        // Basic computer
        Computer basicComputer = new Computer.Builder("Intel i3", "4GB")
                .build();

        // Gaming computer
        Computer gamingComputer = new Computer.Builder("Intel i9", "32GB")
                .storage("1TB SSD")
                .graphicsCard("NVIDIA RTX 4090")
                .operatingSystem("Windows 11")
                .build();

        // Developer workstation
        Computer devComputer = new Computer.Builder("AMD Ryzen 9", "64GB")
                .storage("2TB SSD")
                .graphicsCard("NVIDIA RTX 3080")
                .operatingSystem("Ubuntu 24.04")
                .build();

        // Print all configurations
        System.out.println("Basic Computer: " + basicComputer);
        System.out.println("Gaming Computer: " + gamingComputer);
        System.out.println("Developer Workstation: " + devComputer);
    }
}
