package exam;

public class Test1 {

	// using a generic method
	public static void main(String[] args) {
		String s[] = { "Apples", "Oranges", "Grapes" };
		Integer numsInteger[] = { 55, 42, 98, 70, 5 };
		Double numsDouble[] = { 34.5, 19.7, 20.12, 0.3, -5.0 };
		
		// when calling a generic method, compiler can infer
		// the generic type based on the type of input parameter
		String minString = findMin(s);
		Integer minInt = findMin(numsInteger);
		Double minDouble = findMin(numsDouble);
		
		System.out.println("minString: " + minString);
		System.out.println("minInt: " + minInt);
		System.out.println("minDouble: " + minDouble);
		
		String maxString = findMax(s);
		System.out.println("maxString: " + maxString);
		
		Integer maxInteger = findMax(numsInteger);
		System.out.println("maxInteger: " + maxInteger);
		
		Double maxDouble = findMax(numsDouble);
		System.out.println("maxDouble: " + maxDouble);
		
		
	}
	// <T> is the type parameter. After a type parameter is
	// defined, it can be used as a return type and parameter type
	// of the method
	// T extends Comparable<T> means the type T must implement
	// Comparable<T> interface, so that compareTo method can 
	// be used to compare one object of type T with another
	// object of type T.
	public static <T extends Comparable<T>> T findMin(T[] array) {
		T min = array[0]; // assume that the first element
						  // is the minium element.
		// create a for loop to through each of the remaining
		// element in the array
		for(int i = 1; i < array.length; i++) {
			if(array[i].compareTo(min) < 0) {
				// if there is an element less than minimum
				min = array[i]; // update the minimum
			}
		}
		// after for loop, we're guaranteed that min store
		// the minimum element
		return min;
	}
	
	public static <T extends Comparable<T>> T findMax(T[] array) {
		T max = array[0];
		for(int i = 1; i < array.length; i++) {
			if(array[i].compareTo(max) > 0) {
				max = array[i];
			}
		}
		return max;
	}

}
