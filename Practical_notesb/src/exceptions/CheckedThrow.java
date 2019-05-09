package exceptions;
import java.io.*;

public class CheckedThrow{
   public static void main (String[] args)
                  throws IOException, NumberFormatException { //gives a compilation exception message even before it runs if IOException not thrown
	   
      BufferedReader stdin = new BufferedReader
         (new InputStreamReader (System.in));

      String string1, string2;
      int num1, num2, sum;
      
      System.out.println ("Input an integer");
      string1 = stdin.readLine();
      num1 = Integer.parseInt(string1);

      System.out.println ("Input another integer");
      string2 = stdin.readLine();
      num2 = Integer.parseInt(string2);

      sum = num1 + num2;
      System.out.print("The sum is: " + sum);
   }
}

