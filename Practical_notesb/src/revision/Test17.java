package revision;

import java.util.HashSet;
import java.util.Set;
class Human {
Integer age ;
public Human( int age ) {
this . age = age ;
}
}
public class Test17{
public static void main(String[] args ) {
Set<Human> humans = new HashSet<Human>();
humans .add( new Human(13));
humans .add( new Human(33));
humans .add( new Human(21));
humans .add( new Human(21));
new Human(23);
for (Human entry: humans) {
	System.out.println(entry);
	
	//	System. out .println( humans .size());
}
}
}