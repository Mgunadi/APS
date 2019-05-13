package exceptions;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TryCatchFinallyOrder {
	public static void main(String[] args) {
		Scanner sc = null;
		try {
			System.out.println("In try block");
			sc = new Scanner(new File("wrong name"));
			String line = sc.nextLine();
			System.out.println(line);
		} catch (FileNotFoundException e) {
			System.out.println("In catch block");
			System.out.println(e.getMessage());
		} finally { // will execute whether an exception is thrown or not
			System.out.println("In finally block");
			if(sc != null) {
				System.out.println("Scanner is closed");
				sc.close();
			}
		}
	}
}
