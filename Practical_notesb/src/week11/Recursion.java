package week11;

public class Recursion {
	// function to print the given pattern recursively
	static void printPatternRecur(int n, int i) {
	// base condition
		if (n < 1)
			return;
		// to print the stars of a particular row
		if (i <= n){
			System.out.print ( "* ");
		// recursively print rest of the stars of the row
			printPatternRecur(n, i + 1);
		}
		else {
		// change line
			System.out.println( );
		// print stars of the remaining rows recursively
			printPatternRecur(n - 1, 1);
		}
	}
	
	public static void main(String[] args) {
		printPatternRecur(5,2);
	}
	
}