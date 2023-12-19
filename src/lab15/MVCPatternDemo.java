package lab15;

public class MVCPatternDemo {
    public static void main(String[] args) {
        Student model = retrieveStudentFromDatabase();

        StudentView view = new StudentView();

        StudentController controller = new StudentController(model, view);

        controller.setStudentName("John");
        controller.setStudentRollNo("12345");

        controller.updateView();
    }

    public static Student retrieveStudentFromDatabase() {
        Student student = new Student();
        student.setName("Jane");
        student.setRollNo("54321");
        return student;
    }
}
