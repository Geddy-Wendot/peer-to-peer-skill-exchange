import java.util.ArrayList;

public class Student {
    private String name;
    private String course;

    public Student(String name, String course) {
        this.name = name;
        this.course = course;
    }

    public String getName() {
        return name;
    }
    public String getCourse() {
        return course;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', course='" + course + "'}";
    }
}

class StudentDatabase {
    private final ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }
    public void listStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }
    public void deleteStudent(String name) {
        students.removeIf(student -> student.getName().equals(name));
    }
}
class Database {
    public static void main(String[] args) {
        StudentDatabase db = new StudentDatabase();

        /* Adding students */
        db.addStudent(new Student("Alice", "Mathematics"));
        db.addStudent(new Student("Bob", "Physics"));
        db.addStudent(new Student("Charlie", "Chemistry"));

        /* Listing students */
        System.out.println("Students in the database:");
        db.listStudents();

        /* Deleting a student */
        db.deleteStudent("Bob");

        /* Listing students after deletion */
        System.out.println("\nStudents in the database after deletion:");
        db.listStudents();
    }
}