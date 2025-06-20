package DeepSkilling.EngConcepts.AlgoDataStructure.Exercise4.Code;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager(5);

        // Adding employees
        manager.addEmployee(new Employee(1, "Alice", "Developer", 70000));
        manager.addEmployee(new Employee(2, "Bob", "Designer", 65000));
        manager.addEmployee(new Employee(3, "Charlie", "Manager", 90000));

        System.out.println("All employees:");
        manager.traverseEmployees();

        // Searching an employee
        Employee emp = manager.searchEmployee(2);
        System.out.println("\nSearch result for employeeId 2:");
        System.out.println(emp != null ? emp : "Employee not found");

        // Deleting an employee
        boolean deleted = manager.deleteEmployee(1);
        System.out.println("\nDeleting employee with employeeId 1: " + (deleted ? "Success" : "Failed"));

        System.out.println("\nEmployees after deletion:");
        manager.traverseEmployees();
    }
}
