package exceptions;

public class Throwing3{

    // throws to the virtual Machine
    public static void main(String[] args) throws Exception // will give an ugly red Virtual Machine error message (as error thrown to VM)
    {   
        int a = 10; 
        int b = 0; 
      
        Arith5.divide(a, b );
    }
}
//////////////////////////////////////////

class Arith5 {
    public static void divide(int a, int b) throws Exception
    { 
        try{		
	     System.out.println(a/b);
        }
        catch(Exception e){
            throw new Exception("My mistake");
        }
    }
}