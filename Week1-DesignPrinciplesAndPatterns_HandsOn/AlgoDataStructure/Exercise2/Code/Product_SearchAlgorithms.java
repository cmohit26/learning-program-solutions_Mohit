package DeepSkilling.EngConcepts.AlgoDataStructure.Exercise2.Code;

import java.util.Arrays;
import java.util.Comparator;

public class Product_SearchAlgorithms {

    // Linear search by productId
    public static Product linearSearch(Product[] products, int targetId) {
        for (Product product : products) {
            if (product.productId == targetId) {
                return product;
            }
        }
        return null;
    }

    // Binary search assumes array is sorted by productId
    public static Product binarySearch(Product[] products, int targetId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (products[mid].productId == targetId) {
                return products[mid];
            } else if (products[mid].productId < targetId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    // Utility to sort array by productId
    public static void sortByProductId(Product[] products) {
        Arrays.sort(products, Comparator.comparingInt(p -> p.productId));
    }

}
