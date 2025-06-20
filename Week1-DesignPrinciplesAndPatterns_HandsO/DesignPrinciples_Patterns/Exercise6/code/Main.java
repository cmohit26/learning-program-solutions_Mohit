package DeepSkilling.EngConcepts.DesignPrinciples_Patterns.Exercise6.code;

// File: Main.java
public class Main {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("image1.jpg");
        Image image2 = new ProxyImage("image2.jpg");

        // First call - image is loaded from remote
        image1.display();

        // Second call - image is cached
        image1.display();

        // First call - loads new image
        image2.display();
    }
}
