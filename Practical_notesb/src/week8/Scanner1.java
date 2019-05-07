package week8;

import java.io.*;
import java.util.*;

public class Scanner1 {
	public static void main(String arg[]) {

		Scanner input = null;
		String line = null;

		try {
			input = new Scanner(new FileInputStream("output.txt"));

		} catch (FileNotFoundException e) {
			System.err.println("No Such File.");
			System.exit(0);
		}

		while (input.hasNextLine()) {
			line = input.nextLine();
			System.out.println(line);
		}
		input.close();
	}
}