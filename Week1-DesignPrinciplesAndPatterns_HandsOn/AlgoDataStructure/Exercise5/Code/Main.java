package DeepSkilling.EngConcepts.AlgoDataStructure.Exercise5.Code;

public class Main {
    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();

        taskList.addTask(new Task(1, "Design UI", "Pending"));
        taskList.addTask(new Task(2, "Write API", "In Progress"));
        taskList.addTask(new Task(3, "Test Application", "Completed"));

        System.out.println("All Tasks:");
        taskList.displayTasks();

        System.out.println("\nSearching for Task with ID 2:");
        Task foundTask = taskList.searchTask(2);
        System.out.println(foundTask != null ? foundTask : "Task not found.");

        System.out.println("\nDeleting Task with ID 1:");
        boolean deleted = taskList.deleteTask(1);
        System.out.println(deleted ? "Task deleted successfully." : "Task not found.");

        System.out.println("\nTasks After Deletion:");
        taskList.displayTasks();
    }
}
