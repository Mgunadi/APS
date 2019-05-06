package exceptions;

public class Propagation1{
    public static void main(String[] args)
    { 
       int a = 10; 
       int b = 0; 
       
       Arith.divide(a , b);
    }
}

//////////////////////////////////////////

class Arith {
   public static void divide(int a, int b)
   {  try{
         System.out.println(a/b);
	}
	catch(Exception e){
         System.err.println("Error");
      }
   }
}


