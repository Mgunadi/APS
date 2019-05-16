package revision;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Polymorphism_start {

	public static void main(String[] args) {  //no need to throw Exception if the Exception is handled in a handler. (would have needed it because error would propogate form increment()
		Polymorphism ButlerStory = new Polymorphism();
		//ButlerStory.initialize();
		//ButlerStory.part2();
		//ButlerStory.pracCollections();
		//ButlerStory.Collections();
		//ButlerStory.LinkedList();
		/*
		 * Butler s1 = new Scott(30, "nike", new Job("Pageup", 70000.0), new
		 * Disposition("Happy")); Butler c1 = new Craig(new Job("contractor", 50000.0));
		 * ButlerStory.markFace(s1); System.out.println(s1.face);
		 * ButlerStory.markFace(c1); System.out.println(c1.face); ButlerStory.part3();
		 */
		try {
			increment();
		} catch (ChooseZeroException c) {
			System.out.println(c.message);
		}
		
	}
	
	public static void increment() throws ChooseZeroException{
		  int a = 10; 
	      int b = ++a; 
	      int c = b++ + a++;
		  int input = 0;
	      Scanner reader = new Scanner(System.in);
	      
	      try {
	    	  System.out.println("Enter a number: ");
	    	  input = reader.nextInt();
	    	  if (input == 0 || input == 1) 
	    		  throw new ChooseZeroException("Cannot be this number:", input);
	    	  } catch(InputMismatchException e) {
	    		  System.out.println("You have failed to choose a number.");
	    	  }
	      
		  // uncomment below line to see error  
	      // b = 10++; 
	  
	      System.out.println("c = " + c);
	      System.out.println(a);
	      System.out.println(c/input); 	
	}
}

class ChooseZeroException extends Exception{
	String message;
	ChooseZeroException(String s, Integer i ){
		this.message = s + " " + i;
	}
	
}