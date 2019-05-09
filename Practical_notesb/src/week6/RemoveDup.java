package week6;
import java.util.*;

public class RemoveDup {

	public static void main(String[] args) {
		ArrayList Duplicate = new ArrayList<String>();
		Duplicate.add("42");
		Duplicate.add("42");
		Duplicate.add("343");
		Collection noDups = new LinkedHashSet(Duplicate);
		Iterator it = noDups.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
	}
}
