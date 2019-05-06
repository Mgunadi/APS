package exceptions;

public class Throwing2 {
    public static void main(String[] args)
    { 
        int a = 10; 
        int b = 0; 
      
        try{
            Arith4.divide(a, b );
  	  	}
  	  	catch(Exception e){
            System.err.println(e.getMessage());     // The message is produced by the method causing causing the error (propagated to this catch) 
            //but is told to display by this catch
  	  }
    }
}

/////////////////////////////////////////
class Arith4 {
    public static void divide(int a, int b) throws Exception //this method throws the exception
    { 
    	try {
    		System.out.println(a/b);
    	}
    	catch(Exception e) {
    		throw new Exception("My mistake");  //the exception must be thrown back to the original method that calls this one 'throw new'
    	}
    }
}
