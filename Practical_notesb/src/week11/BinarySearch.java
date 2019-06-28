package week11;

public class BinarySearch {
	public static void main(String[] args) {
		
		String[] strlist = new String[]{"a","b","c","d","e","f","g","h"};		
		Integer[] numlist = new Integer[]{1,2,3,4,5,6,8,9,11};

		System.out.println("Found at position " + binarySearch(strlist, "h"));
		System.out.println("Found at position " + binarySearch(numlist, 5));	
	}

	public static <T extends Comparable> int binarySearch(T[] list, T target) {
		int index, left = 0, right = list.length - 1;
		
		while (left <= right) {
			index = (left + right) / 2;

			if (target.compareTo(list[index])==0)
				return index;

			if (target.compareTo(list[index])>0)
				left = index + 1;
			else
				right = index - 1;
		}

		return -1;
	}
}

