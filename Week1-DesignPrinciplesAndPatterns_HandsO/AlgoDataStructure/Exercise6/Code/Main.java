package DeepSkilling.EngConcepts.AlgoDataStructure.Exercise6.Code;

import DeepSkilling.EngConcepts.AlgoDataStructure.Exercise5.Code.Task;
import DeepSkilling.EngConcepts.AlgoDataStructure.Exercise5.Code.TaskLinkedList;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Book[] books = {
                new Book(1, "The Hobbit", "J.R.R. Tolkien"),
                new Book(2, "1984", "George Orwell"),
                new Book(3, "Brave New World", "Aldous Huxley"),
                new Book(4, "Moby Dick", "Herman Melville")
        };

        // Sort the books by title for binary search
        Arrays.sort(books, Comparator.comparing(Book::getTitle, String.CASE_INSENSITIVE_ORDER));

        String searchTitle = "1984";

        // Linear Search
            long startTime = System.nanoTime();
        Book foundLinear = Book_SearchAlgorithms.linearSearch(books, searchTitle);
            long endTime = System.nanoTime();
        System.out.println("Linear Search Result: " + (foundLinear != null ? foundLinear : "Not Found"));
            long duration = endTime - startTime;
            System.out.println("Execution time in nanoseconds: " + duration);

        // Binary Search
            long startTime2 = System.nanoTime();
        Book foundBinary = Book_SearchAlgorithms.binarySearch(books, searchTitle);
            long endTime2 = System.nanoTime();
        System.out.println("Binary Search Result: " + (foundBinary != null ? foundBinary : "Not Found"));
            long duration2 = endTime2 - startTime2;
            System.out.println("Execution time in nanoseconds: " + duration2);


    }
}
