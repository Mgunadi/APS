package week6;
import java.util.ArrayList;

public class ArrayListPair {
	public static void main(String args[]) {
		
		Pair2<String> pair1 = new Pair2<String>("10+5", "20+5");
		Pair2<String> pair2 = new Pair2<String>("15", "25");
		
		if (pair1.equals(pair2))
			System.out.println("Pairs 1 & 2 Equal");
		else
			System.out.println("Pairs 1 & 2 Not Equal");
		
		Pair2<Integer> pair3 = new Pair2<Integer>(10 + 5, 20 + 5);
		Pair2<Integer> pair4 = new Pair2<Integer>(15, 25);
		
		if (pair3.equals(pair4))
			System.out.println("Pairs 3 & 4 Equal");
		else
			System.out.println("Pairs 3 & 4 Not Equal");
	}
}


class Pair2<T> {
	private ArrayList<T> pair = new ArrayList<T>();

	public Pair2() {
	}

	public Pair2(T first, T second) {
		pair.add(first);
		pair.add(second);
	}
	
	public ArrayList<T> getList(){return pair;}

	public boolean equals(Object otherObject) {
		if (otherObject == null)
			return false;
		if (getClass() != otherObject.getClass())
			return false;

	Pair2<ArrayList<T>> otherPair = (Pair2<ArrayList<T>>) otherObject;

		return (getList().get(0).equals(otherPair.getList().get(0)) && getList().get(1).equals(otherPair.getList().get(1)));
	}
}