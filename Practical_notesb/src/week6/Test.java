package week6;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
	Scanner sc = null;
			try {
				System.out.println("In try block");
				sc = new Scanner(new File("file1.txt"));
				String line = sc.nextLine();
				System.out.println(line);
			} catch (FileNotFoundException e) {    //if this is not checked like it is now, a nullpointerexceptin would have appeared.
				System.out.println("in catch block");
				System.out.println(e.getMessage());
				e.printStackTrace();
			} finally {//executed whether or not exception happens
				System.out.println("In finally block");
				if(sc != null) {
					System.out.println("Scanner is closed.");
					sc.close();
				}
			}

	}

}
