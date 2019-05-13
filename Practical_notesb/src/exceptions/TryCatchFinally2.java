package exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TryCatchFinally2 {
	public static void main(String[] args) {
		String line = readFirstLine("wrong name");
		System.out.println(line);
	}
	
	public static String readFirstLine(String fileName) {
		Scanner sc = null;
		try {
			System.out.println("In try block");
			sc = new Scanner(new File(fileName));
			String line = sc.nextLine();
			return line;
		} catch (FileNotFoundException e) {
			System.out.println("In catch block");
			System.out.println(e.getMessage());
			return null;
		} finally { // will execute whether an exception is thrown or not
			System.out.println("In finally block");
			if(sc != null) {
				System.out.println("Scanner is closed");
				sc.close();
			}
		}
	}
}