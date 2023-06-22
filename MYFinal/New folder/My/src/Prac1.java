import java.util.*;
import java.io.*;

class Pract_Student{
    String name;
    int roll;
    double total_marks;
    Pract_Student(){

    }
    Pract_Student(String name, int roll, double total_marks){
        this.name = name;
        this.roll = roll;
        this.total_marks = total_marks;
    }
    @Override
    public String toString() {
        
        return "Name : " + name + " Roll : " + roll + " Total marks : " + total_marks +"\n";
    }
}

public class Prac1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pract_Student[] pract_Student = new Pract_Student[10];
        Pract_Student temp;
        int i =0;
        File f1 = new File("prac1.txt");
        try {
            Scanner fr = new Scanner(f1);
            while (fr.hasNextLine()) {
                String name = fr.nextLine();
                int roll = fr.nextInt();
                double total_marks = fr.nextDouble();
                pract_Student[i] = new Pract_Student(name,roll,total_marks);
                if (fr.hasNextLine()) {
                    fr.nextLine();
                }
                i++;
            }
            fr.close();

        } catch (IOException e) {
        }

        for (int j = 0; j < i; j++) {
           System.out.println( pract_Student[j].toString());
        }

    }
}
