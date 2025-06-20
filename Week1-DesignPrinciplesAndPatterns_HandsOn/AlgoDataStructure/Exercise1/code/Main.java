package DeepSkilling.EngConcepts.AlgoDataStructure.Exercise1.code;

public class Main {

    public static void main(String[] args) {

        Inventory inventory = new Inventory();

        Product p1 = new Product(101, "Laptop", 5, 999.99);
        Product p2 = new Product(102, "Phone", 10, 599.99);

        inventory.addProduct(p1);
        inventory.addProduct(p2);

        inventory.displayInventory();

        inventory.updateProduct(101, "Gaming Laptop", 3, 1299.99);
        inventory.deleteProduct(102);

        inventory.displayInventory();

    }

}



