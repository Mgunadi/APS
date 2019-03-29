package week3;

public class Overloading {

	   public void ambiguousMethod(double num){        // Be careful   
	      System.out.println("It is a double");
	   }

	   public void ambiguousMethod(int num){      

	      System.out.println("It is an integer");
	   }
	

	   public void ambiguousMethod2(double num1, int num2){

	      System.out.println("A double then an integer");                
	   }

	   public void ambiguousMethod2(int num1, double num2){

	      System.out.println("An integer then a double");
	   }
}
