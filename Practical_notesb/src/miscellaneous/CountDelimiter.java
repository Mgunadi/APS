package miscellaneous;
import java.util.Arrays;

public class CountDelimiter {
	static String a = "der";
	static String b = "dd";
	static String c = "dfdf";
	public static void main(String[] args) {
	    String s = "1|2|3|4|5|2|2|3|4|123441|234556|67783|56764|55454";
	    String[] strArr = s.split("\\|");
	    System.out.println("Array : " + Arrays.toString(strArr));
	    System.out.println("Delimiter count : " + (strArr.length - 1)); // Prints 13
	    System.out.println("7th field : " + strArr[7]); // Prints 3
	    
	    System.out.println(String.format("%s, dfd, %s, sdfasf, %s", a, b , c));
	   // System.out.println(Integer.parseInt(strArr2[2]));
	}
}
