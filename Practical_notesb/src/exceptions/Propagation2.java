package exceptions;

public class Propagation2{
    public static void main(String[] args)
    { 
       int a = 10; 
       int b = 0; 
       
       try{

          Arith2.divide(a , b);

       }     
       catch(Exception e) {
    	   System.err.println("Error");
       }
      
       System.out.println("Done");   
    }
}

//////////////////////////////////////////

class Arith2 {


    public static void divide(int a, int b)
    { 
        System.out.println(a/b);	   
    }
}
