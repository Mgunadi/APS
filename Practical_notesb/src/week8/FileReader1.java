package week8;

import java.io.*;
import java.util.*;
public class FileReader1 {
	public static void main(String arg[]) {

		FileReader input = null;

		try {
			input = new FileReader("output.txt");

			int next = input.read();

			while (next != -1) {
				System.out.print((char) next);
				next = input.read();
			}
			input.close();

		} catch (IOException e) {
			System.err.println("File Reading Error!");
			System.exit(0);
		}
	}
}