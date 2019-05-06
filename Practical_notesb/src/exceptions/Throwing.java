package exceptions;

public class Throwing{
    public static void main(String[] args)  //Here, the main method throws the exception - no need to write "throws Exception" because it is caught
    { 
        int a = 10; 
        int b = 0; 
      
        try{
            Arith3.divide(a, b );
  	  	}
  	  	catch(Exception e){
            System.err.println("My mistake");     // The message is produced by the catch clause
  	  }
    }
}

/////////////////////////////////////////
class Arith3 {
    public static void divide(int a, int b)
    { 
	    System.out.println(a/b);
    }
}