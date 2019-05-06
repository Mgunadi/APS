package week6;

import java.util.*;

// This example uses existing methods from Class Arrays and Class Collections to perform ListDemo objectives.
public class ListDemo2 {
	public static void main(String[] args) {

		List list = Arrays.asList(args);
		Collections.shuffle(list);
		System.out.println(list);
		
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
	
		}
	}
}


