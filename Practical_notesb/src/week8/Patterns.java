package week8;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Patterns {

	public static void main(String[] args) {
		split();
		System.out.println();
		regex();
		System.out.println();
		pattern();

	}

	public static void split() {
		String s = "Hey this is just an example";
		for(String substring: s.split(" ")) {
			System.out.println(substring);
		}
	}
	
	public static void regex() {
		String s = "Hey:this,is:just,an example";
		for(String substring: s.split("( |,|:)")) {
			System.out.println(substring);
		}
	}
	
	public static void pattern() {
		 Pattern p = Pattern.compile("^\\d+ ");
		 Matcher m = p.matcher("2017 Expo");

		 if (m.find())
		     System.out.println("I have found the pattern!");
		 else
		     System.out.println("Pattern not found");
	}
	
}
