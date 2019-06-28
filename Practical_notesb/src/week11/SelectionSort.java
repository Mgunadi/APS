package week11;

public class SelectionSort {
	public static void main(String[] args) {

		String[] strlist =  new String[] { "x", "f", "e", "c", "i", "b", "a", "d" };
		Integer[] numlist = new  Integer[] { 11, 72, 55, 4, 9, 61, 17, 43, 20};
		
		selectionSort(strlist); //a b c d e f i x
		selectionSort(numlist);  //4 9 11 17 20 43 55 61 72
		
		for(String t: strlist){	System.out.print(t + " ");}
		System.out.println();
		for(Integer t: numlist){ System.out.print(t + " ");}
	}

	public static <T extends Comparable> void selectionSort(T[] numbers) {
		int min;
		T temp;
		for (int i = 0; i < numbers.length - 1; i++) {
			min = i;
			for (int scan = i + 1; scan < numbers.length; scan++)
				if (numbers[scan].compareTo(numbers[min])< 0)
					min = scan;
			// swap the values
			temp = numbers[min];
			numbers[min] = numbers[i];
			numbers[i] = temp;
		}
	}

}
