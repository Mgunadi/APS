package exam;

import java.util.ArrayList;
import java.util.List;

public class Stars {

	public static void main(String[] args) {
		ArrayList<String> input = new ArrayList<String>();
		input.add("Lawrence");
		input.add("Andy");
		input.add("Xiang");
		input.add("Nitin");
		input.add("Daniel");
		input.add("Jasbir");
		
		ArrayList<Integer> input2 = new ArrayList<Integer>();
		input2.add(1);
		input2.add(2);
		input2.add(3);
		input2.add(4);
		
		//q8();
		//countWords(input);

		//System.out.println(pop(input));
		System.out.println(pop2(input2));
	}

	
	public static void q7() {
	int n = 4;
		
		for (int i = 0; i < n; i ++) {
			for (int j = 1; j <= n; j ++) {
				if (j> i)
					break;
				System.out.println(" * ");
			}
		}
	}
	
	public static void q8() {
		int[] a = {1,2,3,4,5};
		for (int i = 1; i <= a.length; i++) {
			a[i] += a [i-1];
		}
	}
	
	public static void countWords(ArrayList<String> in) {
		
		int noA = 0;
		List<String> fiveChar = new ArrayList<String>();
		String fiveChar2 = "";
		
		for(int i = 0; i <in.size(); i++) {
			if (in.get(i).toUpperCase().startsWith("A")) {
				noA ++;
			}
			if(in.get(i).length() >5)
				fiveChar.add(in.get(i));
		}
		System.out.println("number of a-words: " + noA);
		for(String el: fiveChar) {
			fiveChar2 += " " + el;
		}
		System.out.println("Words longer than 5 characters: " + fiveChar2);
	}
		
	public static String pop(ArrayList<String>l) {
		String s = l.get(l.size()-1);
		l.remove(l.size()-1);
		return s;
	}
	
	public static <T> T pop2(ArrayList<T> l) {
		T s = l.get(l.size()-1);
		l.remove(l.size()-1);
		return s;
	}
}
	
	

