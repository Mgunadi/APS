package exceptions;

public class Finally {
    public static void main(String[] args)
    { 
       int a = 10; 
       int b = 0; 
       
       try{
          System.out.println( a/b );
          System.out.println("Everything is fine");
       }     
       catch(Exception e) {  
    	   System.err.println("Error");
       }
       finally{
    	   System.out.println("Finally");
       }      


       System.out.println("Done"); 
    }
}
