package exam;

import java.util.ArrayList;
import java.util.List;

public abstract class Person {

	
	public String name;
	
	public static void main(String[] args) {
		ArrayList<Person> sentient = new ArrayList<>();
		sentient.add(new Man("Michael"));
		sentient.add(new Woman("Lena"));
	}

	public abstract void PersonSays();


}