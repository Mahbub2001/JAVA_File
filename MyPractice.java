import java.util.*;
import java.io.*;

class MyPractice {
    public static void main(String[] args) {
        int[] arr = new int[100];
        File f1 = new File("practice.txt");
        File f1Sort = new File("practice_Sort.txt");
        try {
            Scanner inFile = new Scanner(f1);
            FileWriter sortFile = new FileWriter(f1Sort);

            int i = 0;
            while (inFile.hasNextLine()) {
                if (inFile.hasNextInt()) {
                    arr[i] = inFile.nextInt();
                    i++;
                } else {
                    inFile.nextLine(); 
                }
            }
            int n = i;
            for (int j = 0; j < n; j++) {
                for (int j2 = j + 1; j2 < n; j2++) {
                    if (arr[j2] > arr[j]) {
                        int temp = arr[j2];
                        arr[j2] = arr[j];
                        arr[j] = temp;
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                sortFile.write(String.valueOf(arr[j]) + "\n");
            }
            inFile.close();
            sortFile.close();

        } catch (IOException e){

        }
    }}


// Scanner scanner = new Scanner(System.in);
// int n = scanner.nextInt();
// int[] arr = new int[n];

// for (int i = 0; i < arr.length; i++) {
// arr[i] = scanner.nextInt();
// }

// File f1 = new File("practice.txt");
// try {
// FileWriter filewriter = new FileWriter(f1);
// for (int i = 0; i < n; i++) {
// System.out.println(arr[i]);
// filewriter.write(String.valueOf(arr[i]) + "\n");
// }
// filewriter.close();

// } catch (IOException e) {
// System.out.println(e);
// }
// scanner.close();