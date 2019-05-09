package exceptions;
import java.util.*;

public class Recovery{
    public static void main(String[] args){
    Scanner console = new Scanner(System.in);

    int i, j, ans=1;
    boolean okay = false;


    System.out.print("Enter numerator : ");
    i = console.nextInt();
    
    do {
    	try {
    		System.out.print("Enter demoninator : ");
    		j  = console.nextInt();
    		ans = divide(i,j);
    		okay = true;
    	} 
    	catch(ArithmeticException e) {    		

             e.printStackTrace();		
    		System.out.println("Value for denominator cannot be 0");
    	 }
    } while ( !okay );
    
       System.out.println("Answer is " + ans);
    }

    public static int divide(int num, int den) throws ArithmeticException  {
       return num/den;
    }
}

