package DeepSkilling.EngConcepts.DesignPrinciples_Patterns.Exercise3.code;

// Computer.java
public class Computer {
    // Required parameters
    private final String cpu;
    private final String ram;

    // Optional parameters
    private final String storage;
    private final String graphicsCard;
    private final String operatingSystem;

    // Private constructor accepts Builder
    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.operatingSystem = builder.operatingSystem;
    }

    @Override
    public String toString() {
        return "Computer {" +
                "CPU='" + cpu + '\'' +
                ", RAM='" + ram + '\'' +
                ", Storage='" + storage + '\'' +
                ", Graphics Card='" + graphicsCard + '\'' +
                ", OS='" + operatingSystem + '\'' +
                '}';
    }

    // ✅ 3. Implement the Builder Class
    public static class Builder {
        // Required parameters
        private final String cpu;
        private final String ram;

        // Optional parameters - initialized to default values
        private String storage = "256GB SSD";
        private String graphicsCard = "Integrated";
        private String operatingSystem = "Linux";

        public Builder(String cpu, String ram) {
            this.cpu = cpu;
            this.ram = ram;
        }

        public Builder storage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder graphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Builder operatingSystem(String operatingSystem) {
            this.operatingSystem = operatingSystem;
            return this;
        }

        // ✅ build() method returns Computer instance
        public Computer build() {
            return new Computer(this);
        }
    }
}
