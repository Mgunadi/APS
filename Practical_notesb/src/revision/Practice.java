package revision;
import java.util.Scanner;

public class Practice {

	public static void main(String[] args) {
		//scanner();
		//ops();
		//ternary();
		//switch2();
		//arrays();
		Boxing();
	}
	
	public static void types() {
				//char uni = '\u7686';
		//double sci = 1.2e3;
	
		double sci = 1.34;
		int sci2 = (int)sci;  //type cast
		
		double sci3 = sci2;
		System.out.println(sci2);
		System.out.println(sci3);
		
		System.out.println(Integer.toString(sci2));
	
		String two = "2";
		System.out.println(Integer.parseInt(two));
		System.out.println(Integer.parseInt(two) + sci);
		
		//print f
		System.out.printf("Integer: %d \nString: %s",sci2, two);
		
	}
	public static void scanner() {
		 Scanner keyboard = new Scanner(System.in);  

	      System.out.println("Enter the number of postgrads");
	      System.out.println("then the number of undergrads:");
	     

	      // read one integer from keyboard

	      int numberOfPG = keyboard.nextInt( );      
	      // read the second integer

	      int numberOfUG = keyboard.nextInt( );      


	      int totalNum = numberOfPG + numberOfUG;

	      System.out.print("There are " + numberOfPG + " postgraduate students ");
	      System.out.println("and " +         numberOfUG + " undergraduate students");
	      System.out.println("The total number of students is: "+ totalNum);
	}
	
	public static void ops() {
	       double a = 10.0;
	       double b = 20.0;

	       double aver =  a + b  / 2;
	       System.out.println("avg. of a and b = " + aver);
	}

	public static void ternary() {
		int result = 3;
		String check = (result < 5)? "True" : "False";
		System.out.println(check);
	}
	
	public static void switch2(){
		int value = 2;
		
		switch(value + 3) {
		case 5:
			System.out.println("THe value is 2");
			break;
		case 3:
			System.out.println("The value is 0");
			break;
		}
	
	}
	
	public static void encapsulate() {
		new String("3"); //cannot access.
		String One = new String("3");
		String Two = One;
	}
	
	public static void arrays() {
		int[] list = new int[4];
		double list2[] = {2.3, 4, 5.3};
		String hey = "sdf3d";
		list[0] = 1;
		System.out.println(list.length);
		System.out.println(hey.length());
	}
	
	public static void Boxing() {
		int a = 45;
		Integer boxedInt = new Integer(a);
		System.out.println(boxedInt.toString());
		
		//unbox
		int unboxed = boxedInt.intValue();
		
	}
}
