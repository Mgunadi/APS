package week11;



public class TestRecursion {
	public static void main(String[] args) {
		//recursiveCall(10);
		sum(10);
	}

	//First recursion method
	static void recursiveCall(int i) {
		if (i > 0) {
			System.out.println(i);
			recursiveCall(i - 1);
			//System.out.println(i);   - if swapped, the order will be reversed.
		} else
			System.out.println("0");
	}
	
	//Second recursion method.
	static int sum(int i){
		if (i > 0){
			System.out.print(i + "+");
			return i + sum(i-1);
		}
		else {
			System.out.print("0=");
			return 0;
		}
	}
	
	
	
}

