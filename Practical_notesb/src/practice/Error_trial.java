package practice;
import java.util.*;


public class Error_trial {

	public static void main(String[] args) throws InputException {
	int no;
	while(true) {
		try {
			Scanner input = new Scanner(System.in);
			System.out.println("Enter number: ");
			no = input.nextInt();
			break;
		}
		catch(InputMismatchException e) {
			System.out.println("Must be a number.");
			continue;
		}
	}
	System.out.println(no);
	}
}
