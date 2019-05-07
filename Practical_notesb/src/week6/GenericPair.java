package week6;

public class GenericPair {
	public static void main(String args[]) {
		
		Pair<String> pair1 = new Pair<String>("10+5", "20+5");
		Pair<String> pair2 = new Pair<String>("15", "25");
		
		if (pair1.equals(pair2))
			System.out.println("Pairs 1 & 2 Equal");
		else
			System.out.println("Pairs 1 & 2 Not Equal");
		
		Pair<Integer> pair3 = new Pair<Integer>(10 + 5, 20 + 5);
		Pair<Integer> pair4 = new Pair<Integer>(15, 25);
		
		if (pair3.equals(pair4))
			System.out.println("Pairs 3 & 4 Equal");
		else
			System.out.println("Pairs 3 & 4 Not Equal");
	}
}

class Pair<T> {
	private T first;
	private T second;

	//Constructor headings do not include <T>
	public Pair() {
		first = null;
		second = null;
	}
	//Constructor headings do not include <T>
	public Pair(T first, T second) {
		this.first = first;
		this.second = second;
	}

	public boolean equals(Object otherObject) {
		if (otherObject == null)
			return false;
		if (getClass() != otherObject.getClass())
			return false;
		
		Pair<T> otherPair = (Pair<T>) otherObject;  //type cast to a pair - we don't know if it is a pair though, could not be.
		
		return (first.equals(otherPair.first) && second.equals(otherPair.second));

             //Shortcut, probable accessor methods should be defined.
	}
}
