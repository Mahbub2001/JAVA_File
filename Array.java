import java.io.*;
import java.util.Scanner;

public class Array {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);

        // Get the number of students from the user
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Student[] students = new Student[numStudents];

        // Get student information from the user
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter details for Student " + (i + 1) + ":");

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            System.out.print("CGPA: ");
            double cgpa = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline character

            students[i] = new Student(name, age, cgpa);
        }

        try (ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream("ObjectData1.dat"))) {
            // Write the array of students to the file
            objOut.writeObject(students);
            System.out.println("Student data has been written to the file.");
        } catch (IOException ex) {
            System.out.println("IO Exception: " + ex);
        }

        try (ObjectInputStream objIn = new ObjectInputStream(new FileInputStream("ObjectData1.dat"))) {
            // Read the array of students from the file
            Student[] studentsCopy = (Student[]) objIn.readObject();

            // Display the student information
            System.out.println("Student data read from the file:");
            for (Student student : studentsCopy) {
                System.out.println(student);
            }
        } catch (IOException ex) {
            System.out.println("IO Exception: " + ex);
        }

        scanner.close();
    }
}
