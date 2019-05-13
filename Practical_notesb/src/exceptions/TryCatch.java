package exceptions;

public class TryCatch {
	public static void main(String[] args) {
		int theValue = 30;
		try {
			System.out.println("Block entered");
			if (theValue > 10) 
				throw new Exception ("Value exceeded");
			System.out.println("Leaving the block");
		}
		catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
		}
		System.out.println("After catch block");
	// What is the output if we change the top line to
	// int theValue = 0;
	}
}
