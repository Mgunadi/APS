package week6;

import java.util.*;

public class ListDemo3 {
    public static void main(String[] args) {


	List list = Arrays.asList(args);
	Collections.shuffle(list);

	//iterating forward
	for (ListIterator it = list.listIterator(); it.hasNext();) {
		Object t = it.next();
		System.out.print(it.nextIndex() + ": ");
		System.out.println(t);
	}
	System.out.println();
	//iterating backward
	for (ListIterator it = list.listIterator(list.size()); it.hasPrevious();) {
		Object t = it.previous();
		System.out.print(it.previousIndex() + ": ");
		System.out.println(t);
	 }
    }
}

