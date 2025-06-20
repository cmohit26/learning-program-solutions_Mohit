package DeepSkilling.EngConcepts.DesignPrinciples_Patterns.Exercise10.code;

public class MVCPatternExample {

    // Model
    static class Student {
        private String name;
        private int id;
        private String grade;

        public Student(String name, int id, String grade) {
            this.name = name;
            this.id = id;
            this.grade = grade;
        }

        // Getters and setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }
    }

    // View
    static class StudentView {
        public void displayStudentDetails(String name, int id, String grade) {
            System.out.println("Student Details:");
            System.out.println("Name: " + name);
            System.out.println("ID: " + id);
            System.out.println("Grade: " + grade);
        }
    }

    // Controller
    static class StudentController {
        private Student model;
        private StudentView view;

        public StudentController(Student model, StudentView view) {
            this.model = model;
            this.view = view;
        }

        // Update model data
        public void setStudentName(String name) {
            model.setName(name);
        }

        public String getStudentName() {
            return model.getName();
        }

        public void setStudentId(int id) {
            model.setId(id);
        }

        public int getStudentId() {
            return model.getId();
        }

        public void setStudentGrade(String grade) {
            model.setGrade(grade);
        }

        public String getStudentGrade() {
            return model.getGrade();
        }

        // Update view
        public void updateView() {
            view.displayStudentDetails(model.getName(), model.getId(), model.getGrade());
        }
    }

    // Main method to test MVC
    public static void main(String[] args) {
        // Create model
        Student student = new Student("Alice", 101, "A");

        // Create view
        StudentView view = new StudentView();

        // Create controller
        StudentController controller = new StudentController(student, view);

        // Display initial details
        controller.updateView();

        System.out.println("\nUpdating student details...\n");

        // Update student details via controller
        controller.setStudentName("Bob");
        controller.setStudentId(202);
        controller.setStudentGrade("B+");

        // Display updated details
        controller.updateView();
    }
}

