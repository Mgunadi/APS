package revision;
import java.util.*;

public class ArrayTool {
	
	public static void main(String[] args) {
		String s[] = { "Apples", "Oranges", "Grapes" };
		Integer num1[] = { 55, 42, 98, 70, 5 };
		Double num2[] = { 34.5, 19.7, 20.12, 0.3, -5.0};
		
		System.out.println(ArrayTool.findMax(s));
		System.out.println(ArrayTool.findMin(s));
		System.out.println(ArrayTool.findMax(num1));
		System.out.println(ArrayTool.findMin(num1));
		System.out.println(ArrayTool.findMax(num2));
		System.out.println(ArrayTool.findMin(num2));
	}
	
	public static <T extends Comparable<T>> T findMax(T[] array) {
		T max = array[0];
		for (T elem: array) {
			if (elem.compareTo(max) > 0) {
				max = elem;
			}
		}
		return max;
		//array.sort(array, new GenComparator());
	}
	
	public static <T extends Comparable<T>> T findMin(T[] array) {
		T min = array[0];
		for (T elem: array) {
			if (elem.compareTo(min) < 0 ) {
				min = elem;
			}
		}
		return min;
	}
}

class TestArray {
	
	public static void main(String[] args) {
		String s[] = { "Apples", "Oranges", "Grapes" };
		Integer num1[] = { 55, 42, 98, 70, 5 };
		Double num2[] = { 34.5, 19.7, 20.12, 0.3, -5.0};
		
		System.out.println(ArrayTool.findMax(s));
		System.out.println();
		System.out.println(ArrayTool.findMin(s));
		System.out.println();
		System.out.println(ArrayTool.findMax(num1));
		System.out.println(ArrayTool.findMin(num1));
		System.out.println(ArrayTool.findMax(num2));
		System.out.println(ArrayTool.findMin(num2));
	}
}


/*
 * class GenComparable implements Comparable<T>{
 * 
 * @Override public <T> Object compareTo(T a, T b) { return a.compareTo(b); }
 * 
 * }
 */