package DeepSkilling.EngConcepts.AlgoDataStructure.Exercise2.Code;

public class Main {

    public static void main(String[] args) {
        Product[] products = {
                new Product(3, "Mouse", "Electronics"),
                new Product(1, "Laptop", "Electronics"),
                new Product(2, "Chair", "Furniture"),
                new Product(4, "Notebook", "Stationery")
        };

        // Linear Search
        Product found = Product_SearchAlgorithms.linearSearch(products, 2);
        System.out.println("Linear Search Result: " + (found != null ? found : "Not Found"));

        // Binary Search (requires sorting first)
        Product_SearchAlgorithms.sortByProductId(products);
        found = Product_SearchAlgorithms.binarySearch(products, 2);
        System.out.println("Binary Search Result: " + (found != null ? found : "Not Found"));
    }

}

