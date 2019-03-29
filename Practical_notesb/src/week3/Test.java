package week3;

public class Test {

    public static void main(String[] args)
    {   
        Overloading test = new Overloading();
    	
        test.ambiguousMethod(1);              // It is an integer  

        double a = 1;

        test.ambiguousMethod(a);              // It is a double 
        
    	test.ambiguousMethod2(1, 2.0);              // OK
    	
    	test.ambiguousMethod2(1.0, 2);              // OK 

    	//test.ambiguousMethod2(1, 2);                // Error!

    	//test.ambiguousMethod2(1.0, 2.0);            // Wrong!
    	
    	
    	//Creating objects in constructor example.
    	Customer david = new Customer("David", "Brown", 58);
    	Account dad = new Account("s234", david, 2000);
    	
    	//Superclass Reference example.
    	SAccount sister = new SAccount("s123", "judy Brown", 1000, 200);
    	sister.deposit(500);
    	sister.withdraw(1000);
    	sister.addInterest(5.8);
    	
    	//Type Casting example
    	Account brother = new SAccount("S12345", "Sayed Ali", 1000, 200);
    	((SAccount) brother).addInterest(5.8);
   }
	
}
