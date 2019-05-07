package week6;
import java.util.*;
public class GenericInherit {
	public static void main(String args[]) {

		UnorderedPair<String, Integer> pair1 = new UnorderedPair<String,Integer>("15", 25);
		Pair4<Integer, String> pair2 = new Pair4<Integer, String>(25, "15");

		if (pair1.equals(pair2))
			System.out.println("Pars 1 & 2 Equal");
		else
			System.out.println("Pairs 1 & 2 Not Equal");
	}
}

 
class UnorderedPair<U, V> extends Pair4<U,V>
{
	public UnorderedPair() {super();}
	
	public UnorderedPair(U first, V second) {
		super(first, second);
	}


	public boolean equals(Object otherObject){
		boolean comp1 = super.equals(otherObject);
		boolean comp2 = (new Pair4<U,V>((U)getSecond(),(V)getFirst()).equals(otherObject));  //see if swapping the pair will give an 'equal' result
																							//first create a swapped pair then do the equals computation again.
			
		return (comp1 || comp2);
	}
}

class Pair4<U, V> {
	private U first;
	private V second;
	
	public Pair4() {
		first = null;
		second = null;
	}
	
	public Pair4(U first, V second) {
		this.first = first;
		this.second = second;
	}

	public U getFirst(){return first;}
	public V getSecond(){return second;}

	public boolean equals(Object otherObject) {
		if (otherObject == null)
			return false;
		if (getClass() != otherObject.getClass())
			return false;
		
		Pair4<U, V> otherPair = (Pair4<U, V>) otherObject;
		
		return (first.equals(otherPair.first) && second
				.equals(otherPair.second));
	}
}

