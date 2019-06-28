package week11;

import java.util.LinkedList;

public class TestStack {
	public static void main(String[] args) {
		
		//Implement the stack as a LinkedList (also can use Stack, a subclass of Vector)
		LinkedList<String> list = new LinkedList<String>();

		//push - add from the front
		list.push("A");                 //available after Java 6
		list.push("B");
		list.push("C");

		//pop - remove from the front
		while(! list.isEmpty()){
			System.out.println(list.pop()); //available after Java 6
		}


		//prints C B A
	}
}


