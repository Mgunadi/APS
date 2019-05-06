package week6;
import java.util.*;

public class Setstudy {

	public static void main(String[] args) {
		Set set1 = new HashSet();
		set1.add("Hello world");
		set1.add("SDflkj");
		set1.add(";alskjftt");
		Iterator setI = set1.iterator();
		while(setI.hasNext()) {
			System.out.println(setI.next()+ " ");
		}
	}

}
