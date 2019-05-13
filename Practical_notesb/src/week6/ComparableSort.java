package week6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableSort {

	public static void main(String[] args) {
		List <String> Accounts = new ArrayList<String>();
		Accounts.add("Hi");
		Accounts.add("My");
		Accounts.add("Matthew");
		Accounts.add("Joshua");
		
		System.out.println(Accounts);
		//here, sort extends Comparable interface not Comparator because Accounts (String) is of a type that can be naturally ordered.
		Collections.sort(Accounts);
		
		System.out.println(Accounts);
		
		
	}

}
