package DeepSkilling.EngConcepts.AlgoDataStructure.Exercise3.Code;

public class Main {
    public static void main(String[] args) {
        Order[] orders = {
                new Order(101, "Alice", 250.75),
                new Order(102, "Bob", 150.00),
                new Order(103, "Charlie", 320.50),
                new Order(104, "Diana", 180.25)
        };

        // Bubble Sort
        System.out.println("Before Bubble Sort:");
        printOrders(orders);
        SortAlgorithms.bubbleSort(orders);
        System.out.println("After Bubble Sort:");
        printOrders(orders);

        // Quick Sort
        System.out.println("\nBefore Quick Sort:");
        printOrders(orders);
        SortAlgorithms.quickSort(orders, 0, orders.length - 1);
        System.out.println("After Quick Sort:");
        printOrders(orders);
    }

    private static void printOrders(Order[] orders) {
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
