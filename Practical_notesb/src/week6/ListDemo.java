package week6;
import java.util.*;

public class ListDemo {
	public static void main(String[] args) {


		List s = new ArrayList();

		for (Object a : args)
			s.add(a);

             shuffle(s, new Random());

		System.out.println(s.size() + " elements in the list " + s);

	}

	static void swap(List a, int i, int j) {
		Object tmp = a.get(i);
		a.set(i, a.get(j));
		a.set(j, tmp);
	}

 

	static void shuffle(List a, Random rnd) {
		for (int i = a.size(); i > 1; i--)
			swap(a, i - 1, rnd.nextInt(i));
	}
}