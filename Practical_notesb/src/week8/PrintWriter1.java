package week8;

import java.io.*;

public class PrintWriter1 {

	public static void main(String arg[]) {

		PrintWriter writer = null;
		
		try {
			//writer = new PrintWriter("output.txt");
			
			writer = new PrintWriter(new FileOutputStream("output.txt", true));
			//appending the file
			
		} catch (FileNotFoundException e) {
			System.err.println("File cannot be created, or cannot be opened");
			System.exit(0);
		}
		
		writer.println("The mouse ran down,");
		writer.println("mouse ran up the clock.");
		
		writer.close();		
	}
}
