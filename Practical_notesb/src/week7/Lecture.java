package week7;
import java.util.*;

public class Lecture {

	public static void main(String[] args) {
		List <String> checkbox = new ArrayList<String>();
		checkbox.add("Hi");
		checkbox.add("There");
		
		List <String> bigbox = new ArrayList<String>();
		bigbox.addAll(checkbox);
		
		for (String element:bigbox) {
			System.out.println(element);
			System.out.println();
		}
		
		ArrayList box = new ArrayList();
		box.add("First Element");
		
	}

}
