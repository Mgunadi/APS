package week8;

import java.io.*;

public class BufferedReader1 {
	public static void main(String arg[]) {

		try {
			BufferedReader input = new BufferedReader(new FileReader("output.txt"));

			String next = input.readLine();  //reads line by line rather than the Filereader

			while (next != null) {
				System.out.println(next);
				next = input.readLine();
			}
			input.close();

		} catch (IOException e) {
			System.err.println("File Reading Error!");
			System.exit(0);
		}
	}
}