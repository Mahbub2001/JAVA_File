import java.util.*;
import java.io.*;

public class Bin {
    public static void main(String[] args) {
        int[] a1 = {2,4,512,5,35};
        String[] a2={"my","name","is","turza"};
        double[] a3 = {2.333,23.3232,7.234,5.2335};

        try(DataOutputStream out = new DataOutputStream(new FileOutputStream("data.dat"))) {
            
            for (double d : a3) {
                out.writeUTF(String.valueOf(d));
                out.writeUTF(" ");
            }
            for (String d : a2) {
                out.writeUTF(d);
                out.writeUTF(" ");
            }
            for (int d : a1) {
                out.writeUTF(String.valueOf(d));
                out.writeUTF(" ");
            }

        } catch (IOException e) {
            
        }
        try(DataInputStream in = new DataInputStream(new FileInputStream("data.dat"))) {
            while(true){
                System.out.println(in.readUTF()+ " ");
            }
            
        } catch (IOException e) {
            // TODO: handle exception
        }

    }
}
// Integer.parseInt()