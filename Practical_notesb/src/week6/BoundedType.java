package week6;

public class BoundedType {
	public static void main(String args[]) {

		Pair5<String> pair1 = new Pair5<String>("second","first");
		System.out.println("Pair 1 : " + pair1.getFirst() + " and "+ pair1.getSecond());


		Pair5<Integer> pair2 = new Pair5<Integer>(25, 15);
		System.out.println("Pair 2 : " + pair2.getFirst() + " and "+ pair2.getSecond());

	}
}

class Pair5<T extends Comparable> {   //Types must be objects that extends/ implements Comparable
	private T first;
	private T second;

	public Pair5(T first, T second) {
		if (first.compareTo(second) <= 0)
			{this.first = first; 
			 this.second = second;
			}
		else
			{this.second = first;
			 this.first = second;
			}
	}

   public T getFirst(){return first;}
   public T getSecond(){return second;}
}


