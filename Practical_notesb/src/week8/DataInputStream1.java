package week8;
import java.io.*;

public class DataInputStream1 {
	public static void main(String arg[]) {
		try {

			DataInputStream input = new DataInputStream(new FileInputStream("output1.dat"));
			
			System.out.println(input.readInt());
			System.out.println(input.readChar());
			System.out.println(input.readBoolean());
			System.out.println(input.readDouble());

 

			input.close();

		} catch (IOException e) {
			System.err.println("File Reading Error!");
			System.exit(0);
		}
	}
}


