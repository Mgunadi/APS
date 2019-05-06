package exceptions;

public class Try_catch {
    public static void main(String[] args)
    { 
       int a = 10; 
       int b = 0; 
       
       try{
          System.out.println( a/b );

 

          System.out.println("Everything is fine");
       }     
       catch(Exception e) {
          System.err.println("Error");   //This is printed in red.
       }
      
       System.out.println("Done");
      
    }
}
