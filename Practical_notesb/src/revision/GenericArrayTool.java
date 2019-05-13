package revision;

public class GenericArrayTool <T extends Comparable<T>>{
	
	public T findMax(T[] a) {
		T max = a[0];
		for (T elem: a) {
			if (elem.compareTo(max) > 0) {
				max = elem;
			}
		}
		return max;
	}
	
	public T findMin(T[] a) {
		T min = a[0];
		for (T elem: a) {
			if (elem.compareTo(min) < 0 ) {
				min = elem;
			}
		}
		return min;
	}
	
	public static void main(String[] args) {
		String s[] = { "Apples", "Oranges", "Grapes" };
		Integer num1[] = { 55, 42, 98, 70, 5 };
		Double num2[] = { 34.5, 19.7, 20.12, 0.3, -5.0};
		
		String maxString = new GenericArrayTool<String>().findMax(s);
		System.out.println(maxString);
		Integer maxInt = new GenericArrayTool<Integer>().findMax(num1);
		System.out.println(maxInt);
		Double maxDouble = new GenericArrayTool<Double>().findMax(num2);
		System.out.println(maxDouble);
	}
}
