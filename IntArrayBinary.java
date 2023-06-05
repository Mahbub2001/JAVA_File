
import java.io.*;

public class IntArrayBinary {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		int array[] = { 101, 102, 103, 104, 105 };

		try (ObjectOutputStream fout = new ObjectOutputStream(new FileOutputStream("IntArrayData.dat"))) {
			fout.writeObject(array);
		} catch (IOException ex) {
			System.out.println("IO Exception: " + ex);
		}

		try (ObjectInputStream fin = new ObjectInputStream(new FileInputStream("IntArrayData.dat"))) {

			int newArray[] = (int[]) (fin.readObject());

			for (int i = 0; i < newArray.length; i++)
				System.out.println(newArray[i]);
		} catch (IOException ex) {
			System.out.println("IO Exception: " + ex);
		}

	}

}
