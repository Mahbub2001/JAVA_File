import java.io.*;
import java.util.ArrayList;

class Student implements Serializable {
    private String name;
    private int rollNumber;

    public Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber;
    }
}

public class StudentManagementSystem {

    private static final String FILE_NAME = "students.ser";

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        // Add some students
        students.add(new Student("John Doe", 1));
        students.add(new Student("Jane Smith", 2));
        students.add(new Student("Alice Johnson", 3));

        // Save students to a file
        saveStudentsToFile(students);

        // Load students from file
        ArrayList<Student> loadedStudents = loadStudentsFromFile();

        // Display loaded students
        if (loadedStudents != null) {
            for (Student student : loadedStudents) {
                System.out.println(student);
            }
        }
    }

    private static void saveStudentsToFile(ArrayList<Student> students) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            outputStream.writeObject(students);
            System.out.println("Students saved to file.");
        } catch (IOException e) {
            System.out.println("An error occurred while saving students: " + e.getMessage());
        }
    }

    private static ArrayList<Student> loadStudentsFromFile() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            ArrayList<Student> students = (ArrayList<Student>) inputStream.readObject();
            System.out.println("Students loaded from file.");
            return students;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("An error occurred while loading students: " + e.getMessage());
            return null;
        }
    }
}
