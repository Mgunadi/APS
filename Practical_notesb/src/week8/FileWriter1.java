package week8;

import java.io.*;

public class FileWriter1 {

	public static void main(String arg[]) {

		FileWriter writer = null;

		try {
			writer = new FileWriter("output.txt");

			writer.write("Dickery Dickery Dock. The\n");
			writer.write("mouse ran up the clock.\n");
			writer.write("The clock strucked one, \n");

			writer.close();// flushes the stream.

		} catch (IOException e) {
			System.err.println("File cannot be created, or cannot be opened");
			System.exit(0);
		}
	}
}