package week6;

public class GenericMethod {
	public static void main(String args[]) {
		String s[] = {"Apples", "Oranges", "Grapes" };
		Integer nums[] = {30, 40, 50, 90, 80};  // Autoboxing
		
		String midS = GenMethods.<String> getMid(s);   //separate generic method for string
		Integer midN = GenMethods.<Integer> getMid(nums);   //separate generic method for integer
			
		//If this was a generic class example:
		//String midS = (new GenMethods<String>()).getMid(s);
		//Integer midN =(new GenMethods<Integer>()).getMid(nums);
		
		System.out.println("Mid String = " + midS);
		System.out.println("Mid Number = " + midN);
		
		System.out.println("Last String = " + GenMethods.<String> getLast(s));
		System.out.println("Last number = " + GenMethods.<Integer> getLast(nums));
		
		System.out.println();
		
		//actually the generic method type is inferred from the parameters:
		System.out.println("Mid String = " + GenMethods.getMid(s));
		System.out.println("Mid number = " + GenMethods.getMid(nums));
		System.out.println("Last Double = " + GenMethods.getLast(new Double [] {10.1,20.2,30.3}));
		
		System.out.println();
		
		System.out.println("** Testing Generic print **");
		
		
		GenMethods.<String>print(s);
		GenMethods.<Integer>print(nums);
	}
}

class GenMethods {
	public static <T> T getMid(T[] a) {
		return a[a.length /2];	
	}
	
	public static <T> T getLast(T[] a) {
		return a[a.length -1];
	}
	
	public static <T> void print(T[] a) {
		for (int i = 0; i < a.length; i++)
			System.out.println(a[i] + " ");
		System.out.println();
	}
}