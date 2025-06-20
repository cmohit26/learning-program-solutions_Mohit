package DeepSkilling.EngConcepts.AlgoDataStructure.Exercise4.Code;

public class EmployeeManager {
    private Employee[] employees;
    private int count;  // number of employees currently stored

    public EmployeeManager(int capacity) {
        employees = new Employee[capacity];
        count = 0;
    }

    // Add employee
    public boolean addEmployee(Employee employee) {
        if (count >= employees.length) {
            System.out.println("Employee array is full. Cannot add more employees.");
            return false;
        }
        employees[count++] = employee;
        return true;
    }

    // Search employee by employeeId
    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    // Traverse (print all employees)
    public void traverseEmployees() {
        if (count == 0) {
            System.out.println("No employees found.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    // Delete employee by employeeId
    public boolean deleteEmployee(int employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == employeeId) {
                // Shift elements left to overwrite the deleted employee
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[count - 1] = null; // clear last element
                count--;
                return true;
            }
        }
        return false;
    }
}
