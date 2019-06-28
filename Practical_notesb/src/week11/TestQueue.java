package week11;

import java.util.LinkedList;

public class TestQueue {
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();

		//add at the end		
		list.add("A");
		list.add("B");
		list.add("C");
	
		//remove the first element	
		while(! list.isEmpty()){
			System.out.println(list.remove()); 
		}

		//prints A B C
	}
}

