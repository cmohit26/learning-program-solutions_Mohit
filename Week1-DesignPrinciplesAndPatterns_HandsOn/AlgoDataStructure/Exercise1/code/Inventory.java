package DeepSkilling.EngConcepts.AlgoDataStructure.Exercise1.code;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

    private Map<Integer, Product> productMap;

    public Inventory() {
        productMap = new HashMap<>();
    }

    // Add Product
    public void addProduct(Product product) {
        if (productMap.containsKey(product.getProductId())) {
            System.out.println("Product ID already exists.");
        } else {
            productMap.put(product.getProductId(), product);
            System.out.println("Product added.");
        }
    }

    // Update Product
    public void updateProduct(int productId, String newName, int newQuantity, double newPrice) {
        Product product = productMap.get(productId);
        if (product != null) {
            product.setProductName(newName);
            product.setQuantity(newQuantity);
            product.setPrice(newPrice);
            System.out.println("Product updated.");
        } else {
            System.out.println("Product not found.");
        }
    }

    // Delete Product
    public void deleteProduct(int productId) {
        if (productMap.remove(productId) != null) {
            System.out.println("Product deleted.");
        } else {
            System.out.println("Product not found.");
        }
    }

    // Display Inventory
    public void displayInventory() {
        if (productMap.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (Product p : productMap.values()) {
                System.out.println(p);
            }
        }
    }
}