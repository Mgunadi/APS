package week6;
import java.util.*;

public class MultiplePair {
	public static void main(String args[]) {

		Pair3<String, Integer> pair1 = new Pair3<String, Integer>("10 + 5", 25);
		Pair3<String, Integer> pair2 = new Pair3<String, Integer>("15", 20+ 5);

		if (pair1.equals(pair2))
			System.out.println("Pars 1 & 2 Equal");
		else
			System.out.println("Pairs 1 & 2 Not Equal");
	}
}

class Pair3<U, V> {
	private U first;
	private V second;
	
	public Pair3() {
		first = null;
		second = null;
	}
	
	public Pair3(U first, V second) {
		this.first = first;
		this.second = second;
	}

	public boolean equals(Object otherObject) {
		if (otherObject == null)
			return false;
		if (getClass() != otherObject.getClass())
			return false;
		
		Pair3<U, V> otherPair = (Pair3<U, V>) otherObject;
		
		return (first.equals(otherPair.first) && second
				.equals(otherPair.second));
	}
}

