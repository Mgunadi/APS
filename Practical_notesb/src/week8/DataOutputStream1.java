package week8;

import java.io.*;

public class DataOutputStream1 {
	public static void main(String arg[]) {
		try {
			DataOutputStream output = new DataOutputStream( new FileOutputStream("output1.dat"));
			output.writeInt(1);
			output.writeChar('X');
			output.writeBoolean(true);
			output.writeDouble(10.55);
			output.close();

		} catch (IOException e) {
			System.err.println("File Error!");
			System.exit(0);
		}
	}
}

