import java.util.*;
import java.io.*;

class Student1 {
    String name;
    int age;
    double cgpa;

    Student1() {

    }

    Student1(String name, int age, double cgpa) {
        this.name = name;
        this.age = age;
        this.cgpa = cgpa;
    }

    public String toString() {
        return name + "\n" + age + "\n" + cgpa + "\n";
    }
}

class MyPractice2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // Student1[] arr = new Student1[n];

        // File f1 = new File("create_student.txt");
        // try {
        // FileWriter newWriter = new FileWriter(f1);
        // sc.nextLine(); // Consume the newline character after reading n
        // for (int i = 0; i < n; i++) {
        // String name = sc.nextLine();
        // int age = sc.nextInt();
        // double cgpa = sc.nextDouble();
        // sc.nextLine(); // Consume the newline character after reading cgpa
        // arr[i] = new Student1(name, age, cgpa);
        // newWriter.write(arr[i].toString());
        // }
        // newWriter.close();

        // } catch (Exception e) {
        // e.printStackTrace();
        // }

        Student1[] arr1 = new Student1[10];

        File f2 = new File("create_student.txt");
        File fileW = new File("practice_student_sort.txt");
        Student1 temp;
        double cgpa;
        int i = 0;
        try {
            Scanner fileReader = new Scanner(f2);
            FileWriter outFile = new FileWriter(fileW);
            while (fileReader.hasNextLine()) {
                String name = fileReader.nextLine();
                int age = fileReader.nextInt();
                double cg = fileReader.nextDouble();
                arr1[i] = new Student1(name, age, cg);
                System.out.println(arr1[i].toString());
                if (fileReader.hasNextLine()) {
                    fileReader.nextLine();
                }
                i++;
            }
            int n = i;
            for (i = 0; i < n - 1; i++)
                for (int j = i + 1; j < n; j++) {
                    if (arr1[i].cgpa < arr1[j].cgpa) {
                        temp = arr1[i];
                        arr1[i] = arr1[j];
                        arr1[j] = temp;
                    }
                }
            for (i = 0; i < n; i++)
                outFile.write(arr1[i].name + "\n" + arr1[i].age + "\n" + arr1[i].cgpa +
                        "\n");

            outFile.close();
            fileReader.close();
        } catch (IOException e) {

        }

    }
}
